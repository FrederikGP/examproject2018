/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DB.DBHandler;
import handler.FileHandler;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import rss.Feed;
import rss.Message;

/**
 *
 * @author Frederik
 */
public class ExchangerateDAO {
    
    private Feed feed;
    private DBHandler dbHandler;
    private Connection con;
    
    
   public ExchangerateDAO(){
       this.feed= null;
       this.dbHandler = new DBHandler();
       
       try{
           this.con = this.dbHandler.connect();
       }catch(Exception e){
          
       }
   }
   
   public void setFeed(Feed feed){
       this.feed = feed;
   }
   
   private void updateExchangerate(){
      
    
   }
   
   public void insertExchangerateIntoDB(){
       String insert = "INSERT INTO content(title,description,published,amount,localCurrency,foreignCurrency,price,storeType,publishedInMill)";
       String values = "VALUES(";
       String valuesEnd = ");";
       String insertSQL = "";
       Statement stm = null;
       
       String content = "";
       String localCurrency = "";
       String foreignCurrency = "";
       String stringAmount = "";
       BigDecimal amount = null;
       String stringPrice = "";
       BigDecimal price = null;
       char[] contentArray;
       char[] numeric = getNumeric();
       String storeType ="Exchangerate";
       
       try{
          System.out.println("\nInserting into database...");
          stm = this.con.createStatement();
          for(int i = 0; i < this.feed.getMessageListLength(); i++){
              
            content = this.feed.getMessage(i).getDescription().trim();
            content = content.replace(" ","");
            contentArray = content.toCharArray();
              
            localCurrency = content.substring(content.length()-3, content.length());
            foreignCurrency = content.substring(3,6);
          
            for(int j = 0; j<contentArray.length; j++){
               
                for(int k = 0; k < numeric.length; k++){
                    if(contentArray[j] == numeric[k]){
                        stringAmount += contentArray[j];
                    }
                   
                }
                if(contentArray[j] == 'k'){
                    break;
                }
            }
           
            amount = new BigDecimal(stringAmount);
            stringAmount = "";
            stringPrice = content.substring(12, content.length()-3);
            stringPrice = stringPrice.replace(",", ".");
            price = new BigDecimal(stringPrice);
            String publishedInMill = ""+exchangerateInsertedTomill(this.feed.getMessage(i).getPubDate());
            
            insertSQL = insert+values+"'"+this.feed.getMessage(i).getTitle()+"','"+this.feed.getMessage(i).getDescription()+"','"+this.feed.getMessage(i).getPubDate()+
                    "','"+amount.toString()+"','"+localCurrency+"','"+foreignCurrency+"','"+price.toString()+"','"+storeType+"','"+publishedInMill+"'"+valuesEnd;
            stm.execute(insertSQL);
            }
          
           System.out.println("The data was succesfully inserted into the database");
           
       }catch(Exception e){
           System.out.println("\nCould not Insert data to database: "+e.getMessage());
       }finally{
           try{
           if(stm != null){stm.close();}
           }catch(SQLException sqlE){
               System.out.println(sqlE.getMessage());
           }
       }
       setFeed(null);
     
       
   }
   
   
   
   
   //
   public void getHighestUpdateMillExchangerate(){
       Statement stm = null;
       ResultSet resultSet = null;
       String select = "SELECT MAX(publishedInMill) AS higestMill FROM content ";
       FileHandler fileh = new FileHandler();
       String[] currencies = fileh.readExchangerateFile();
       String millFromDB = "";
       
       for(int i = 1; i < currencies.length; i++){
           String where = "WHERE foreignCurrency ='"+currencies[i]+"' AND storeType ='Exchangerate';";
           String selectSQL = select+where;
           try{
           stm = con.createStatement();
           resultSet = stm.executeQuery(selectSQL);
           
           while(resultSet.next()){
               millFromDB = resultSet.getString("higestMill");
               millFromDB = millFromDB.substring(0,millFromDB.length()-3);
           }
           
           for(int j = 0; j < this.feed.getMessageListLength(); j++){
               String feedMsgMill = ""+exchangerateInsertedTomill(this.feed.getMessage(j).getPubDate());
               feedMsgMill = feedMsgMill.substring(0, feedMsgMill.length()-3);
               long feedMsgMillLong = Long.parseLong(feedMsgMill);
               long millFromDBLong = Long.parseLong(millFromDB);
               
               if(feedMsgMillLong > millFromDBLong){
                   
               }
           }
           
           
           }catch(Exception sqlE){
               System.out.println(sqlE.getMessage());
           }
           
       }
       
       
   }
   
   
   public void uddateExchangeRate(){
       String select = "SELECT * FROM content";
       String where = "WHERE ";
   }
   
   
   public long exchangerateInsertedTomill(String published){
          long toMill = 0;
        Date date = new Date();
        String msgDate = published;
        msgDate.trim();
        msgDate = msgDate.replace(" ", "/");
        msgDate = msgDate.replace(":", "/");
        
        //exchangerate feed published looks like this: Thu, 21 Dec 2017 00:00:00 +0100
        
        String[] dateContent = msgDate.split("/");
        
        switch (dateContent[2]){
            case "Jan":
                dateContent[2] = "0";
                break;
            case "Feb":
                dateContent[2] = "1";
                break;
            case "Mar":
                dateContent[2] = "2";
                break;
            case "Apr": 
                dateContent[2] = "3";
                break;
            case "May":
                dateContent[2] = "4";
                break;
            case "June":
                dateContent[2] = "5";
                break;
            case "July":
                dateContent[2] = "6";
                break;
            case"Aug":
                dateContent[2] = "7";
                break;
            case"Sept":
                dateContent[2] = "8";
                break;
            case"Oct":
                dateContent[2] = "9";
                break;
            case"Nov":
                dateContent[2] = "10";
                break;
            case"Dec":
                dateContent[2] = "11";
                break;
            }
        
        
        
        int year = Integer.parseInt(dateContent[3])-1900;
        int month = Integer.parseInt(dateContent[2]);
        int day = Integer.parseInt(dateContent[1]);
        int hour = Integer.parseInt(dateContent[4]);
        int min = Integer.parseInt(dateContent[5]);
        int sec = Integer.parseInt(dateContent[6]);
        date.setYear(year);
        date.setMonth(month);
        date.setDate(day);

        toMill = date.getTime();
        return toMill;
   }
   
   
   
  public void insertOwnFeedToDB(){
      String insert = "INSERT INTO content(title,description,published,storeType,publishedInMill)";
      String values = "VALUES(";
      String valuesEnd = ");";
      String insertSQL = "";
      Statement stm = null;
      
      String storeType = "localNews";
      String toMill = "";
      
      try{
          stm = con.createStatement();
          
          for(int i = 0; i < this.feed.getMessageListLength(); i++){
             toMill = ""+ toMill(this.feed.getMessage(i)); 
             insertSQL = insert+values+"'"+this.feed.getMessage(i).getTitle()+"','"+this.feed.getMessage(i).getDescription()+"','"+this.feed.getMessage(i).getPubDate()+"','"+storeType+"','"+toMill+"'"+valuesEnd;  
             stm.execute(insertSQL);
          }
          
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      
      
  }
   
   
  
  
   
   
   
   
   
   
   
   private char[] getNumeric(){
   
       char[] numeric = new char[10];
       numeric[0] = '0';
       numeric[1] = '1';
       numeric[2] = '2';
       numeric[3] = '3';
       numeric[4] = '4';
       numeric[5] = '5';
       numeric[6] = '6';
       numeric[7] = '7';
       numeric[8] = '8';
       numeric[9] = '9';
       return numeric;
   }
   
   
   
       private long toMill(Message msg){
        long toMill = 0;
        Date date = new Date();
        String msgDate = msg.getPubDate();
        msgDate.trim();
        msgDate = msgDate.replace(" ", "");
        
        //Own feed looks like this: Fri-22-12-2017/23:58:00
        
        String[] dateContent = msgDate.split("/");
        
        int year = Integer.parseInt(dateContent[3])-1900;
        int month = Integer.parseInt(dateContent[2])-1;
        int day = Integer.parseInt(dateContent[1]);
        int hour = Integer.parseInt(dateContent[4]);
        int min = Integer.parseInt(dateContent[5]);
        int sec = Integer.parseInt(dateContent[6]);
        date.setYear(year);
        date.setMonth(month);
        date.setDate(day);
        date.setHours(hour);
        date.setMinutes(min);
        date.setSeconds(sec);
        toMill = date.getTime();
        
        Date daa = new Date();
        daa.setTime(toMill);
        return toMill;
        
   
    }
}
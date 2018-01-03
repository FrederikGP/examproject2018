/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import handler.FileHandler;
import DB.DBHandler;
import dao.ExchangerateDAO;
import java.io.File;
import java.sql.Connection;
import java.util.Date;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import model.rss.Feed;
import model.rss.FeedCollect;
import model.rss.GetRSSFromNB;
import model.rss.Message;

/**
 *
 * @author Frederik
 */
public class FeedController {
    
    private Feed feed;
    private Connection con;
    private GetRSSFromNB getRss;
    private ExchangerateDAO exrDao;
    private FileHandler fileH;
    
    
    public FeedController(){
        this.feed = null;
        this.exrDao = new ExchangerateDAO();
        this.fileH = new FileHandler();
        this.getRss = new GetRSSFromNB();
        }
    
    
    
    
    public void insertExchangerateToDB()throws Exception{
        
        String[]urls = this.fileH.readExchangerateFile();
        String url = urls[0];
        String completeUrl = "";
        
        for(int i = 1; i < urls.length; i ++){
            completeUrl = url + urls[i];
            this.getRss.setUrl(completeUrl);
            this.feed = this.getRss.readFeed();
            this.exrDao.setFeed(this.feed);
            this.exrDao.insertExchangerateIntoDB();
        }
        
        System.out.println("\nInsert completed");
        
    }
    
    
    
    public void createFeed(String title, String link, String description,String language){
        this.feed = new Feed();
        this.feed.setTitle(title);
        this.feed.setLink(link);
        this.feed.setDescription(description);
        this.feed.setLanguage(language);
    }
    
    public void resetFeed(){
        this.feed = new Feed();
    }
    
    public void addMessageToFeed(String title, String description){
        Message msg = new Message();
        msg.setTitle(title);
        msg.setDescription(description);
        msg.setPubDate(getDate());
        this.feed.addToMessageList(msg);
    }
    
    
    public void insertFeedToDB(){
        this.exrDao.setFeed(this.feed);
        this.exrDao.insertOwnFeedToDB();

        
        FeedCollect feedC = new FeedCollect();
        StreamFactory factory = StreamFactory.newInstance();
        factory.load("src/files/rssBeanIO.xml");
        BeanWriter writer = factory.createWriter("rss", new File("src/files/rss.xml"));
        Object record = null;
        
        
        feedC.setupFeed(this.feed);
        record = feedC;
        writer.write(record);
        writer.flush();
        writer.close();
        resetFeed();   
    }
    
    
    
    
    
    private String getDate(){
        Date date = new Date();
        int wkday = date.getDay();
        String weekday = ""; 
        
        switch (wkday){
            case 0:
                weekday = "Sun";
                break;
            case 1:
                weekday = "Mon";
                break;
            case 2:
                weekday = "Tue";
                break;
            case 3:
                weekday = "Wed";
                break;
            case 4:
                weekday = "Thu";
                break;
            case 5:
                weekday = "Fri";
                break;
            case 6:
                weekday = "Sat";
        }
        
        int month =1+date.getMonth();
        int year = date.getYear()+1900;
        int day = date.getDate();
        int hour = date.getHours();
        int min = date.getMinutes();
        int sec = date.getSeconds();
        
        
        String newDate = weekday+"/"+day+"/"+month+"/"+year+"/"+hour+"/"+min+"/"+sec;
        
        
        return newDate;
    }
    
   

    
   
    
}

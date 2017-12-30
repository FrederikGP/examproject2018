/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rss;

import java.util.ArrayList;

/**
 *
 * @author Frederik
 */
public class Feed {
    
    private String title;
    private String link;
    private String description;
    private String language;
    
    private ArrayList messageList;
    
    
    public Feed(){
    this.messageList = new ArrayList<Message>();
    //HEJ
    
    }
    
    public Feed(String title,String link,String description,String language){
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.messageList = new ArrayList<Message>();
    }

    public String getTitle() {return title;}
    public String getLink() {return link;}
    public String getDescription() {return description;}
    public String getLanguage() {return language;}

    public void setTitle(String title) {this.title = title;}
    public void setLink(String link) {this.link = link;}
    public void setDescription(String description) {this.description = description;}
    public void setLanguage(String language){this.language = language;}
    
    
   public void addToMessageList(Message message){
       this.messageList.add(message);
   }
   
   public int getMessageListLength(){
       int length = 0;
       length = this.messageList.size();
       return length;
   }
   
   
   public Message getMessage(int i){
       Message message =(Message) this.messageList.get(i);
       return message;
   }
    

public String toString(){
    String str ="";
    str = "Title: "+this.title+"\nLink: "+this.link+"\nDescription: "+this.description+"\nLanguage: "+this.language;
    for(int i = 0; i < this.messageList.size(); i++){
        str +="\n\n"+this.messageList.get(i).toString()+"\n\n";
    }
    return str;
} 
}
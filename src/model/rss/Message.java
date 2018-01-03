/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rss;

/**
 *
 * @author Frederik
 */
public class Message {
    
    private String title;
    private String description;
    private String pubDate;
    
    public Message(){
    }
    
    public Message(String title, String description, String pubDate){
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;    
    }

    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public String getPubDate() {return pubDate;}

    public void setTitle(String title) {this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setPubDate(String pubDate) {this.pubDate = pubDate;}
    
    public String toString(){
        String str = "";
        str = "Title: "+this.title+"\nDescription: "+this.description+"\nPublished: "+this.pubDate;
        return str;
    }
    
    
    
}

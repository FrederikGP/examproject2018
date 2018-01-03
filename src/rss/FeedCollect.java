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
public class FeedCollect {
    
   public Feed feed;
   public ArrayList messageList;
   
   public String title;
   public String link;
   public String description;
   public String language;
   public String rssversion;
    
   public FeedCollect(){
       this.feed = null;
   }
   
   public void setupFeed(Feed feed){
       this.feed = feed;
       this.messageList = this.feed.getMessageList();
       
       this.title = this.feed.getTitle();
       this.link = this.feed.getLink();
       this.description = this.feed.getDescription();
       this.language = this.feed.getLanguage();
       char r='"';
       String rssV = "version="+r+"2.0"+r;
       this.rssversion = rssV;
   }

    
}

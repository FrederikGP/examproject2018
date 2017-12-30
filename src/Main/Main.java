/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.FeedController;
import DB.DBHandler;
import View.MainFrame;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import rss.Feed;
import rss.GetRSSFromNB;

/**
 *
 * @author Frederik
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.setBounds(250, 50, 800, 800);
        
        /*
        try{
            FeedController fc = new FeedController();
            fc.insertExchangerateToDB();
            
        }catch(Exception e){
            
        }
       */
    }
    
}

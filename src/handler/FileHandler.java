/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Frederik
 */
public class FileHandler {
    
    private String[] urls;
    private String splitter;
    
    public FileHandler(){
        this.splitter = ",";
    }
    
    
    public String[] readExchangerateFile(){
        
        String content = "";
        int length = 0;
        
        String filename = "src/files/exchangerate.csv";
        Scanner textScan;

        System.out.print("\nLoading: "+ filename +"...");
        try {
            File file = new File(filename);
            textScan = new Scanner(file);
            while (textScan.hasNext()){
               content = textScan.nextLine();
            }
            System.out.println("\nLoading complete");
            textScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+e.getMessage());
        }
        
        this.urls = content.split(splitter);
            
        
        urls = urls;
        
        return this.urls;
    }
    
    
}

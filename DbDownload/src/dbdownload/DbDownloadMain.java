/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdownload;

import DataDownload.JavaApplication1;
import com.vibeosys.utils.dbdownloadv1.DbDownload;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akshay
 */
public class DbDownloadMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("D:\\appdb.sqlite");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dbUrl = "http://192.168.1.6/rorderwebapp/api/v1/downloadDb?restaurantId=123456&imei=911445101879588&info=eyJ1c2VySWQiOiIxIiwiaW1laSI6IjkxMTM5MzY1MDIxODM2MiIsImJvYXJkIjoiTVQ2NzM1IiwiYnJhbmQiOiJJTlRFWCIsIm1hbnVmYWN0dXJlciI6IklOVEVYIiwibW9kZWwiOiJDbG91ZCA0RyBTdGFyIiwicHJvZHVjdCI6IkNsb3VkXzRHX1N0YXIiLCJmbVZlcnNpb24iOjIxfQ==";
        DbDownload dbDownload = new DbDownload("eyJib2FyZCI6Ik1UNjczNSIsImJyYW5kIjoiSU5URVgiLCJtYW51ZmFjdHVyZXIiOiJJTlRFWCIsIm1vZGVsIjoiQ2xvdWQgNEcgU3RhciIsInByb2R1Y3QiOiJDbG91ZF80R19TdGFyIiwiZm1WZXJzaW9uIjoyMX0=", "f6d56cc9-ec14-4b53-bf03-ffcfca4c05c2", dbUrl, file);
        //DbDownload dbDownload1=new DbDownload(getBuild64BasedInfo(), uuid, dbUrl, dbFile);
        System.out.println(dbDownload.downloadDatabase());
    }
    
}

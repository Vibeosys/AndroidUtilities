package com.vibeosys.utils.dbdownloadv1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import sun.rmi.runtime.Log;

/**
 *
 * @author akshay
 */
public class DbDownload {
    
    private String buildInfo64Based;
    private String uuid;
    private String downloadDBURL;
    private File dbFile;
    
    public final String SUCCESS="Success";
    public final String FAIL="Fail";
    
    
    public DbDownload(String buildInfo64Based, String uuid, String downloadDBURL, File dbFile) {
        this.buildInfo64Based = buildInfo64Based;
        this.uuid = uuid;
        this.downloadDBURL = downloadDBURL;
        this.dbFile = dbFile;
     // downloadDatabase()
    }
    
    
    public String downloadDatabase() {
        boolean flag = false;
        HttpURLConnection urlConnection = null;
        OutputStream myOutput = null;
        byte[] buffer = null;
        InputStream inputStream = null;
        String message=FAIL;
        System.out.print(downloadDBURL);
        try {
            URL url = new URL(downloadDBURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            System.out.println("##Request Sent...");
           
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(10000);
            urlConnection.connect();

            int Http_Result = urlConnection.getResponseCode();
            String res = urlConnection.getResponseMessage();
            System.out.println(res);
            System.out.println(String.valueOf(Http_Result));
            if (Http_Result == HttpURLConnection.HTTP_OK) {
                String contentType = urlConnection.getContentType();
                inputStream = urlConnection.getInputStream();
                System.out.println(contentType);
                if (contentType.equals("application/octet-stream")) {
                     buffer = new byte[1024];
                    myOutput = new FileOutputStream(this.dbFile);
                    int length;
                    while ((length = inputStream.read(buffer)) > 0) {
                        myOutput.write(buffer, 0, length);
                    }
                    myOutput.flush();
                    myOutput.close();
                    inputStream.close();
                    flag = true;
                    message=SUCCESS;
                } else if (contentType.equals("application/json; charset=UTF-8")) {
                    message=FAIL;
                    flag = false;
                    String responce = convertStreamToString(inputStream);
                    System.out.println( responce);

                    try {
                        JSONObject jsResponce = new JSONObject(responce);
                        message = jsResponce.getString("message");
                    } catch (JSONException e) {
                       // addError(screenName, "Json error in downloadDatabase", e.getMessage());
                        System.out.println(e.toString());
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("##ROrder while downloading database" + ex.toString());
            //addError(screenName, "downloadDatabase", ex.getMessage());
        }
        return message;
    }
    
     static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}

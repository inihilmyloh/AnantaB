package com.pengaturan.otp;

import java.io.InputStream;
import java.util.Properties;

public class ELoader {
    private Properties properties;
    
    public ELoader(){
          properties = new Properties();
          try (InputStream input = getClass().getClassLoader().getResourceAsStream("config/config.properties")){
              
              if (input == null) {
                  System.out.println("File konfigurasi tidak ditemukan!");
                  return;
              }
              properties.load(input);
              
          } catch (Exception e){
            e.printStackTrace();
          } 
    }
    public String getProperty(String key) {
    return properties.getProperty(key);
    }
}
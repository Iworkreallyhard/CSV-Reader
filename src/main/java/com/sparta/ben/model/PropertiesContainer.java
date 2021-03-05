package com.sparta.ben.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesContainer {
    private static Properties properties = new Properties();
    private static String username;
    private static String password;
    private static String url;
    private static String csvLocation;

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }

    public static String getCsvLocation() {
        return csvLocation;
    }

    public static void createProperties(){
        try {
            properties.load(new FileReader("src/main/resources/login.properties"));
            username=properties.getProperty("userName");
            password=properties.getProperty("password");
            url=properties.getProperty("url");
            csvLocation=properties.getProperty("csvLocation");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

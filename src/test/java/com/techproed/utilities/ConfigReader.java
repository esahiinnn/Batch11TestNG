package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // ilk yapicagimiz islem instance olarak properties object'i olusturmak
    // bu object'i static block icerisinde kullanicagimdan dolayi static yapmam gerekiyor
    // bu object'i sadece bu class'da kullanicagim icin private yapmamiz onerilir
    static private Properties properties;

    static {

        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

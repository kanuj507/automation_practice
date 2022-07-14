package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public String basrUrl;
    public BaseClass() {
        load();
    }


    public void load() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        basrUrl = prop.getProperty("baseUrl");
    }
}

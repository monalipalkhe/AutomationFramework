package com.selenium.testcase.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\monali.palkhe\\eclipse-workspace\\AutomationFramework\\src\\Configuration\\config.properties"); // Correct path
            pro = new Properties();
            pro.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApplication() {
        return pro.getProperty("baseURL", "https://the-internet.herokuapp.com/login");  // Add default URL to prevent null value
    }

    public String getChromePath() {
        return pro.getProperty("chromepath", "C:/Users/monali.palkhe/eclipse-workspace/AutomationFramework/Driver/chromedriver.exe");  // Add default chrome path
    }
}

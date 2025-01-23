package TestEnv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.selenium.testcase.Utilities.ReadConfig;

public class BaseClass {
	
	public WebDriver driver;
    static ReadConfig readconfig = new ReadConfig(); // Initialize ReadConfig

    @BeforeClass
    public void setup() {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());

        // Initialize WebDriver and open URL
        driver = new ChromeDriver();
        driver.get(readconfig.getApplication());
    }

    @AfterClass
    public void teardown() {
        // Quit driver
        if (driver != null) {
            driver.quit();
        }
    }
}
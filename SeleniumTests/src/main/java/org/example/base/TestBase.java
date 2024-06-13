package org.example.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties config;
    public TestBase(){
        try{
            config = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/example/config/config.properties");
            config.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void inicialization(){
        String URl= config.getProperty("URL");
        String browser = config.getProperty("browser");

        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver =new FirefoxDriver();
                break;
            default:
                System.out.println("Błędna przegladarka");
                break;
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get(URl);

    }
    public void takeScreen(String testNumber){
        File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src,new File("src/main/resources"+testNumber+"screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getCurrentUrl(){
       String currentUrl = driver.getCurrentUrl();
       return currentUrl;
    }

    public String getTitlePage() {
        String title = driver.getTitle();
        return  title;
    }
}

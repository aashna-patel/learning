package com.mavenit.pageobjectprac.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    public static WebDriver driver;
    public String browser= "";
    public void openbrowser(){
        switch ((browser)){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver= new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;
        }
    }
    public void maximiseBrowser(){
        driver.manage().window().maximize();
    }
    public void navigateTo(String Url){
        driver.get(Url);
    }
}

package com.mavenit.pageobjectprac.pages;

import com.mavenit.pageobjectprac.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Homepage extends DriverFactory {
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public void dosSearch(String searchItem){
        driver.findElement(By.cssSelector("#searchTerm")).sendKeys(searchItem);
        driver.findElement(By.cssSelector("#searchTerm")).sendKeys(Keys.ENTER);
    }
}


package com.mavenit.pageobjectprac.pages;

import com.mavenit.pageobjectprac.driver.DriverFactory;
import com.mavenit.pageobjectprac.utils.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.fail;

public class resultsPage extends DriverFactory {
    public static List<String> getAllProductsName() throws InterruptedException {
        List<String> productNamesList = new ArrayList<>();

        List<WebElement> productWebElements = isProductsAvailable();
        for (WebElement indProduct : productWebElements) { //ind is a variable
            String actual = indProduct.getText();
            productNamesList.add(actual);
        }
        return productNamesList;
    }

    public static String getSearchTitle() {
        return driver.findElement(By.className("search-title__term")).getText();
    }

    public static String selectAnyProduct() {
        List<WebElement> productWebElements = isProductsAvailable();
        int productSize = productWebElements.size();

        int randomNumber = new helpers().randomNumberGenerator(productSize);
        WebElement selectedElement = productWebElements.get(randomNumber);
        String selectedProductName = selectedElement.getText();
        selectedElement.click();
        return selectedProductName;
    }

    private static List<WebElement> isProductsAvailable() {
        List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (productWebElements.size() == 0) {
            // fail("Zero products found .....");
            throw new RuntimeException("Zero products found .....");
        }
        return productWebElements;
    }
    public static void selectAnotherProduct(){
        driver.findElement(By.cssSelector("#searchTerm")).sendKeys("Nike Brasilia Just Do It Mini 11L Backpack - Black");
        driver.findElement(By.cssSelector("button[data-test='search-button']")).sendKeys(Keys.ENTER);
        List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
        if (productWebElements.size() == 0) {
            fail("No products found with:" + "nike");
        } else {
            driver.findElement(By.cssSelector("a[data-test='component-product-card-title']")).click();
        }
    }
}


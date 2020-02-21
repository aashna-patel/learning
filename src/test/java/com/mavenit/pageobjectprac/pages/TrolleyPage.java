package com.mavenit.pageobjectprac.pages;

import com.mavenit.pageobjectprac.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.hamcrest.Matchers.hasSize;

public class TrolleyPage extends DriverFactory {
    public static void addToTrolley() {
        driver.findElement(By.cssSelector("button[data-test='component-att-button']")).click();
    }

    public static void goToTrolley() {
        driver.findElement(By.cssSelector("a[data-test='component-att-button-basket']")).click();
    }

    public static String getProductInTrolley() {
        return driver.findElement(By.cssSelector(".ProductCard__content__9U9b1.xsHidden.lgFlex")).getText();
    }

    public static void addQuantity() {
        driver.findElement(By.cssSelector("select[data-e2e='product-quantity'] option[value='2']")).click();
    }

    public static String totalPrice() {
        return String.valueOf(driver.findElement(By.cssSelector(".Summary__totalInformation__2hwn3")).getText());
    }

    public static String currentPrice() {
        return String.valueOf(driver.findElement(By.cssSelector("span[data-e2e='product-line-price']")).getText());
    }

    public static void continueShopping() {
        driver.findElement(By.cssSelector("button[data-test='component-att-button-continue']")).click();
    }
    public static Integer twoProductsInTrolley(){
        return Integer.valueOf(driver.findElement(By.cssSelector(".LQbCV")).getText());
    }
}

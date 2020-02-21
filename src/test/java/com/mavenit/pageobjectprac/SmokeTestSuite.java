package com.mavenit.pageobjectprac;

import com.mavenit.pageobjectprac.pages.Homepage;
import com.mavenit.pageobjectprac.pages.TrolleyPage;
import com.mavenit.pageobjectprac.pages.resultsPage;
import gherkin.lexer.Th;
import gherkin.lexer.Tr;
import org.hamcrest.core.StringEndsWith;
import org.junit.Test;

import java.util.List;

import static com.mavenit.pageobjectprac.pages.resultsPage.getAllProductsName;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SmokeTestSuite extends Hooks {
    Homepage homepage = new Homepage();

    @Test
    public void searchTest() throws InterruptedException {
        String searchItem = "nike";
        homepage.dosSearch(searchItem);
        String url = homepage.getUrl();
        System.out.println("my url is " + url);
        assertThat(url, containsString(searchItem.replace(" ", "+")));
        Thread.sleep(5000);
        List<String> actualProductList = getAllProductsName();
        for (String product : actualProductList) ;
        assertThat(resultsPage.getSearchTitle(), is(equalToIgnoringCase(searchItem)));
    }

    @Test
    public void basketTest() {
        homepage.dosSearch("nike");
        String selectedProductName = resultsPage.selectAnyProduct();
        TrolleyPage.addToTrolley();
        TrolleyPage.goToTrolley();
        String actual = TrolleyPage.getProductInTrolley();
        assertThat(actual, is(equalToIgnoringCase(selectedProductName)));

    }

    @Test
    public void quantityTest() throws InterruptedException {
        homepage.dosSearch("nike");
        Thread.sleep(5000);
        String selectedProductName = resultsPage.selectAnyProduct();
        Thread.sleep(5000);
        TrolleyPage.addToTrolley();
        Thread.sleep(5000);
        TrolleyPage.goToTrolley();
        Thread.sleep(5000);
        String actual = TrolleyPage.getProductInTrolley();
        assertThat(actual, startsWith(selectedProductName));
        TrolleyPage.addQuantity();
        assertThat(TrolleyPage.totalPrice(), new StringEndsWith(TrolleyPage.currentPrice()));
    }

    @Test
    public void addTwoProducts() throws InterruptedException {
        homepage.dosSearch("nike");
        Thread.sleep(5000);
        resultsPage.selectAnyProduct();
        Thread.sleep(5000);
        TrolleyPage.addToTrolley();
        Thread.sleep(5000);
        TrolleyPage.continueShopping();
        Thread.sleep(5000);
        resultsPage.selectAnotherProduct();
        Thread.sleep(5000);
        TrolleyPage.addToTrolley();
        Thread.sleep(5000);
        TrolleyPage.goToTrolley();
        Integer actual = TrolleyPage.twoProductsInTrolley();
        hasSize(2);

    }
}
 

package com.mavenit.pageobjectprac;

import com.mavenit.pageobjectprac.driver.DriverFactory;
import org.junit.Before;

public class Hooks extends DriverFactory {
    DriverFactory factory= new DriverFactory();
    @Before
    public void setUp(){
        factory.openbrowser();
        factory.maximiseBrowser();
        factory.navigateTo("https://www.argos.co.uk");

    }
}

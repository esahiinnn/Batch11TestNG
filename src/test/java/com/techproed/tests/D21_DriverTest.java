package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class D21_DriverTest {

    @Test
    public void test(){
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://bestbuy.com");
        Driver.closeDriver();
    }
}

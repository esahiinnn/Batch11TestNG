package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D14_MouseAction3 extends TestBase {

    @Test
    public void test(){
        driver.get("https://amazon.com");

        Actions actions = new Actions(driver);

        //List'in ustune gel
        actions.moveToElement(driver.findElement(By.xpath("//a[@data-nav-role='signin']"))).perform();

        //create list'e tikla
        actions.click(driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"))).perform();

        //yourlist testi
        String message = driver.findElement(By.xpath("//div[@role='heading']")).getText();
        Assert.assertEquals(message, "Your Lists");

    }
}

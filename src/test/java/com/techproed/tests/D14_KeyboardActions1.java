package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class D14_KeyboardActions1 extends TestBase {

    @Test
    public void test(){
        driver.get("https://amazon.com");
        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        actions.click(searchBox).perform();
        actions.sendKeys("samsung").perform();
        actions.keyDown(Keys.LEFT_SHIFT).perform();
        actions.sendKeys(" a").perform();
        actions.keyUp(Keys.LEFT_SHIFT).perform();
        actions.sendKeys("71").perform();
        actions.sendKeys(Keys.ENTER).perform();

    }

    @Test
    public void test2(){
        driver.get("https://amazon.com");
        Actions actions = new Actions(driver);

        //
        WebElement searchBox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        actions.
                click(searchBox).
                sendKeys("Samsung").
                keyDown(Keys.SHIFT).
                sendKeys(" a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();


    }
}

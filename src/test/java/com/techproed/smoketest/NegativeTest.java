package com.techproed.smoketest;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {


    public void intro(){
        driver.get("http://qa-environment.crystalkeyhotels.com");

        //Log-in butonuna basin
        driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();

    }
    @Test
    public void invalidPassword() {
        intro();

        Faker faker = new Faker();
        String password = faker.internet().password();
        Actions actions = new Actions(driver);
        actions.
                click(driver.findElement(By.xpath("//input[@type='text']"))).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys(password).
                sendKeys(Keys.ENTER).perform();

        outro();
    }
    @Test
    public void invalidUsername(){

        intro();

        Faker faker = new Faker();
        String username = faker.internet().emailAddress();
        Actions actions = new Actions(driver);
        actions.
                click(driver.findElement(By.xpath("//input[@type='text']"))).
                sendKeys(username).
                sendKeys(Keys.TAB).
                sendKeys("Manager2!").
                sendKeys(Keys.ENTER).perform();
        outro();
    }
    @Test
    public void invalidBoth(){
        intro();

        Faker faker = new Faker();
        String username = faker.internet().emailAddress();
        String password = faker.internet().password();
        Actions actions = new Actions(driver);
        actions.
                click(driver.findElement(By.xpath("//input[@type='text']"))).
                sendKeys(username).
                sendKeys(Keys.TAB).
                sendKeys(password).
                sendKeys(Keys.ENTER).perform();
    outro();
    }

    public void outro(){
        WebElement incorrect = driver.findElement(By.xpath("(//li)[8]"));
        Assert.assertTrue(incorrect.isDisplayed());
    }
}
package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class D_12_IFrame {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
        //JavascriptExecutor Scrool = (JavascriptExecutor) driver;
        //Scrool.executeScript("window.scrollBy(0,500)");
        Actions actions = new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();

        //1.adim iFrame'e nasil gecis yapacagimiza(switch) karar veririz
        // index, id, WebElement olarak locate ederiz
        // biz bu soruda 3.yolu tercih ettik
        WebElement youtubeIFrame = driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));

        // 2.adim iFrame'e switchT() ile gecis yapiyoruz
        driver.switchTo().frame(youtubeIFrame);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();

    }

    @AfterClass
    public void tearDown() {
        //driver.close();
    }
}

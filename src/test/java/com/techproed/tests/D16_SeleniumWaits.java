package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class D16_SeleniumWaits extends TestBase {

    @Test
    public void test(){
        driver.get("https://youtube.com");

       // WebElement olmayanElement = driver.findElement(By.xpath("olmayan"));      15 Saniye

        WebElement youtubeLogo = driver.findElement(By.xpath("//div[@id=\"logo-icon-container\"]")); // 15 saniye icerisinde kac sn'de bulduysa o kadar bekler

        WebElement olmayanElement = driver.findElement(By.id("olmayanElement"));

    }

}

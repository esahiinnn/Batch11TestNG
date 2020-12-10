package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class D13_WindowHandle1 extends TestBase {

    @Test
    public void windowHandleTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //
        String ilkSayfaWindowHandle = driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandle);
        //CDwindow-90D052F30D31D857AF18D53B6C937F0B

        //Elemental Selenium linkine tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //
        Set<String> set = driver.getWindowHandles();
        System.out.println(set);
        
        String ikinciSayfaWindowHandle = "";
        for (String w: set) {
           if(!w.equals(ilkSayfaWindowHandle)){
               ikinciSayfaWindowHandle = w;
           }
        }

        driver.switchTo().window(ikinciSayfaWindowHandle);


        // h1 tagindaki yazinin Elemantal Selenium oldugunu test edelim
        String yazi = driver.findElement(By.tagName("h1")).getText();
        System.out.println(yazi);

    }
}

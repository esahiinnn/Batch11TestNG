package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

/*
1. Tests packagenin altina bir class oluşturalim : D14_FileDownload
2. Iki tane metod oluşturun : isExist() ve downloadTest()
3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
  - https://the-internet.herokuapp.com/download adresine gidelim.
  - image1.jpg dosyasını indirelim
4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test  edelim
 */
public class D15_Test extends TestBase {

    //2. Iki tane metod oluşturun : isExist() ve downloadTest()
    @Test(dependsOnMethods = "downloadTest")
    public void isExist(){
        //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test  edelim
        String homePath = System.getProperty("user.home");

        String filePath = homePath + "\\Downloads\\image.jpg";

        boolean isExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isExist);

    }

    @Test
    public void downloadTest() throws InterruptedException {
        //- https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //- image1.jpg dosyasını indirelim
        driver.findElement(By.linkText("image.jpg")).click();
        Thread.sleep(3000);
    }
}

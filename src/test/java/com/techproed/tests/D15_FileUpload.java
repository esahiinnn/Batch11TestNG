package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
1.Tests packagenin altina bir class oluşturun : D14_UploadFile
2.https://the-internet.herokuapp.com/upload adresine gidelim
3.chooseFile butonuna basalim
4. Yuklemek istediginiz dosyayi secelim.
5. Upload butonuna basalim.
6. “File Uploaded!” textinin goruntulendigini test edelim.
 */
public class D15_FileUpload extends TestBase {

    @Test
    public void xd(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //3.chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.
        String mainPath = System.getProperty("user.home");
        String filePath = mainPath + "\\Desktop\\FLOWER.jpg";
        chooseFile.sendKeys(filePath);

        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        String actualMessage = driver.findElement(By.tagName("h3")).getText();
        String expectedMessage = "File Uploaded!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}

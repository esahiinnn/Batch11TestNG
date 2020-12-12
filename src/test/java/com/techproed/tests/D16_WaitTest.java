package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait()
  Iki metod icin de asagidaki adimlari test edin.
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorundugunu test edin
 */
public class D16_WaitTest extends TestBase {

    @Test
    public void implicitlyWait() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("(//button[@type='button'])"));
        removeButton.click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(message.isDisplayed());

        //6. Add buttonuna basin
        removeButton.click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement message2 = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(message2.isDisplayed());
    }

    @Test
    public void ExplicitlyWait() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapCheckbox()']")));
        removeButton.click();

        //5. “It’s gone!” mesajinin goruntulendigini test edin.
        WebElement itsGoneYazisielementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGoneYazisielementi.isDisplayed());

        //6. Add buttonuna basin
        removeButton.click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYazisiElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsBackYazisiElementi.isDisplayed());
    }


}

package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
1."https://facebook.com" Adresine gidin
2.“create new account” butonuna basin
3.“firstName” giris kutusuna bir isim yazin
4.“surname” giris kutusuna bir soyisim yazin
5.“email” giris kutusuna bir email yazin
6.“email” onay kutusuna emaili tekrar yazin
7.Bir sifre girin
8.Tarih icin gun secin
9.Tarih icin ay secin
10.Tarih icin yil secin
11.Cinsiyeti secin
12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13.Sayfayi kapatin
 */
public class D16_Faker extends TestBase {

    @Test
    public void test(){
        Faker faker = new Faker();
        String isim = faker.internet().password();
        System.out.println(isim);
    }

    @Test
    public void facebookUserTest() throws InterruptedException {
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        //1."https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //2.“create new account” butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();

        /*3.“firstName” giris kutusuna bir isim yazin
        4.“surname” giris kutusuna bir soyisim yazin
        5.“email” giris kutusuna bir email yazin
        6.“email” onay kutusuna emaili tekrar yazin
        7.Bir sifre girin
         */
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        String email = faker.internet().emailAddress();
            actions.
                    click(nameTextBox).
                    sendKeys(faker.name().firstName()).
                    sendKeys(Keys.TAB).
                    sendKeys(faker.name().lastName()).
                    sendKeys(Keys.TAB).
                    sendKeys(email).
                    sendKeys(Keys.TAB).
                    sendKeys(email).
                    sendKeys(Keys.TAB).
                    sendKeys(faker.internet().password()).
                    perform();


        // 8.Tarih icin gun secin
        WebElement dayDropDown = driver.findElement(By.xpath("//select[@aria-label='Day']"));
        Select day = new Select(dayDropDown);
        day.selectByIndex(3);

        // 9.Tarih icin ay secin
        WebElement monthDropDown = driver.findElement(By.xpath("//select[@aria-label='Month']"));
        Select month = new Select(monthDropDown);
        month.selectByValue("12");

        // 10.Tarih icin yil secin
        WebElement yearDropDown = driver.findElement(By.xpath("//select[@aria-label='Year']"));
        Select year = new Select(yearDropDown);
        year.selectByValue("1997");
        Thread.sleep(5000);

        // 11.Cinsiyeti secin
        WebElement cinsiyet = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        cinsiyet.click();

        //12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(cinsiyet.isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("(//input[@type='radio'])[1]")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("(//input[@type='radio'])[3]")).isSelected());

        //13.Sayfayi kapatin

    }
}

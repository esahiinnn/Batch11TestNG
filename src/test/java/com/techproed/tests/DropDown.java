package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
● Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin
 ve yazdırın
  4.Tüm dropdown değerleri(value) yazdırın
  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
 True , degilse False yazdırın.
 */
public class DropDown {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropDownTest(){
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        // a dropdown webelementini locate edelim
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));


        // b Select object'i olusturalim ve locate ettigimiz WebElement'i parametre olarak objeye ekleyelim
        Select select = new Select(dropDown);

        // c varolan 3 yontemden herhangi biri ile istedigimiz kategoriyi secelim
        select.selectByIndex(1);
        String firstSelectedOption = select.getFirstSelectedOption().getText();

        //Sectigimiz option'in "Option 1" oldugunu test edin
        Assert.assertEquals(firstSelectedOption, "Option 1");

    }

    @Test
    public void as(){
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        // a dropdown webelementini locate edelim
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        // b Select object'i olusturalim ve locate ettigimiz WebElement'i parametre olarak objeye ekleyelim
        Select select = new Select(dropDown);

        // c varolan 3 yontemden herhangi biri ile istedigimiz kategoriyi secelim
        select.selectByValue("2");
        String secondSelectedOption = select.getFirstSelectedOption().getText();

        // sectigimiz option'un "Option 2" oldugunu test edelim
        Assert.assertEquals(secondSelectedOption, "Option 2");
    }

    @Test
    public void allList(){
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(dropDown);

        List<WebElement> actualList = select.getOptions();
            for(WebElement w: actualList){
                System.out.println(w.getText());
            }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}

/*

    @Test
    public void tests() {
        //Select testDropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        //testDropDown.selectByIndex(1);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Select dropDownList = new Select(dropDown);
        dropDownList.selectByIndex(1);
        System.out.println(dropDownList.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        dropDownList.selectByValue("2");
        System.out.println(dropDownList.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        dropDownList.selectByVisibleText("Option 1");
        System.out.println(dropDownList.getFirstSelectedOption().getText());
        System.out.println("===============");

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> wholeDropDown = dropDownList.getOptions();
        for (WebElement w : wholeDropDown) {
            System.out.println(w.getText());
        }
        System.out.println("================");

        /*5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
        // True , degilse False yazdırın.
            switch (wholeDropDown.size()){
                    case 4:
                    System.out.println("True");
                    break;
default:
        System.out.println("False");
        break;
        }

        } */

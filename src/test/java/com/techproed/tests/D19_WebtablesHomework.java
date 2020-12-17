package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class D19_WebtablesHomework extends TestBase {
    /*
    Bir Class olusturun D19_WebtablesHomework
1. “https://demoqa.com/webtables” sayfasina gidin
2. Headers da bulunan department isimlerini yazdirin
3. 3.sutunun basligini yazdirin
4. Tablodaki tum datalari yazdirin
5. Tabloda kac cell (data) oldugunu yazdirin
6. Tablodaki satir sayisini yazdirin
7. Tablodaki sutun sayisini yazdirin
8. Tablodaki 3.kolonu yazdirin
9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
sayisini girdigimde bana datayi yazdirsin
     */
    @Test
    public void test() {
        int count = 0;
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> departmentIsimleri = driver.findElements(By.xpath("//div[3]//div[1]//div//div[6]"));
        for (WebElement w : departmentIsimleri) {
            System.out.println(w.getText());
        }

        // 3.sutunun basligini yazdirin
        WebElement ucSutunBasligi = driver.findElement(By.xpath("//div[3]//div[1]/div[1]/div/div[3]"));
        System.out.println(ucSutunBasligi.getText());

        // 4. Tablodaki tum datalari yazdirin
        for (int i = 1; i < 4; i++) {
            for (int k = 1; k < 8; k++) {
                WebElement hucreler = driver.findElement(By.xpath(" //div[3]//div[2]//div[" + i + "]//div[" + k + "]"));
                System.out.println(hucreler.getText());
                count++;
            }
        }

        // 5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println(count);

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//div[3]/div[1]/div[2]/div"));
        System.out.println(satirSayisi.size());

        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//div[3]/div[1]/div[1]//div[1]//div//div[1]"));
        System.out.println(sutunSayisi.size());

        // 8. Tablodaki 3.kolonu yazdirin
        System.out.println("==============================");
        List<WebElement> ucuncuKolon = driver.findElements(By.xpath("//div[3]//div[1]//div//div[3]"));
        ucuncuKolon.remove(ucuncuKolon.get(3));

        for (WebElement w : ucuncuKolon) {
            System.out.println(w.getText());
        }

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin


        page(1, 1);

    }

    /*10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        sayisini girdigimde bana datayi yazdirsin */
    public void page(int satir, int sutun){

                WebElement hucreler = driver.findElement(By.xpath("//div[3]//div[2]//div[" + satir + "]//div[" + sutun + "]"));
                System.out.println(hucreler.getText());

    }
}
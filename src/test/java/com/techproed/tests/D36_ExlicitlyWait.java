package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//senkronization: internete veya uygulamaya bagli olarak yasan gecikmelerde locate etmek veya
// kullanmak istedigimiz Webelementlere ulasmakta sorun yasayabiliriz.
//Bu durumda uygun wait komutlari ile Driver ve uygulama arasindaki uyum problemleri(senkronization issue) cozulur
// Thread.sleep : Hard wait yapar. Java komutlarini yazilan sure kadar bekletir.
// Implicitly Wait : sayfadaki tum webelementlerinin locate islemleri  icin yazilan maximum sure kadar bekler
//                  Maximim bekleme suresi asilirsa NoSuchElementException verir
// Explicitly Wait : Belirli sarta baglanmis belirli Web Elementleri icin max.sureye kadar sartin saglanmasini bekler
//                     Kullanmak icin wait objesi olusturmamiz gerekir
// implicitly wait ve Explicitly wait dinamik wait olarak adlandirilir,
// cunku istenen durum gerceklesirse maximunm surenin dolmasini beklemez

/*
//senkronization: internete veya uygulamaya bagli olarak yasan gecikmelerde locate etmek veya
// kullanmak istedigimiz Webelementlere ulasmakta sorun yasayabiliriz.
//Bu durumda uygun wait komutlari ile Driver ve uygulama arasindaki uyum problemleri(senkronization issue) cozulur
// Thread.sleep : Hard wait yapar. Java komutlarini yazilan sure kadar bekletir.
// Implicitly Wait : sayfadaki tum webelementlerinin locate islemleri  icin yazilan maximum sure kadar bekler
//                  Maximim bekleme suresi asilirsa NoSuchElementException verir
// Explicitly Wait : Belirli sarta baglanmis belirli Web Elementleri icin max.sureye kadar sartin saglanmasini bekler
//                     Kullanmak icin wait objesi olusturmamiz gerekir
// implicitly wait ve Explicitly wait dinamik wait olarak adlandirilir,
// cunku istenen durum gerceklesirse maximunm surenin dolmasini beklemez
 */



/*
Yeni bir Class olusturalim D34_WriteExcel
https://demoqa.com/browser-windows adresine gidin
Alerts’e tiklayin
On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
Allert’in gorunur olmasini bekleyin
Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
Ok diyerek alerti kapatin
 */
public class D36_ExlicitlyWait extends TestBase {

    @Test
    public void test() {
        //https://demoqa.com/browser-windows adresine gidin
        driver.get("https://demoqa.com/browser-windows");

        //Alerts’e tiklayin
        driver.findElement(By.xpath("(//li[@id='item-1'])[2]")).click();

        //On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
        driver.findElement(By.xpath("(//button[@id])[2]")).click();

        //Allert’in gorunur olmasini bekleyin
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.alertIsPresent());

        //Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "This alert appeared after 5 seconds");

        //Ok diyerek alerti kapatin
        driver.switchTo().alert().accept();
    }

    /*
    https://demoqa.com/dynamic-properties adresine gidin
“Will enable 5 seconds” butonunun enable olmasini bekleyin
“Will enable 5 seconds” butonunun enable oldugunu test edin
     */
    @Test
    public void test02(){
        //https://demoqa.com/dynamic-properties adresine gidin
        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        //“Will enable 5 seconds” butonunun enable olmasini bekleyin
        WebElement enableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id])[1]")));

        //“Will enable 5 seconds” butonunun enable oldugunu test edin
        Assert.assertTrue(enableButton.isEnabled());
    }

    /*
    Yeni bir test methodu olusturun
https://demoqa.com/dynamic-properties adresine gidin
“Visible After 5 seconds” butonunun gorunur olmasini bekleyin
“Visible After 5 seconds” butonunun gorunur oldugunu test edin
     */
    @Test
    public void test03(){
        //https://demoqa.com/dynamic-properties adresine gidin
        driver.get("https://demoqa.com/dynamic-properties");

        //“Visible After 5 seconds” butonunun gorunur olmasini bekleyin
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement visibleAfterFiveSec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@id])[3]")));

        //“Visible After 5 seconds” butonunun gorunur oldugunu test edin
        Assert.assertTrue(visibleAfterFiveSec.isDisplayed());
    }

    /*
    Yeni bir test methodu olusturalim
https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
1)“Add Element” butona basin
2)“Delete” butonu gorunur oluncaya kadar bekleyin
3)“Delete” butonunun gorunur oldugunu test edin
4)Delete butonuna basarak butonu silin
5)Delete butonunun gorunmedigini test edin
     */
    @Test
    public void test04() throws InterruptedException {


        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //1)“Add Element” butona basin
        driver.findElement(By.xpath("(//button[@onclick])[1]")).click();

        //2)“Delete” butonu gorunur oluncaya kadar bekleyin
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class])[1]")));

        //3)“Delete” butonunun gorunur oldugunu test edin
        Assert.assertTrue(deleteButton.isDisplayed());

        //4)Delete butonuna basarak butonu silin
        WebElement button = driver.findElement(By.xpath("(//button[@class])[1]"));
        button.click();
        Thread.sleep(2000);

        //5)Delete butonunun gorunmedigini test edin
        try{
            Assert.assertFalse(button.isDisplayed());
        }catch (Exception e){
                e.printStackTrace();
        }

    }
}

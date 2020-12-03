package com.techproed.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

/*
    1. “http://zero.webappsecurity.com/” Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password.” yazin
    5. Sign in tusuna basin
    Test2
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. “amount” kutusuna bir sayi girin
    10. “US Dollars” in secilmedigini test edin
    11. “Selected currency” butonunu secin
    Test3
    12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini control edin.
 */
public class Day10_ZeroWebAppTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void Test01() {
        //     1.“http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //      2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button'][1]")).click();
        //      3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("(//input[@id='user_login'])[1]")).sendKeys("username");
        //      4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //      5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

    }

    @Test(dependsOnMethods = "Test01")
    public void Test02() {
        //        6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();
        //          7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //          8. “Currency” drop down menusunden Eurozone’u secin
        Select select = new Select(driver.findElement(By.xpath("//select[@id='pc_currency']")));
        select.selectByIndex(6);
        //           9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("10");

        //    10. “US Dollars” in secilmedigini test edin
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(radioButton.isSelected());

        //     11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();

    }


    @Test(dependsOnMethods = "Test02")
    public void Test03() {
        //  12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
        ​
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini control edin.
        WebElement textKontrol = driver.findElement(By.xpath("//div[@id='alert_content']"));
        String expectedResult = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(textKontrol.getText(), expectedResult);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D13_TestBaseIlkTest extends TestBase{

    @Test
    public void test(){
        driver.get("https://youtube.com");
    }
}

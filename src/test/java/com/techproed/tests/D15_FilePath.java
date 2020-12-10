package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D15_FilePath extends TestBase {

    @Test
    public void test(){
        // icinde oldugumuz proje'nin path'ini verir
        System.out.println(System.getProperty("user.dir"));

        // intellij'in projelerinin bulundugu klasorun bir ust klasorunu verir
        String mainPath = System.getProperty("user.home");

        // C:\Users\ASUS\Desktop
        String desktopPath = mainPath + "\\Desktop";
        System.out.println(desktopPath);

    }

    @Test
    public void isExist(){
        //C:\Users\ASUS\Desktop\FLOWER.jpg
        //1.adim bilgisayarimizin home path'ini buluyoruz
        String mainPath = System.getProperty("user.home");

        //2.Adim home Path'in devamina dosya yolunu olusturacak sekilde ek yapiyoruz
        // ONEMLI: dosya adindan sonra uzantinin da yazilmasi gerekir
        String flowerPath = mainPath + "\\Desktop\\FLOWER.jpg";

        //masaustunde FLOWER.jpg dosyasinin var oldugunu test edin
        //3.Adim dosyanin var oldugunu Files.exist() method'u ile test edebiliyoruz
        boolean file = Files.exists(Paths.get(flowerPath));
        System.out.println(file); // true


    }
}

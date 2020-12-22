package com.techproed.excelautomation;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        // Java ile dosya okuyabilmek icin FileInputStream Class'ini kullaniyoruz
        // Ancak bunun icin okuyacagimiz dosyanin yoluna ihtiyacimiz var
        // Okunacak dosya yolunu bulup String path degiskenine atiyoruz
        String path = ".\\src\\test\\java\\resources\\ulkeler.xlsx";

        // Dosyamizi java okutabilmek icin FileInputStream kullanip parametre olarak path'i giriyoruz
        FileInputStream fileInputStream = new FileInputStream(path);

        // Excel'de dataya ulasmak icin cell(hucre)'ye ulasmamiz gerekiyor
        // Bunun icin sirasiyla workbook olusturup parametre olarak fileInputStream objesini giriyoruz
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // workbook'dan sonra ilgili sayfaya gitmek icin sheet objesi olusturuyoruz
        Sheet sheet = workbook.getSheetAt(0);

        // ilgili satira gitmek icin Row objesi olusturuyoruz
        Row row = sheet.getRow(0);

        // Hucreye gitmek icin cell objesi olusuruyoruz
        Cell cell = row.getCell(0);

        // Ulastigimiz data Cell objesi formatindadir. Yazdirmak istedigimizde yazdirabiliriz ancak manupule edemeyiz
        // data uzerinde Assert yada manipulasyon yapmak istiyorsak once datayi toString() method'u ile String bir degiskene ceviriyoruz
        System.out.println(cell);
        String a = cell.toString();

    }

    /*
    Yeni bir test method olusturalim readExcel2()
            - 1.satirdaki 2.hucreye gidelim ve yazdiralim
            - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
            - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
            - Satir sayisini bulalim
            - Fiziki olarak kullanilan satir sayisini bulun
            - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */
    @Test
    public void readExcel2() throws IOException {
        String path = ".\\src\\test\\java\\resources\\ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(0);

        Cell cell = row.getCell(1);

        System.out.println(cell);

        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String cellString = cell.toString();
        System.out.println(cellString);

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String afgCap = workbook.getSheetAt(0).getRow(1).getCell(3).toString();
        Assert.assertTrue(afgCap.equalsIgnoreCase("kabil"));

        //- Satir sayisini bulalim
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum();
        System.out.println(satirSayisi);

        //- Fiziki olarak kullanilan satir sayisini bulun
        int physicalSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println(satirSayisi);

        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        HashMap<String, String> countryNamesnCaps = new HashMap<>();
        for(int i = 1; i<=satirSayisi; i++){
            for(int j = 0; j<=1; j++){
                countryNamesnCaps.put(workbook.getSheetAt(0).getRow(i).getCell(j).toString(), workbook.getSheetAt(0).getRow(i).getCell(j).toString());
            }
        }

        String countryName = "";
        String capitals = "";
        for (int i = 1; i <= workbook.getSheetAt(0).getLastRowNum(); i++) {
            countryName = workbook.getSheetAt(0).getRow(i).getCell(0).toString();
            capitals = workbook.getSheetAt(0).getRow(i).getCell(1).toString();
            countryNamesnCaps.put(countryName, capitals);
        }
        System.out.println(countryNamesnCaps);

    }
}

package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Excelutility {
    //  kendisine verilen path deki excelin, istenilen, sheetindeki
    // istenilen kolona kadar sütunları okuyup Arraylist formatında geri döndüren fonksiyonu yazınız.
    //  getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2

    public static ArrayList< ArrayList< String > > getListData(String path, String sheetName, int columnCount){
        ArrayList< ArrayList< String > > tablo=new ArrayList<>();

        Workbook workbook=null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sayfa=workbook.getSheet(sheetName);

        for (int i = 0; i < sayfa.getPhysicalNumberOfRows(); i++) {

            ArrayList<String> satirData=new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                satirData.add( sayfa.getRow(i).getCell(j).toString());
            }

            tablo.add(satirData);
        }

        return tablo;
    }

    // TODO: kendisine verilen    path, scenario, browserTipi, zaman   parametreleri ile
    // yeni bir excele bütün raporu yazacak. dosyanın varlığını veya yokluğu kontrol etmeyi googdan bulunuz
     public static void writeExcel(String path, Scenario scenario,String browserName,String time){//bir file excel varsa yoksa nasil kontrol ediyoruz

         File f=new File(path);

        if (!f.exists()){//bu yani dosya yoksa sen bunlari yap
         //hafizada yeni workbook oluştur sonra yeni sayfa
         XSSFWorkbook workbook=new XSSFWorkbook();
         XSSFSheet sheet= workbook.createSheet("sayfa1");

         Row newrow=sheet.createRow(0);

         Cell newcell=newrow.createCell(0);
         newcell.setCellValue(scenario.getName());

         newcell=newrow.createCell(1);
         newcell.setCellValue(scenario.getStatus().toString());

         newcell=newrow.createCell(2);
         newcell.setCellValue(browserName);


          newcell=newrow.createCell(3);
         newcell.setCellValue(time);


         try {
             FileOutputStream outputStream=new FileOutputStream(path);
             workbook.write(outputStream);
             workbook.close();
             outputStream.close();
         }catch (IOException e){
             throw new RuntimeException(e);
         }
        }
        else {
            FileInputStream inputStream=null;
            Workbook workbook=null;
            try {
               inputStream=new FileInputStream(path);
                workbook= WorkbookFactory.create(inputStream);

            }catch (IOException e){
                throw new RuntimeException(e);
            }
            Sheet sheet=workbook.getSheetAt(0);
            //hafizada oluşturma ve yazma işlemler başlatiliyor
            int rowcount= sheet.getPhysicalNumberOfRows();
            Row newRow=sheet.createRow(rowcount);

            Cell newcell=newRow.createCell(0);
            newcell.setCellValue(scenario.getName());

            newcell=newRow.createCell(1);
            newcell.setCellValue(scenario.getStatus().toString());

            newcell=newRow.createCell(2);
            newcell.setCellValue(browserName);


            newcell=newRow.createCell(3);
            newcell.setCellValue(time);

            try {
                inputStream.close();//burda inputstrean kapattim sira yazma moduna açmam gerekiyor
                FileOutputStream outputStream=new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
         System.out.println(" işlem tamamlandi" );
     }

    public static void main(String[] args) {
        ArrayList< ArrayList< String > > tablo =
                getListData("src/test/java/ApachePoi/resources/ApacheExcel2.xlsx","testCitizen", 4);

        System.out.println("tablo = " + tablo);
    }
}


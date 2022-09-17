package ApachePoi;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */
public class _07_soru {
    public static void main(String[] args) {
        System.out.println(" istenen sutun numara= ");
        Scanner oku=new Scanner(System.in);
        int colun= oku.nextInt();

        String donensonuc=bul(colun);
        System.out.println("donensonuc = " + donensonuc);


    }
    public static String bul(int colun){
        String donecek="";
        String path="src/test/java/ApachePOI/resources/LoginData.xlsx";
        Workbook workbook=null;
try {
    FileInputStream inputStream=new FileInputStream(path);
     workbook= WorkbookFactory.create(inputStream);
}catch (IOException e){
    throw new RuntimeException();
}
        Sheet sheet= workbook.getSheetAt(0);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
            if (sheet.getRow(i).getPhysicalNumberOfCells()>colun)
            donecek+=sheet.getRow(i).getCell(colun)+"\n";

     return donecek;
    }

}

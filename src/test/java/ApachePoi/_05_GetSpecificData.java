package ApachePoi;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değr password un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */

public class _05_GetSpecificData {
    public static void main(String[] args) {
        System.out.println(" aranacak kelime= ");
        Scanner oku=new Scanner(System.in);
        String aranankelime= oku.next();

        String donensonuc=bul(aranankelime);
        System.out.println("donensonuc = " + donensonuc);
    }
    public static String bul(String aranankelime){
        String donecek="";
        Workbook workbook=null;
        String path="src/test/java/ApachePOI/resources/LoginData.xlsx";
        try {
            FileInputStream inputStream=new FileInputStream(path);
             workbook= WorkbookFactory.create(inputStream);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheetAt(0);//Login
        int rowcount= sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowcount; i++) {
            Row row= sheet.getRow(i);
            Cell cell= row.getCell(0);
            if (cell.toString().equalsIgnoreCase(aranankelime)){

                for (int j = 1; j < row.getPhysicalNumberOfCells(); j++)
                    donecek+= row.getCell(j)+" ";
            }
        }

        return donecek;
    }
}

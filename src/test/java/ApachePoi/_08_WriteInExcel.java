package ApachePoi;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInExcel {
    public static void main(String[] args)throws IOException {
        String path="src/test/java/ApachePoi/resources/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("sheet1");
        //hafizada oluşturma ve yazma işlemler başlatiliyor
        Row yenisatir=sheet.createRow(0);
        Cell yenihucre=yenisatir.createCell(0);
        yenihucre.setCellValue("merhaba Excel");

        for (int i = 1; i < 10; i++)
            yenisatir.createCell(i).setCellValue(i);


        inputStream.close();//burda inputstrean kapattim sira yazma moduna açmam gerekiyor

        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println(" işlem tamamlandi" );


    }
}

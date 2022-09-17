package ApachePoi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        //hafizada yeni workbook oluştur sonra yeni sayfa
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("sayfa1");

        Row yenisatir=sheet.createRow(0);
        Cell yenihucre=yenisatir.createCell(0);
        yenihucre.setCellValue("merhaba Excel");

        for (int i = 1; i < 10; i++)
            yenisatir.createCell(i).setCellValue(i);

        String yeniExcelpath="src/test/java/ApachePoi/resources/yeniexcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(yeniExcelpath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println(" işlem tamamlandi" );

    }
}

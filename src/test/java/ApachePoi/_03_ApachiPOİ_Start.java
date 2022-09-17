package ApachePoi;

import org.apache.poi.ss.usermodel.*;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachiPOİ_Start {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePoi/resources/ApacheExcel2.xlsx";//dosyanin yolu

        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path);//boylece excel ve javadosyasinda de baglanti kuruyuruz
        Workbook workbook= WorkbookFactory.create(dosyaOkumaBaglantisi);
        Sheet  sheet=workbook.getSheet("sheet1");
        Row row=sheet.getRow(0);
        Cell cell= row.getCell(0);
        System.out.println("cell = " + cell);
    }
}

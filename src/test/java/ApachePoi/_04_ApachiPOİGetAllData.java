package ApachePoi;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachiPOİGetAllData {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePoi/resources/ApacheExcel2.xlsx";//dosyanin yolu

        FileInputStream inputStream=new FileInputStream(path);            //boylece excel ve javadosyasinda de baglanti kuruyuruz

        Workbook workbook= WorkbookFactory.create(inputStream);           //workbookdiyoryz

        Sheet sheet=workbook.getSheet("sheet1");                         //hangi sayfa

        int rowcount=sheet.getPhysicalNumberOfRows();                      //kac satir
        for (int i = 0; i < rowcount; i++) {                               //fori baraye her satir
            Row row= sheet.getRow(i);                                      //hangi satir aldik
            int cellcount=row.getPhysicalNumberOfCells();                  //ba int hucresayisi tarif kardim
            for (int j = 0; j < cellcount; j++) {                          //ba fori baraye her hucre tain mikonim
                Cell cell=row.getCell(j);                                  //hucre ha ro migirim
                System.out.println(" " + cell);
            }
    }
    }
}

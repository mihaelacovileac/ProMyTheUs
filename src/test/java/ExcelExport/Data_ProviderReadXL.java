package ExcelExport;

import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;


public class Data_ProviderReadXL {

    @DataProvider(name = "excelFile")
    public Object[][] dataProviderRead(String filepath, String sheetname) {

        Object[][] tabArray = null;
        DataFormatter formatter = new DataFormatter();
        try {
            FileInputStream f = new FileInputStream(filepath);
//           Workbook workbook = Workbook.getWorkbook(f);
//           Sheet sheet = workbook.getSheet(sheetname);

            XSSFWorkbook workbook = new XSSFWorkbook(f);
            XSSFSheet sheet = workbook.getSheet(sheetname);

//           int firstRow = 1;
//           int firstColumn = 0;
//
//           int rowCount = sheet.getRows();
//           int colCount = sheet.getColumns();

            Iterator<Row> rowIterator = sheet.iterator();

            int rownum = 0;
            int colnum = 0;
            Row r = rowIterator.next();
            int rowCount = sheet.getLastRowNum();
            int colCount = r.getPhysicalNumberOfCells();

            System.out.println("These are the total number of rows in the xls file " + rowCount);
            System.out.println("These are the total number of columns in the xls file " + colCount);

            tabArray = new Object[rowCount-1][colCount];
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    tabArray[rownum][colnum] = formatter.formatCellValue(cell);
                    System.out.print(formatter.formatCellValue(cell));
                    System.out.print(" , "); }
                rownum++;
                System.out.println(" ");
            }

        } catch (Exception e) {
            System.out.println("The file is not found");
        }
        return tabArray;
    }
}

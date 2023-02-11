package read_data;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Spliterator;

public class Retrieve_FromFile {

    @Test
    public void readFileTest() throws IOException {

        File file = new File("src/test/resources/TestSetup.xlsx");

        FileInputStream fileInputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream); // whole excell file
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFSheet page1 = workbook.getSheet("Sheet1");
        XSSFRow row1 = page1.getRow(0);
        XSSFCell cell1 = row1.getCell(0);
        String cellValue = sheet.getRow(0).getCell(0).getStringCellValue();
        XSSFRow row2 = page1.getRow(1);
        XSSFCell cell2 = row2.getCell(0);

        System.out.println(cell1);
        System.out.println(cell2);

    }

    @Test

    public void getRowValuesTest() throws IOException {

        File file = new File("src/test/resources/TestSetup.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet1 = workbook.getSheetAt(0);
        XSSFRow row1 = sheet1.getRow(0);
        for (int i = row1.getFirstCellNum(); i < row1.getLastCellNum(); i++) {
            XSSFCell cell = row1.getCell(i);
            System.out.print(cell + " | ");
        }
    }

    // get all the values from the excel files

    @Test
    public void  getAllData() throws IOException {

        File file = new File("src/test/resources/TestSetup.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet1 = workbook.getSheetAt(0);


        for (int i = sheet1.getFirstRowNum(); i <sheet1.getLastRowNum() ; i++) {
            System.out.print("| ");
            XSSFRow rows = sheet1.getRow(i);

            for (int j = rows.getFirstCellNum(); j<rows.getLastCellNum() ; j++) {
                XSSFCell cell = rows.getCell(j);
                System.out.print(cell +" | ");
            }
            System.out.println();
        }



    }


}

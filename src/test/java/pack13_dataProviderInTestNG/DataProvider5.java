package pack13_dataProviderInTestNG;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataProvider5 {
    @Ignore
    @DataProvider(name = "SampleDataFromExcel")
    public Object[][] getExcelData() throws IOException {
        File file = new File("./src/test/resources/AshishSamples.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row headerRow = sheet.getRow(0);
        int rowCount = sheet.getLastRowNum();//indexing starts from 0
        int columnsCount = headerRow.getLastCellNum();
        Object[][] excelData = new Object[rowCount][columnsCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                if (cell == null || cell.getCellType() == CellType.BLANK)
                    excelData[i - 1][j] = " ";
                else if (cell.getCellType() == CellType.STRING)
                    excelData[i - 1][j] = cell.getStringCellValue();
                else if (cell.getCellType() == CellType.NUMERIC)
                    excelData[i - 1][j] = cell.getNumericCellValue();
                else
                    excelData[i - 1][j] = cell.getDateCellValue();
            }
        }
        workbook.close();
        return excelData;
    }


    @DataProvider(name = "SampleDataFromExcel2")
    public Object[][] getExcelData2() throws IOException {
        File file = new File("./src/test/resources/AshishSamples.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row headerRow = sheet.getRow(0);
        int rowCount = sheet.getLastRowNum();//indexing starts from 0
        int columnsCount = headerRow.getLastCellNum();
        Object[][] excelData = new Object[rowCount][columnsCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                if (cell == null || cell.getCellType() == CellType.BLANK)
                    excelData[i - 1][j] = " ";
                else {
                    DataFormatter df = new DataFormatter();
                    excelData[i - 1][j] = df.formatCellValue(cell);
                }
            }
        }
        workbook.close();
        return excelData;
    }

    @Test(dataProvider = "SampleDataFromExcel2")
    public void printSamplesData(Object[] eachRow) {
        System.out.println(Arrays.toString(eachRow));
    }
}

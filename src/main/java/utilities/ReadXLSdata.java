package main.java.utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadXLSdata {

@DataProvider (name = "testdata")

    public Object[][] getData(Method m ) throws EncryptedDocumentException, IOException {

        String excelSheetName = m.getName();
        File f = new File(System.getProperty("user.dir") + "/src/test/java/testdata/testdata.xlsx"); //To read file
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis); //To know workbook to read
        Sheet sheetname = wb.getSheet(excelSheetName); // Read Sheet by name or index

        int totalRows = sheetname.getLastRowNum(); //Total number of row in sheet
        System.out.println(totalRows);
        Row rowCells = sheetname.getRow(0);  // Total number of Cell in a row
        int totalCols = rowCells.getLastCellNum(); //Get last cell number
        System.out.println(totalCols);

        DataFormatter format = new DataFormatter();   //Format all data types

        String testData[][] = new String [totalRows][totalCols];
        for (int i=1; i<=totalRows;i++){
            for (int j=0; j<totalCols; j++){
                testData[i-1][j]=format.formatCellValue(sheetname.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }
return testData;


    }
}

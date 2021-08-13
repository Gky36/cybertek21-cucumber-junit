package com.cybertek.tests;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    /*
    In this method we will learn how tto read from excel file step by step
     */
    @Test
    public void read_from_excel_file() throws IOException {

        String path = "SampleData.xlsx";

        //To be able to read from Excel file, we need to load it into FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook > sheet > row > cell

        //1- Create a workBook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //2- We need to get the specific sheet from currently opened workbook
        XSSFSheet sheets = workbook.getSheet("Employees");

        // 3- Select row and cell
        // Print out Steven's cell
        // Indexes start from 0
        System.out.println("sheets.getRow(1).getCell(0) = " + sheets.getRow(1).getCell(0));

        // Print out "Singer" from the sheet
        System.out.println("sheets.getRow(3).getCell(2) = " + sheets.getRow(3).getCell(2));

        // Return the count of used cells only
        // If there are cell not used, they will not be counted
        // It will not count empty rows or cells
        // Starts counting from 1
        int usedRows = sheets.getPhysicalNumberOfRows();


        // Returns the number from the top cell to bottom cell
        // It does not care if there are empty cell or not
        // Starts counting from 0
        int lastUsedRow = sheets.getLastRowNum();

        //TODO: 1- CREATE A LOGIC TO PRINT OUT NEENA'S NAME DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            // It return type is int so we have to convert to string in order to print out
           if (sheets.getRow(rowNum).getCell(0).toString().equals("Neena")){
               System.out.println("Neena's name = " + sheets.getRow(rowNum).getCell(0));
           }
        }

        //TODO: 2 - CREATE A LOGIC TO PRINT OUT STEVEN KING'S JOB_ID
        // CHECK FOR STEVEN'S NAME, IF ITS STEVEN --> PRINT OUT JOB_ID

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if (sheets.getRow(rowNum).getCell(0).toString().equals("Steven")){

                System.out.println("Steven's JOB_ID: " + sheets.getRow(rowNum).getCell(2));

            }
        }







    }
}

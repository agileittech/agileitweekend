package org.phptravel.usingtestng;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadingExcel {
    public String  readdatafromrow(int rownumber,int cellnumber) throws IOException {
	FileInputStream fi = new FileInputStream("C:\\Filehandling\\Datatosent.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fi);
	Sheet sheet = workbook.getSheet("Sheet1");
	Row row = sheet.getRow(rownumber);
	Cell cell = row.getCell(cellnumber);
	String text = cell.getRichStringCellValue().toString();
	System.out.println(text);
	workbook.close();
	return text;
	}

}

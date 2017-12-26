package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL {
	//this is for getting the sheet information from the excel sheet
public static String getCellValue(String sheet,String path,int r,int c) {
	String v="";
	try {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
	} catch (Exception e) {
		
	} 
return v;
}

public static int getRowCount(String path,String sheet) {
	int rc=0;
	try {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		rc=wb.getSheet(sheet).getLastRowNum();//getlastrownum()will return the index
	} catch (Exception e) {
		
	}
return rc;
}

public static int getCellNum(String path,String sheet,int rc) {
	int cc=0;
	try {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		cc=wb.getSheet(sheet).getRow(rc).getLastCellNum();//getlastcellnum will return count not the index
	} catch (Exception e) {
		
	} 
return cc;
}
}

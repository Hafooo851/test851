package DataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	// this wont be same for everyone depending on the 
	XSSFWorkbook wb; // build function xss and xl 
	public ExcelDataProvider(){
		try{
		wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/testData/TestData.xlsx")));
		}catch(IOException e){
		System.out.println("Unable to read Excel data "+e.getMessage());
			
	}
	}
	
	public String getCellData(String sheetName, int row , int col)
	{
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col); // cell mean the lines we have in excel//cell and column are same thing 
		String data= null; // if i have empty cell i dont want to do nothing just skip it 
		
		if(cell.getCellTypeEnum()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if (cell.getCellTypeEnum()==CellType.NUMERIC)
		{
			data=String.valueOf((int)cell.getNumericCellValue());
		}
		else if (cell.getCellTypeEnum()==CellType.BLANK);
		{
			data="";
		}
	return data;//
		
	}
	public int getRows(String sheetName)
	{
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	public int getColumns(String sheetName)
	{
	return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}

}


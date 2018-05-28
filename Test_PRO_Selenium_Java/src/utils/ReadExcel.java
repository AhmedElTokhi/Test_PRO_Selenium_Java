package utils;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcel {
	
	private File src;
	private FileInputStream fis;
	private XSSFWorkbook wb;

	public ReadExcel(String xlFile){
		src= new File(xlFile);
		try {
			fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getCellData(int sheetindex,int rownum,int colnum){
		
		return wb.getSheetAt(sheetindex).getRow(rownum).getCell(colnum).getStringCellValue();
	}
	
	public int getRowCount(int sheetindex){
		return wb.getSheetAt(sheetindex).getLastRowNum();
	}

	public int getColCount(int sheetindex,int rownum){
		return wb.getSheetAt(sheetindex).getRow(rownum).getLastCellNum();
	}
	
}

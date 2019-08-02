package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataHandler {
    
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Map<String, Integer> map;
	static FileInputStream file;
	
	public static void loadFile(String filePath) {

		try {
			file = new FileInputStream(new File(filePath));

		//Get the workbook instance for XLS file 
		workbook = new XSSFWorkbook(file);

		//Get first sheet from the workbook
		sheet = workbook.getSheet("TestData");
		
		map = new HashMap<String,Integer>(); //Create map
		XSSFRow row = sheet.getRow(0); //Get first row
		//following is boilerplate from the java doc
		short minColIx = row.getFirstCellNum(); //get the first column index for a row
		short maxColIx = row.getLastCellNum(); //get the last column index for a row
		for(short colIx=minColIx; colIx<maxColIx; colIx++) { //loop from first to last index
		   XSSFCell cell = row.getCell(colIx); //get the cell
		   map.put(cell.getStringCellValue(),cell.getColumnIndex()); //add the cell contents (name of column) and cell index to the map
		 }
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static Map<String,ArrayList<String>> getDataByNames(String columnNames,int rowCount){
		
		String[] names = columnNames.split(":");
		Map<String,ArrayList<String>> multiMap = new HashMap<String,ArrayList<String>>();
		
		
		for (String columnName : names) {
			ArrayList<String> cellData = new ArrayList<String>();
		    for (int i=01;i <= rowCount;i++){
		    	cellData.add(sheet.getRow(i).getCell(map.get(columnName)).getStringCellValue());
		    }
		    
		    multiMap.put(columnName, cellData);
		}
		
		return multiMap;
		
	}
	
	public static Map<String,ArrayList<String>> loadTableForTestCase(String testCaseNo){
		
		Iterator<Row> iterator = sheet.iterator();
		Map<String,ArrayList<String>> multiMap = new HashMap<String,ArrayList<String>>();
		ArrayList<String> testStep = new ArrayList<String>();
		ArrayList<String> locator = new ArrayList<String>();
		ArrayList<String> action = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>();
		while (iterator.hasNext()) {
	        Row nextRow = iterator.next();
	        if (nextRow.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseNo)){
	        	testStep.add(nextRow.getCell(1).getStringCellValue());	
	        	if (nextRow.getLastCellNum()>2){
	        		locator.add(nextRow.getCell(2).getStringCellValue());
	        	} else {
	        		data.add("");
	        	}
	        	if (nextRow.getLastCellNum()>3){
	        		action.add(nextRow.getCell(3).getStringCellValue());
	        	} else {
	        		data.add("");
	        	}
	        	if (nextRow.getLastCellNum()>4){
	        		data.add(nextRow.getCell(4).getStringCellValue());
	        	} else {
	        		data.add("");
	        	}
        	}
		}
		multiMap.put("TestStep", testStep);
		multiMap.put("ElementLocator", locator);
		multiMap.put("Action", action);
		multiMap.put("Data", data);
		
		return multiMap;
		
	}
	public static void closeFile(){
	try{	
		file.close();
	
	} catch (IOException e) {
		e.printStackTrace();
	} 
}
}


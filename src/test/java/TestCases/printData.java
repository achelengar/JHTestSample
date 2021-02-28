package TestCases;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class printData {
	
	public Object[][] getDataFromDataprovider() throws IOException{
	    InputStream excelFilePath = getClass().getResourceAsStream("/Testdata1.xlsx");

	    //creating book instance that refers to .xlsx file
		
		XSSFWorkbook book = new XSSFWorkbook(excelFilePath);
		//creating a sheetLogin object
        XSSFSheet sheetLogin = book.getSheet("LoginData");
        
        int rowcount = sheetLogin.getLastRowNum()-sheetLogin.getFirstRowNum();
        
        System.out.println("TestCases Count :"+rowcount);
        	        
        // get number of rows from sheet
        int rows = sheetLogin.getPhysicalNumberOfRows();

        // get number of cell from row
        int cells = sheetLogin.getRow(0).getPhysicalNumberOfCells();
        
        System.out.println("Cells Count :"+cells);

        Object[][] values = new String[rows][cells];

        for (int r = 0; r < rows; r++) {
            Row row = sheetLogin.getRow(r); // bring row
            for (int c = 0; c < cells; c++) {
                Cell cell = row.getCell(c);
                values[r][c] = cell.getStringCellValue();
            } // for(c)
        } // for(r)
        return values; 		
	
	}
	

}

package TestCases;

import java.awt.List;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JH_NegativeTestCases_IncorrectEmailAddress {

	   /*****************************************************************
	    * Following test cases will validate failure of the login process 
	    * by passing the correct password but incorrect email address.
	    * Expected results are passing for all test cases.
	    *****************************************************************/

	@Test(dataProvider="SearchProvider")
	public void JHloginPage(String email, String password, String FirstName, String LastName) throws InvalidFormatException, IOException, InterruptedException {
		
		
		// Initiation of Chrome Driver & launching of URL
		
		WebDriverManager.chromedriver().setup();	
		ChromeDriver driver = new ChromeDriver();	
		driver.get("http://localhost:3000/");
		
		/*
		 * Following section is validation of elements in step1 page
		 */
		
		
		//Validation of JohnHancock logo 
		Assert.assertTrue(driver.findElementByCssSelector("img.App-logo").isDisplayed(), "Logo is missing");
		//Validation of Step1 Label
		String Step1Display = driver.findElementByTagName("h1").getText();
		String ExpectedTitleStp1="Step 1";
		Assert.assertEquals(Step1Display, ExpectedTitleStp1,"Step 1 Label is missing");
	    //  Validation of Email Label
		Assert.assertTrue(driver.findElementByCssSelector("label[for='email'].form-label").isDisplayed() , "Email Label is missing");
		//  Validation of Email TextBox
		Assert.assertTrue(driver.findElementByCssSelector("input#email.form-control").isEnabled(), "Eamil Text box is not enabled");
		//  Validation of Password Label
		Assert.assertTrue(driver.findElementByCssSelector("label[for='password'].form-label").isDisplayed() , "Password Label is missing");
		//  Validation of Password Text box
		Assert.assertTrue(driver.findElementByCssSelector("input#password.form-control").isEnabled(), "Password Text box is not enabled");
		//  Validation of Next button
		Assert.assertTrue(driver.findElementByCssSelector("button.btn.btn-primary").isEnabled(), "Next button is not enabled");
		
		/*
		 * Email and password login process
		 */
		
		// Initiation of Row and Cell number for email address and password
		  
	    
     		
		//  Population of email field
		driver.findElementByCssSelector("input#email.form-control[name=email]").sendKeys(email);
		//  Log in process_ Population of Password field
		driver.findElementByCssSelector("input#password.form-control[name='password']").sendKeys(password);
		//  Click on the Next button
		driver.findElementByCssSelector("button.btn.btn-primary").click();
		
		if (email== "") {
			
		Assert.assertTrue(driver.findElementByCssSelector("div.invalid-feedback").isDisplayed(), "Required field is Missing");
//		System.out.println( "email address is required  "+email+"  Case "+i);
		System.out.println( "email address is required  "+email+"  Case "+ email);
		}else {
	     //  Validation of Failure
			String Step2Display = driver.findElementByTagName("h1").getText();
			if (Step2Display != "Step 2") {
//				System.out.println( "Incorrect email address was entered  "+email+"  Case "+i);
				System.out.println( "Incorrect email address was entered  "+email+"  Case "+email);
			  }
			}
			
		
	    	
	    	driver.close();
    	

	}

	@DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider() throws IOException{
	    InputStream excelFilePath = getClass().getResourceAsStream("/Neg_TestData_InccorectEmailAddress.xlsx");

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

        Object[][] values = new String[rows-1][cells];

        for (int r = 1; r < rows; r++) {
            Row row = sheetLogin.getRow(r); // bring row
            for (int c = 0; c < cells; c++) {
                Cell cell = row.getCell(c);
                values[r-1][c] = cell.getStringCellValue();
            } // for(c)
        } // for(r)
        return values; 		
	}    	
	
}

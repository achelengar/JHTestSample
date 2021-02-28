package TestCases;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JH_Positive_Testcases {


	@Test(dataProvider="SearchProvider")
	public void JHloginPage(String email, String password, String FirstName, String LastName) throws InvalidFormatException, IOException, InterruptedException {
		
		Thread.sleep(2000);
		
		System.out.println("EMAIL :"+email);
		System.out.println("PASSWORD :"+password);
		System.out.println("FIRSTNAME :"+FirstName);
		System.out.println("LASTNAME :"+LastName);
		
		Thread.sleep(2000);
		
		// Initiation of Chrome Driver & launching of URL
		
		WebDriverManager.chromedriver().setup();	
		ChromeDriver driver = new ChromeDriver();	
		driver.get("http://localhost:3000/");
		
		/*
		 * Following section is validation of elements in step1 page
		 */
		Thread.sleep(2000);
		System.out.println("WAITINHG");
		
		System.out.println("EMAIL :"+email);
		System.out.println("PASSWORD :"+password);
		System.out.println("FIRSTNAME :"+FirstName);
		System.out.println("LASTNAME :"+LastName);
		
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
		
		Thread.sleep(2000);
		driver.findElementByCssSelector("button.btn.btn-primary").click();
		
		Thread.sleep(2000);
		
		/******************************************************************************************
		 * 
		 *                          Start of Second page Step 2
		 * 
		 *******************************************************************************************/
	      
		//  Validation of JohnHancock logo on the second page
		Assert.assertTrue(driver.findElementByCssSelector("img.App-logo").isDisplayed(), "Logo is missing");
		
		//  Validation of Step2 Label
		String Step2Display = driver.findElementByTagName("h1").getText();
		String ExpectedTitleStp2="Step 2";
		Assert.assertEquals(Step2Display, ExpectedTitleStp2,"Step 2 Label is missing");
		
		//  Validation of first name field label
		Assert.assertTrue(driver.findElementByCssSelector("label[for='firstName'].form-label").isDisplayed() , "First name label is Missing");
		
		//  Validation of first name field 
		Assert.assertTrue(driver.findElementByCssSelector("input#firstName.form-control").isEnabled() , "Firt name text box is disabled");

		//  Assertion of last name field label
        Assert.assertTrue(driver.findElementByCssSelector("label[for='lastName'].form-label").isDisplayed() , "Last name label is Missing");
	    
        //  Validation of last name field 
        Assert.assertTrue(driver.findElementByCssSelector("input#lastName.form-control").isEnabled() , "Firt name text box is disabled");
        
        //  Validation of Next button
        Assert.assertTrue(driver.findElementByCssSelector("button.btn.btn-primary").isEnabled(), "Next button is not enabled");
        
        ////////////  Population of required fields On Step 2//////////////
        
    	// Initiation of Row and Cell number for First and Last name    
        
		//  Population of first name field
		driver.findElementByCssSelector("input#firstName").sendKeys(FirstName);
		
		//  Population of Second name field
		driver.findElementByCssSelector("input#lastName").sendKeys(LastName);
		
		Thread.sleep(2000);
		//  Click on the Next button
		driver.findElementByCssSelector("button.btn.btn-primary").click();
		
		Thread.sleep(2000);
		/*************************************************************************
		 * Start of Third  page Step 3
		 *************************************************************************/
		//  Validation of JohnHancock logo on the second page
		Assert.assertTrue(driver.findElementByCssSelector("img.App-logo").isDisplayed(), "Logo is missing");
		//  Validation of Step 3 Title
		Assert.assertTrue(driver.findElement(By.xpath("//dt['Step 3']")).isDisplayed() , "Email Label is not displayed");
		//  Assertion of Email label		
        
        //  Validation of Email Address
		String Savedemail=driver.findElement(By.xpath("//dd[1][contains(text(), '"+email+"')]")).getText();
		Assert.assertEquals(Savedemail,email, "Email is not correct or missing");
        
        //  Validation of first name field label
    	Assert.assertTrue(driver.findElementByXPath("//dt[2]['First name']").isDisplayed() , "First name label is Missing");
        //  Validation of first name value
    	String SavedFirstName=driver.findElement(By.xpath("//dd[2][contains(text(), '"+FirstName+"')]")).getText();
    	Assert.assertEquals(SavedFirstName,FirstName, "First name  is not correct or missing");
	    //  Validation of Last name field label
    	Assert.assertTrue(driver.findElementByXPath("//dt[3]['Last name']").isDisplayed() , "Last name label is Missing");
        //  Validation of last name value
    	String SavedLastName=driver.findElement(By.xpath("//dd[3][contains(text(), '"+LastName+"')]")).getText();
    	Assert.assertEquals(SavedLastName,LastName, "LastName  is not correct or missing");
    	//  Validation of Submit button
    	Assert.assertTrue(driver.findElementByCssSelector("button.btn.btn-primary").isEnabled() , "Submit button is not disabled");
    	//  Clicking on Submit button
    	driver.findElementByCssSelector("button.btn.btn-primary").click();
    	
    	Thread.sleep(5000);
    	/*************************************************************************
		 * Start of Final page 
		 *************************************************************************/
        //  Validation of JohnHancock logo on the second page
    	Assert.assertTrue(driver.findElementByCssSelector("img.App-logo").isDisplayed(), "Logo is missing");
        //  Validation of Success! label
    	Assert.assertTrue(driver.findElement(By.xpath("//h1['Success!']")).isDisplayed() , "Sucess! label is missing");
    	
    	driver.close();
    	
	}

	@DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider() throws IOException{
	    InputStream excelFilePath = getClass().getResourceAsStream("/Pos_Testdata1.xlsx");

	    //creating book instance that refers to .xlsx file
		
		XSSFWorkbook book = new XSSFWorkbook(excelFilePath);
		//creating a sheetLogin object
        XSSFSheet sheetLogin = book.getSheet("LoginData");
        
       // int rowcount = sheetLogin.getLastRowNum()-sheetLogin.getFirstRowNum();
        
        //System.out.println("TestCases Count :"+rowcount);
        	        
        // get number of rows from sheet
        int rows = sheetLogin.getPhysicalNumberOfRows();

        // get number of cell from row
        int cells = sheetLogin.getRow(0).getPhysicalNumberOfCells();
        
        System.out.println("Cells Count :"+cells);

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

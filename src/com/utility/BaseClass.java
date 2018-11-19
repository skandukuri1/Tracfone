package com.utility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {

	static boolean b = true;
	public String TestReportspath;
	public String suiteName;
	public String TestName = null;
	public String TestFullName = null;
	public  String winHandleBefore = null;
	public List<String> desc = new ArrayList<>();
	int r;
	public Map<String, String> reportDetails = new HashMap();
	public Logger log=Logger.getLogger(com.utility.BaseClass.class);
	public static ReadData readData=new ReadData();
	public HtmlReport htmlrep = new HtmlReport();
	public static  WebDriver driver = null;
	
	/*
	 * This method is used to open the browser
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @param:		browserName 
	 * @return:		Nothing
	 * 
	 */
	
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\libs\\geckodriver.exe");
			log.info("Opened Firefox browser");
			driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\lib\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", "D:\\libs\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		else if (browserName.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\libs\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Opened the browser "+driver);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/*
	 * This method is used to open the URL
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @param:		url 
	 * @return:		Nothing
	 * 
	 */
	
	public void openURL(String url) throws Exception {
		try {
			driver.get(url);
			log.info("Opened the URL "+url);
		} catch (RuntimeException e) {
			readData.addStepDetails("Launch Application", "Application should be launched", "Error in launching the application:" + e.getMessage(), "FAIL","N");
			log.fatal("Unable to Open the URL "+e.getMessage());
		}

	}
	
	/*
	 * This method is used to click on the element
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @param:		locator 
	 * @return:		true/false
	 * 
	 */
	public boolean click(By locator) throws Exception {
		boolean blnVal = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			for (int i=0; i<25; i++){ 
				Thread.sleep(1000);
				if (js.executeScript("return document.readyState").toString().equals("complete")){ 
					driver.findElement(locator).click();
					log.info("Clicked on "+locator);
					blnVal=true;
					break; 
				}  
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal("Unable to click on "+locator);
		}
		return blnVal;
	}

	public boolean mouseHover(By locator1, By locator2) {
		boolean blnVal = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			for(int i=0;i<25;i++) {
				Thread.sleep(1000);
				if(js.executeScript("return document.readyState").toString().equals("complete")) {
					
					WebElement element1 = driver.findElement(locator1);
					WebElement element2 = driver.findElement(locator2);
					Actions action =  new Actions(driver);
					action.moveToElement(element1).build().perform();
					Thread.sleep(500);
					element2.click();
					log.info("Clicked on" +locator2);
					blnVal = true;
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return blnVal;
	}
	/*
	 * This method is used to enter the text
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @param:		locator
	 * @param:		data 
	 * @return:		true/false
	 * 
	 */
	public boolean type(By locator, String data) throws Exception {
		boolean blnVal =  false;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			for (int i=0; i<25; i++){
				System.out.println("Web ELement: "+locator);
				System.out.println("Value: "+data);
				Thread.sleep(1000);
				if (js.executeScript("return document.readyState").toString().equals("complete")){ 
					driver.findElement(locator).sendKeys(data);
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ENTER);
					log.info("Entered the value in the Textbox :"+locator);
					blnVal = true;
					break; 
				}  
			}
		} catch (RuntimeException localRuntimeException) {
			System.out.println("Error in entering the text in element:" + localRuntimeException.getMessage() + "Fail");
			readData.addStepDetails("Enter Text", "Text Element should be enabled", "Error in entering the text in element: " + localRuntimeException.getMessage(), "FAIL","N");
			log.fatal("Unable to Enter the value in the Textbox :"+locator);
		}
		return blnVal;
	}

	/*
	 * This method is used to select the value from dropdown using VisibleText
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @param:		locator
	 * @param:		data
	 * @return:		Nothing
	 * 
	 */
	public boolean select(By locator, String data) throws Exception {
		boolean blnVal = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			for (int i=0; i<25; i++){ 
				Thread.sleep(1000);
				if (js.executeScript("return document.readyState").toString().equals("complete")){ 
			Select s = new Select(driver.findElement(locator));
			s.selectByVisibleText(data);
			log.info("Selected value in drop down :"+locator);
			blnVal = true;
			break;  
				}
			}
		} catch (RuntimeException localRuntimeException) {
			System.out.println("Error in selecting value from dropdown:" + localRuntimeException.getMessage() + "Fail");
			readData.addStepDetails("Select list item", "List item should be selected", "Error in selecting value from dropdown: " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}
		return false;
	}

	/*
	 * This method is used to select the value from dropdown using Index
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @param:		locator
	 * @param:		no 
	 * @return:		Nothing
	 * 
	 */
	public boolean selectByIndex(By locator, int no) throws Exception {
		boolean blnVal = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			for (int i=0; i<25; i++){ 
				Thread.sleep(1000);
				if (js.executeScript("return document.readyState").toString().equals("complete")){ 
			Select dropdown = new Select(driver.findElement(locator));
			dropdown.selectByIndex(no);
			log.info("Selected value in drop down :"+locator);
			blnVal = true;
			break;  
				}
			}
			} catch (RuntimeException localRuntimeException) {
			System.out.println("Error in selecting value from dropdown:" + localRuntimeException.getMessage() + "Fail");
			readData.addStepDetails("Select list item", "List item should be selected", "Error in selecting value from dropdown: " + localRuntimeException.getMessage(), "FAIL","N");
		}
		return blnVal;
	}


	/*
	 * This method is used to switch window using Index
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @param:		inndex
	 * @return:		Nothing
	 * 
	 */
	public void switchwindow(int index) throws Exception {
		try {
			String childHandl = (String) driver.getWindowHandles().toArray()[index];
			driver.switchTo().window(childHandl);
			driver.manage().window().maximize();
		} catch (RuntimeException localRuntimeException) {
			System.out.println("Error in Switching the window:" + index + "Fail");
			readData.addStepDetails("Switch to Window", "Switch to window should be done", "Error in Switching to the Window: " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}

	}


	/*
	 * This method is used to switch frame
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @param:		elem
	 * @return:		Nothing
	 * 
	 */
	public void switchframe(WebElement elem) throws Exception {
		try {
			driver.switchTo().frame(elem);
		} catch (RuntimeException localRuntimeException) {
			System.out.println("Error in Switching the Frame:" + localRuntimeException.getMessage() + "Fail");
			readData.addStepDetails("Switch to Frame", "Frame should be available", "Error in Switching to the Frame: " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}

	}


	/*
	 * This method is used to switch back to default frame
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @return:		Nothing
	 * 
	 */
	public void switchToDefaultFrame() throws Exception {
		try {
			driver.switchTo().defaultContent();
		} catch (RuntimeException localRuntimeException) {
			System.out.println("Error in Switching the Frame:" + localRuntimeException.getMessage() + "Fail");
			readData.addStepDetails("Switch to Default Frame", "Default Frame should be available", "Error in Switching to the Default Frame: " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}

	}

	/*
	 * This method is used to select the value from dropdown using Index
	 * @author:		Sharath Bandari
	 * @version:	1.0
	 * @since:		08/16/2018
	 * @param:		locator
	 * @param:		no 
	 * @return:		Nothing
	 * 
	 */
	public  boolean js_type(By by,String Text, String LocatorName) throws Throwable{
		boolean flag=true;
		try {

			WebElement location=driver.findElement(by);
			((JavascriptExecutor)driver).executeScript("arguments[0].value='"+Text+"'", location);
			return true;

		} catch (Exception e) {
			flag=false;
			return false;
		}
		finally{
			if (flag) {
				System.out.println("Type Data into "+LocatorName+ "Able to Type Data into :" + LocatorName);
			}
			else{
				System.out.println("Type Data into "+LocatorName+ "Able to Type Data into :" + LocatorName);
			}
		}
	}

	public  boolean JSClick(By locator, String locatorName) throws Exception {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			flag = true;
		}
		catch (Exception e) {
		} 	
		return flag;

	}

	public  void highlight(By locator) throws Exception 
	{
		try{

			WebElement elem = driver.findElement(locator);
			JavascriptExecutor je=(JavascriptExecutor)driver;
			je.executeScript("arguments[0].style.border='3px solid blue'", elem);

		} catch (RuntimeException localRuntimeException)
		{
			System.out.println("Error in Highlighting the element :" + localRuntimeException.getMessage() + "Fail");
			readData.addStepDetails("highlight the element", "Element should be highlighted ", "Error in Highlighting the element : " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}
	}

	public  void highlight(WebElement elem) throws Exception 
	{
		try{

			JavascriptExecutor je=(JavascriptExecutor)driver;
			je.executeScript("arguments[0].style.border='3px solid blue'", elem);

		} catch (RuntimeException localRuntimeException)
		{
			System.out.println("Error in Highlighting the element :" + localRuntimeException.getMessage() + "Fail");
			readData.addStepDetails("highlight the element", "Element should be highlighted ", "Error in Highlighting the element : " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}
	}

	public void waitForElement(By locator, int timer) throws Exception{
		try{
			for (int i = 0; i < timer; i++) {
				try{
					driver.findElement(locator).isDisplayed();
					System.out.println("Element is available :"+locator);
					break;
				}catch (RuntimeException localRuntimeException) { 
					Thread.sleep(1000);
					System.out.println("Waiting for........"+locator);
				} 
			}
		}catch (RuntimeException localRuntimeException) {
			System.out.println("Error in performing Wait:" + localRuntimeException.getMessage() + "Fail");
			readData.addStepDetails("Error in performing Wait:", "It should wait for the element", "Error in performing Wait:: " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}
	}

	public static boolean IsElementPresent(String loc)  {
		if (driver.findElement(By.xpath(loc)).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public int totalitemsdropdownlist(WebElement elem)  {
		List<WebElement> dropdown_values = null;
		try {
			Select dropdownfield = new Select(elem);
			dropdown_values = dropdownfield.getOptions();

		} catch (RuntimeException localRuntimeException) {
			System.out.println("Error in finding total no. of elements in dropdown: " + localRuntimeException.getMessage() + "Fail");
			// readData.addStepDetails("List box size", "Get the no of items available in the dropdown", "Error in finding total no. of elements in dropdown: " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}
		return dropdown_values.size();
	}

	public static void verifyElementIsEnabled(WebElement elem, boolean paramBoolean) 
	{
		try
		{
			boolean bool = elem.isEnabled();
			if (bool == paramBoolean)
				System.out.println("Element is present in expected state"+elem+"Pass");
			else
				System.out.println("Element is not present in expected state"+elem+"Fail");
		}
		catch (RuntimeException localRuntimeException)
		{
			System.out.println("Element not found:"+elem+"Fail");
			//    readData.addStepDetails("Verify Element", "Element should be present", "Element not found: " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}
	}

	public  boolean isAlertPresent() {
		boolean foundAlert = false;
		try{
			WebDriverWait wait = new WebDriverWait(driver, 60L);
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		}
		catch(RuntimeException localRuntimeException)
		{
			System.out.println("Error in finding Alert Is Present:Fail");
			// readData.addStepDetails("Verify Alert", "Alert should be present", "Alert not found: " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		} 
		return foundAlert;
	}

	public  void handleConfirmation(String paramString) 
	{
		Alert localAlert = driver.switchTo().alert();
		if (localAlert != null)
		{
			if (paramString.trim().equalsIgnoreCase("Y"))
			{
				System.out.println("Alert accepted!!!");
				localAlert.accept();
			}
			else if (paramString.trim().equalsIgnoreCase("N"))
			{
				System.out.println("Alert Rejected!!!");
				localAlert.dismiss();
			}
		}
		else
		{
			System.out.println("Error in finding Alert:Fail");
			//   readData.addStepDetails("Verify Alert", "Alert should be present", "Error in finding Alert: ", "FAIL","N");
		}
	}

	public  String getAlertMessageText()
	{
		String str1 = null;
		try{
			str1 = driver.switchTo().alert().getText();
			return str1;
		}catch(Exception e){
			// readData.addStepDetails("Verify Popup message", "Popup message should be available", "Alert is not present", "FAIL","Y");
		}
		return str1;
	}

	public void switchBackToOriginalBrowser() 
	{
		try{
			driver.switchTo().window(winHandleBefore);
		}
		catch(RuntimeException localRuntimeException)
		{
			System.out.println("Error in switching to original Browser");
			// readData.addStepDetails("Switch back to Original Browser", "Default Browser should be present", "Error in switching to Original browser: "+localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}

	}


	public void pressEnterKey()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void swtichToChildTab() {
		try {
			winHandleBefore = driver.getWindowHandle();
			System.out.println("Parent Window: "+winHandleBefore);
			String childHandl = (String) driver.getWindowHandles().toArray()[1];
			System.out.println("Child Window: "+childHandl);
			driver.switchTo().window(childHandl);
			driver.manage().window().maximize();
			System.out.println("Switched backed to child tab"+"Pass");
		} catch (Exception e) {
			System.out.println("Error in Switching back to child tab"+"fail");
		}

	}

	public void VerifyText(WebElement elem, String paramString2)
	{
		try
		{
			String selectedOption = new Select(elem).getFirstSelectedOption().getText();
			if (selectedOption.trim().equalsIgnoreCase(paramString2))
			{
				System.out.println("Text was found :"+paramString2+"Pass");
				//  readData.addStepDetails("Verify Element", "Element "+paramString2+" should be available", "Element "+paramString2+" was found in DOM", "PASS","N");
			}
			else
			{
				System.out.println("Text was not found :"+paramString2+"Fail");
				//  readData.addStepDetails("Verify Element", "Element "+paramString2+" should be available", "Element "+paramString2+" is not found", "FAIL","N");
			}
		}
		catch (RuntimeException localRuntimeException)
		{
			System.out.println("Element was not found :"+elem+"Fail");
			//   readData.addStepDetails("Verify Element", "Element "+paramString2+" should be available", "Error in finding the element", "FAIL","N");
			localRuntimeException.getMessage();
		}
	}

	/*	public String getToolTipText(WebElement elem,String paramString1) {
		String tooltip = null;
		try{
			if (elem != null)
			{
				tooltip = elem.getAttribute(paramString1);  
			}
		}
		catch (RuntimeException localRuntimeException) {
			System.out.println("Error in Getting tool tip text:"+localRuntimeException.getMessage()+"Fail");
			localRuntimeException.getMessage();
		}
		return tooltip;
	}*/

	public String getToolTipText(By elem,String paramString1) {
		String tooltip = null;
		try{
			if (elem != null)
			{
				tooltip = ((WebElement) elem).getAttribute(paramString1);  
			}
		}
		catch (RuntimeException localRuntimeException) {
			System.out.println("Error in Getting tool tip text:"+localRuntimeException.getMessage()+"Fail");
			localRuntimeException.getMessage();
		}
		return tooltip;
	}

	public static void verifyListItems(WebElement elem){
		try{
			Select listBox = new Select(elem);
			List<WebElement> allItems = listBox.getOptions();
			for (WebElement item:allItems){
				System.out.println("Item is available in list:"+item);
			}
		}catch (Exception e){
			System.out.println("Issue While Selecting Value in Drop Down Object :"+elem);
		}
	}

	public static By getLocators(String paramString1, String paramString2)
	{
		if (paramString1.trim().equalsIgnoreCase("xpath"))
			return By.xpath(paramString2);
		if (paramString1.trim().equalsIgnoreCase("cssselector"))
			return By.cssSelector(paramString2);
		if (paramString1.trim().equalsIgnoreCase("tagname"))
			return By.tagName(paramString2);
		if (paramString1.trim().equalsIgnoreCase("id"))
			return By.id(paramString2);
		if (paramString1.trim().equalsIgnoreCase("name"))
			return By.name(paramString2);
		if (paramString1.trim().equalsIgnoreCase("linktext"))
			return By.linkText(paramString2);
		return null;
	}
	public static String defaultdropdownselecteditem(WebElement elem) {

		Select dropdownfield = new Select(elem);
		String text = dropdownfield.getFirstSelectedOption().getText();
		System.out.println(text.trim());
		return dropdownfield.getFirstSelectedOption().getText().trim();
	}

	public String alldropdownlistvalues(WebElement elem) {
		Select dropdownfield = new Select(elem);
		List<WebElement> dropdownfield_values = dropdownfield.getOptions();

		String allvalues = "";
		for (int i = 0; i < dropdownfield_values.size(); i++) {
			String currentvalue = dropdownfield_values.get(i).getText();
			String concatvalue = allvalues + currentvalue + ",";
			allvalues = concatvalue;
		}

		return allvalues.substring(0, allvalues.length() - 1);
	}

	public String getdate(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date d=new Date();
		String date = df.format(d);
		System.out.println(date);
		return date;
	}

	public static String getattributevalue(WebElement elem, String requiredattribute) throws Exception {
		String attribute = null;
		try{
			attribute = elem.getAttribute(requiredattribute);
		}catch(RuntimeException localRuntimeException){
			// readData.addStepDetails("Get Element Attribute", "Element attribute should able to get", "Error in getting the Element attribute" + elem, "FAIL","N");
		}
		return attribute;
	}

	public void alertaction(String action) {

		try {
			if (action.equals("ok")) {
				driver.switchTo().alert().accept();
			} else if (action.equals("cancel")) {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {
			System.out.println("Error in performing action on Alert box:" + action + "Fail");
		}

	}

	public  String printText(By locator) {
		String text= driver.findElement(locator).getText();
		System.out.println("The text is :"+text);
		return text;
	}

	public int totallinnks(WebElement elem) {
		return elem.findElements(By.tagName("a")).size();
	}

	public void capturesnapshot(String destinationPath) throws IOException {
		try {
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(destinationPath));
		}
		catch (Exception e) {
			System.out.println("Error in Capturing Screenshot:Fail");
		}

	}

	public void dragAndDrop(By question, By target){
		WebElement e1=driver.findElement(question);
		WebElement e2=driver.findElement(target);
		Actions a=new Actions(driver);
		a.dragAndDrop(e1, e2).build().perform();
	}

	public boolean verifyElementExist(WebElement elem)
	{
		boolean blnStatus = false;
		WebDriverWait localWebDriverWait = new WebDriverWait(driver, 60L);
		try
		{
			localWebDriverWait.until(ExpectedConditions.presenceOfElementLocated((By) elem));
			System.out.println("Element is available:"+elem+"Pass");
			blnStatus = true;

		}
		catch (RuntimeException localRuntimeException)
		{
			System.out.println("Error in finding Element:"+localRuntimeException.getMessage() +"Pass");
		}
		return blnStatus;
	}

	public void Mousehover(WebElement elem)
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(elem).build().perform();
		}
		catch (RuntimeException localRuntimeException)
		{
			System.out.println("Error in Hover on element"+localRuntimeException.getMessage()+"Pass");

		}
	}

	public void selectListItem(WebElement elem, String paramString)
	{
		int i = 0;
		try
		{
			List localList = driver.findElements(By.tagName("option"));
			Iterator localIterator = localList.iterator();
			while (localIterator.hasNext())
			{
				WebElement localWebElement2 = (WebElement)localIterator.next();
				if (paramString.trim().equalsIgnoreCase(localWebElement2.getText().trim()))
				{
					i = 1;
					localWebElement2.click();
					break;
				}
			}
			System.out.println("Selected option:"+paramString+"Successfully"+"Pass");
			if (i == 0)
			{
				System.out.println("Selected option:"+paramString+"is not present"+"Fail");
			}
		}
		catch (RuntimeException localRuntimeException)
		{
			System.out.println("Issue while Selected value:"+localRuntimeException.getMessage()+"is not present"+"Fail");
		}
	}

	public void wait(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());;
		}
	}

	public void switchToBrowser(String paramString)
	{
		try{
			winHandleBefore = driver.getWindowHandle();
			String str1 = paramString;
			int i = 0;
			Iterator localIterator = driver.getWindowHandles().iterator();
			while (localIterator.hasNext())
			{
				String str2 = (String)localIterator.next();
				if (driver.switchTo().window(str2).getTitle().equalsIgnoreCase(str1.trim()))
				{
					i = 1;
					driver.switchTo().window(str2);
				}
				else
				{
					driver.switchTo().window(winHandleBefore);
				}
			}
			if (i == 0)
				System.out.println("The Browser Window with title : " + str1 + " is not found");
		}
		catch(Exception e)
		{
			System.out.println("Error in switching to browser"+e.getMessage());
		}
	}
	public void checkPageLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for (int i=0; i<25; i++){ 
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {} 
			if (js.executeScript("return document.readyState").toString().equals("complete")){ 
				break; 
			}  
		}
	}
	
	@BeforeSuite
	public void setUpSuiteDetails(ITestContext ctx) throws Exception{
		System.out.println("----------------------------------------: BeforeSuite");
		readData.suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		System.out.println("readData.suiteName "+readData.suiteName);
		readData.generateSuiteResultFolder();
		TestReportspath ="D:\\workspace\\AutoWFM\\WFM\\TestReports\\" + 
		readData.suiteName + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		readData.generateSuiteResultFolder();
	}
	@BeforeMethod
	public void captureDesc(Method method){
		System.out.println("----------------------------------------: BeforeMethod");
		Test test = method.getAnnotation(Test.class);
		if(!test.description().toString().equals("")){
			desc.add(test.description());
			System.out.println("Test Description is: "+test.description());
			
		}
	} 
	@AfterMethod
	public void closeBrowser() throws Exception{
		wait(5000);
		driver.close();
	}
	@AfterSuite
	public void afterSuite() throws Exception{
		try{
			System.out.println("----------------------------------------: AfterSuite");
			File local=readData.suiteFolder;
			htmlrep.generateHtmlReport(TestName);

		} catch (Exception ex){
			System.out.println("Result Suite file is not being generated : "+ex.getMessage());
		}
	}

	@BeforeClass
	public void BeforeClass() throws Exception
	{ 
		System.out.println("----------------------------------------: BeforeClass");
		Thread.sleep(1000);
		TestName = this.getClass().getSimpleName();
		TestFullName = this.getClass().getName();
		System.out.println("TestName ::::::::::::::::"+TestName);
		System.out.println("D:\\workspace\\AutoWFM\\WFM\\Repository\\TestData.xls");
		Thread.sleep(2000);
	}

	@AfterClass 
	public void afterClass() throws Exception
	{
		System.out.println("----------------------------------------: AfterClass");
		readData.addSummaryReport(TestName,desc.get(r), TestFullName);
		r++;
		readData.knowTestCaseStatus(TestName);
	} 

}
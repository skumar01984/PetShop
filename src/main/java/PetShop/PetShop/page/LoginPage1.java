package PetShop.PetShop.page;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginPage1 extends PetShop.PetShop.util.BasePage{
	
	//WebDriver driver ;
	String userName = "";
	File prjDir = new File(System.getProperty("user.dir"));
	String psw="";
	String total_Price = "";
	boolean status = false;
	
	
	// Register User
	By newAccount = By.name("newAccount");
	By btnRegister = By.linkText("Register Now!");
	By registerUsername = By.name("repeatedUsername");
	By registerPassword = By.name("repeatedPassword");
	By fName = By.name("account.firstName");
	By lName = By.name("account.lastName");
	By useremail = By.name("account.email");
	By phone = By.name("account.phone");
	By address1_tb = By.name("account.address1");
	By address2_tb = By.name("account.address2");
	By city = By.name("account.city");
	By state = By.name("account.state");
	By zip = By.name("account.zip");
	By country = By.name("account.country");
	By profileInfo = By.cssSelector("#Catalog > form");
	By favCategories_dd = By.name("account.favouriteCategoryId");
	By myList_cb = By.name("account.listOption");
	By myBanner_cb = By.name("account.bannerOption");
	
	
	//Login 
	By lnkSignIn = By.linkText("Sign In");
	By tbUserName = By.name("username");
	By tbPassword = By.name("password");
	By btnSigin = By.name("signon");
	By welcomeText  = By.id("WelcomeContent"); 
	By signOut = By.linkText("Sign Out");
	
	// search Dog And Add To Cart Second Dog And Confirm Order
		By search_tb = By.name("keyword");
		By search_btn = By.name("searchProducts");
		By dogId = By.xpath("//a[contains(text(),'K9-')]");
		By addToCart = By.xpath("(//a[contains(text(),'Add to Cart')])[2]");
		By proceeedToCheckOut = By.linkText("Proceed to Checkout");
		By continue_btn = By.xpath("//input[@value='Continue']"); 
		By confirm_btn = By.xpath("//div[@id='Catalog']/table/following-sibling::a"); 
		
	
	public boolean waitForJStoLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
       
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jsLoad);
    }
	
	@Test(priority=0)
    public void CreateLoginAccount() throws InterruptedException {
        try {
        	String str = prjDir+"\\src\\test\\java\\driver\\chromedriver.exe";
        	System.out.println(str);
        	DesiredCapabilities cap = DesiredCapabilities.chrome();
            // cap.setCapability("chrome.binary",file.getAbsolutePath());
            ChromeOptions objOptions = new ChromeOptions();
            //objOptions.setExperimentalOption("prefs", prefs);
            objOptions.addArguments("--disable-notifications");
        	System.setProperty("webdriver.chrome.driver",prjDir+"\\src\\test\\java\\driver\\chromedriver.exe");
        	//FirefoxProfile firefoxProfile = new FirefoxProfile();
            driver = new ChromeDriver(objOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
            driver.get("https://petstore.octoperf.com/actions/Catalog.action");
            waitForJStoLoad();
        	String firstName = getRandomString();
        	String lastName = getRandomString();
        	psw = "Sk123@10";
        	userName = "skumar "+getRandomValue();
        	String email = "skumar"+getRandomValue()+"@gmail.com";
        	javaScriptClickOn(lnkSignIn);
        	Thread.sleep(2000);
        	waitForJStoLoad();
        	clickOn(btnRegister);
        	Thread.sleep(2000);
        	enterText(registerUsername ,userName );
        	keyBoard(registerUsername, Keys.TAB);
        	enterText(tbPassword ,psw );
        	enterText(registerPassword ,psw );
        	enterText(fName, firstName);
        	keyBoard(fName, Keys.TAB);
        	enterText(lName, lastName);
        	keyBoard(lName, Keys.TAB);
        	enterText(useremail, email);
        	keyBoard(useremail, Keys.TAB);
        	enterText(phone, getRandomValue()+"17");
        	keyBoard(phone, Keys.TAB);
        	enterText(address1_tb, getRandomValue()+"");
        	keyBoard(address1_tb, Keys.TAB);
        	enterText(registerUsername, getRandomString()+"");
        	keyBoard(registerUsername, Keys.TAB);
        	enterText(city, getRandomString());
        	keyBoard(city, Keys.TAB);
        	enterText(state, "Delhi");
        	keyBoard(state, Keys.TAB);
        	enterText(zip, getRandomValue()+"12");
        	keyBoard(zip, Keys.TAB);
        	enterText(country, "India");
        	clickOn(profileInfo);
        	selectFromList(favCategories_dd, "DOGS");
        	clickOn(myList_cb);
        	clickOn(myBanner_cb);
        	javaScriptClickOn(newAccount);
        	waitForJStoLoad();
        	Thread.sleep(2000);
        	driver.navigate().refresh();
        	driver.close();
        }catch (Exception e) {
        	e.printStackTrace();
        	driver.close();
        	}
        }


	@Test(priority=1)
    public void Login() throws InterruptedException {
        try {
        Thread.sleep(2000);
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        waitForJStoLoad();
        enterText(tbUserName, userName);
        enterText(tbPassword, psw);
        clickOn(btnSigin);
        Thread.sleep(2000);
        waitForJStoLoad();
        driver.navigate().refresh();
        
        isDisplayed(welcomeText, DefaultTimeOut);
        
		/*
		 * if(getWebElement(logOut).isEnabled() && getWebElement(logOut).isDisplayed())
		 * { clickOn(logOut); waitForJStoLoad(); } else {
		 * System.out.println("Logout Element not found"); }
		 */
  
    }catch (Exception e) {
		e.printStackTrace();
		driver.close();
		
	}
        
  }

	
	// search Dog And Add To Cart Second Dog And Confirm Order
		
	@Test(priority=2)
    public void searchDogAndAddToCartSecondDogAndConfirmOrder() throws InterruptedException {
        try {
        	
       clickOn(search_tb);
       enterText(search_tb, "dogs");
       clickOn(search_btn);
       Thread.sleep(2000);
       MouseHover(dogId);
       javaScriptClickOn(dogId);
       Thread.sleep(2000);
       clickOn(addToCart); 	
       Thread.sleep(2000);
       waitForJStoLoad();
       driver.navigate().refresh();
       javaScriptClickOn(addToCart);
       waitForJStoLoad();
       Thread.sleep(1000);
       javaScriptClickOn(proceeedToCheckOut);
       waitForJStoLoad();
       Thread.sleep(1000);
       javaScriptClickOn(continue_btn); 
       waitForJStoLoad();
       Thread.sleep(1000);
       javaScriptClickOn(confirm_btn); 
       waitForJStoLoad();
       Thread.sleep(1000);
       
    }catch (Exception e) {
		e.printStackTrace();
		driver.close();
		
	}
        
  }
	
	// Sign Out from the application
	@Test(priority=3)
	public void signOut() {
		if(getWebElement(signOut).isEnabled() && getWebElement(signOut).isDisplayed()) {
			clickOn(signOut);
			waitForJStoLoad();
        }
        else {
            System.out.println("Logout Element not found");
        }	
	   }
	
		
	@Test(dependsOnMethods = { "signOut" })
    public void LoginAgain() throws InterruptedException {
        try {
        Thread.sleep(2000);
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        waitForJStoLoad();
        enterText(tbUserName, userName);
        enterText(tbPassword, psw);
        clickOn(btnSigin);
        Thread.sleep(2000);
        waitForJStoLoad();
        driver.navigate().refresh();
        
        isDisplayed(welcomeText, DefaultTimeOut);
        
		/*
		 * if(getWebElement(logOut).isEnabled() && getWebElement(logOut).isDisplayed())
		 * { clickOn(logOut); waitForJStoLoad(); } else {
		 * System.out.println("Logout Element not found"); }
		 */
  
    }catch (Exception e) {
		e.printStackTrace();
		driver.close();
		
	}
	}	

}


package monitora.medicalbox.web.support;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import monitora.medicalbox.web.po.LoginPageObject;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Utils {
	
    private static WebDriver driver = null;

		public static WebDriver initDriver() throws Exception{
	       if(driver == null){
	    	   
	           
	    	   // Adicione as opções do Google Chrome. 
	    	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    	    ChromeOptions options = new ChromeOptions();
	    	    capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
	    	    capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
	    	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
	            driver = new ChromeDriver(capabilities);
	           
	       	    /*	   
	    	    // Adicione as opções do Firefox. 
	            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
	            driver = new FirefoxDriver();
	            */ 
	        }
	        return driver;
	    }
		
	public static WebDriver getDriverInstance() {
		if(driver == null)
			try {
				return initDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return driver;
	}
	
	public static void login(WebDriver driver){
		driver.get("https://app.medicalbox.com.br/");
		driver.manage().window().maximize();
		
		LoginPageObject login = new LoginPageObject(driver);
		login.fillEmailLogin("claudio.rioliv@gmail.com");
		login.fillPasswordLogin("Audrey67");
		login.clickBtnLogin();
    }
		
	private static Wait wait = new FluentWait(getDriverInstance())
	            .withTimeout(30, SECONDS)
	            .pollingEvery(5, SECONDS)
	            .ignoring(NoSuchElementException.class);

	public static void waitForSplashInvisibility(){
	    By loadIconLocator = By.xpath("//img[@src='/assets/images/mbloading.svg']");
	    ExpectedCondition expectedCondition = ExpectedConditions.invisibilityOfElementLocated(loadIconLocator);
	    fluentWaitByExpectedCondition(expectedCondition);
	    }
	
	public static void waitForInformationMsg(){
	    By loadIconLocator = By.xpath("//div[@class='noty_bar noty_type_information']");
	    ExpectedCondition expectedCondition = ExpectedConditions.invisibilityOfElementLocated(loadIconLocator);
	    fluentWaitByExpectedCondition(expectedCondition);
	    }
	
	public static void waitForSuccessMessage(){
        By loadIconLocator = By.xpath("//div[@class='noty_bar noty_type_success']");
        ExpectedCondition expectedCondition = ExpectedConditions.invisibilityOfElementLocated(loadIconLocator);
        fluentWaitByExpectedCondition(expectedCondition);
    }
	
	private static void fluentWaitByExpectedCondition(ExpectedCondition waitCondition) {
	    wait.until(waitCondition);
	}
}

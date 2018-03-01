package monitora.medicalbox.web.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Utils {
	
    private static WebDriver driver = null;

		public static WebDriver initDriver() throws Exception{
	        if(driver == null){
	            String path;
	            switch(System.getProperty("os.name").split(" ")[0]){
	                case "Mac" :  path ="./src/main/resources/mac_chromedriver"; break;
	                case "Linux" :  path ="/src/main/resources/chromedriver"; break;
	                case "Windows" :  path ="\\src\\main\\resources\\chromedriver.exe"; break;
	                default: throw new Exception();
	            }
	            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--incognito");
	            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ path);
	            driver = new ChromeDriver(capabilities);
	                    
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
		
	private static Wait wait = new FluentWait(getDriverInstance())
	            .withTimeout(30, SECONDS)
	            .pollingEvery(5, SECONDS)
	            .ignoring(NoSuchElementException.class);

	public static void waitForSplashInvisibility(){
	        By loadIconLocator = By.xpath("//img[@src='/assets/images/mbloading.svg']");
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

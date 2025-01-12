import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGSeleniumJava101_IE {

    private WebDriverWait wait;
	private WebDriver driver = null;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "IE");
        options.setCapability("browserVersion", "11.0");
        options.setCapability("platformName", "Windows 10");

 
        options.setCapability("lt:options", Map(
                "username", "sonali_kolpe",
                "accessKey", "wjTKL5NsIg04bHbNZx0c6FP6Iw4O27kH2Cu9xNuUTqh2p8NmIh",
                "build name", "TestNG Assignment",
                "name", "Sample Test",
                "network", true,
                "console", true,
                "visual", true
            ));
         
                driver = new RemoteWebDriver(new URL("http://sonali_kolpe:wjTKL5NsIg04bHbNZx0c6FP6Iw4O27kH2Cu9xNuUTqh2p8NmIh@hub.lambdatest.com/wd/hub"), options);
                driver.get("https://www.lambdatest.com/selenium-playground/");
        	    wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit wait setup
    }
	private String Map(String string, String string2, String string3, String string4, String string5, String string6,
		String string7, String string8, String string9, boolean b, String string10, boolean c, String string11, boolean d) {
	return null;
    }
	
	
    @Test(priority = 0)
    public void testScenario1() {
        // Perform explicit wait till the title is available
        wait.until(ExpectedConditions.titleIs("Selenium Grid Online | Run Selenium Test On Cloud"));

        // SoftAssert for validating the Page Title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "LambdaTest", "Page title is incorrect!");
        
        // Following statements will still execute even if the assertion fails
        System.out.println("This statement executes after soft assert.");
        
        // Collate all soft assertions
        softAssert.assertAll();
    }

    // Test Scenario 2: Checkbox Validation
 
	@Test(priority = 1)

    public void testScenario2() throws InterruptedException {
 
    driver.findElement(By.linkText("Checkbox Demo")).click();

    // Click the checkbox under "Single Checkbox Demo"
    WebElement singleCheckbox = driver.findElement(By.id("isAgeSelected"));
    singleCheckbox.click();
 
    // Validate that the checkbox is selected
    SoftAssert softAssert = new SoftAssert();
//    WebElement singleCheckboxselected = driver.findElement(By.id("txtAge"));
    softAssert.assertTrue(singleCheckbox.isSelected(), "Checkbox is selected!");
 
    // Click the checkbox again to unselect
    singleCheckbox.click();
 
    // Validate that the checkbox is unselected
    softAssert.assertFalse(singleCheckbox.isSelected(), "Checkbox is not selected!");
 
    // Assert all soft assertions
    softAssert.assertAll();
}
 
// Test Scenario 3: JavaScript Alert Validation
 
	@Test(priority = 2)
    public void testScenario3() throws InterruptedException {
    // Navigate to "Javascript Alerts"
    driver.findElement(By.linkText("Javascript Alerts")).click();
	 Thread.sleep(3000);
 
    // Click the "Click Me" button in the "Java Script Alert Box" section
    driver.findElement(By.xpath("//button[text()='Click Me']")).click();

    // Switch to the alert and validate the message
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    Alert alert = driver.switchTo().alert();
    String alertMessage = alert.getText();
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(alertMessage, "I am an alert box!", "Alert message does not match!");
    alert.accept();
    softAssert.assertAll();
}
 
    @AfterMethod
    public void tearDown() {
            driver.quit();
    }
    
}

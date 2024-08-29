import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LandRecordBihar {

	public static void main(String[] args) {
		// Set up WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        // Maximize window and set timeouts
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Navigate to Google
        driver.get("https://parimarjan.bihar.gov.in/biharBhumireport/Default");
        
        WebElement element = driver.findElement(By.xpath("//a[@href='http://parimarjan.bihar.gov.in/biharBhumireport/MutationStatusNew.aspx']//div[@class='wrap']"));
        element.click();
        
        WebElement element1 = driver.findElement(By.xpath("//select[@id='MainContent_ddlDistrict']"));
        Select select = new Select(element1);
        select.selectByVisibleText("Purnea");
        
//        WebElement element2 = driver.findElement(By.xpath("//select[@id='MainContent_ddlCircle']"));
//        Select select2 = new Select(element2);
//        select2.selectByVisibleText("Barhara kothi");
        
        
        WebElement element3 = driver.findElement(By.xpath("MainContent_ddlYearSession"));
        Select select3 = new Select(element3);
        select3.selectByVisibleText("2024 - 2025");
        
        
        driver.findElement(By.id("MainContent_btnproceed")).click();
        
        
        
        
        driver.quit();

	}

}

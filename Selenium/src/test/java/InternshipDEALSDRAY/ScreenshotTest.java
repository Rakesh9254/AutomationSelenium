package InternshipDEALSDRAY;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotTest {

    private WebDriver driver;
    
    private String baseUrl = "https://example.com"; // Replace with the target website

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void takeScreenshotsAtDifferentResolutions() throws IOException {
        // Array of resolutions to test
        Dimension[] resolutions = {
                new Dimension(1920, 1080),
                new Dimension(1366, 768),
                new Dimension(1536, 864)
        };

        // Iterate over each resolution
        for (Dimension resolution : resolutions) {
            // Set browser window size to the current resolution
            driver.manage().window().setSize(resolution);

            // Navigate to the website
            driver.get(baseUrl);

            // Take a screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Format the timestamp for the filename
            String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

            // Create the folder structure for saving screenshots
            String folderPath = "screenshots/" + resolution.width + "x" + resolution.height;
            Files.createDirectories(Paths.get(folderPath));

            // Save the screenshot to the specified directory
            File destFile = new File(folderPath + "/Screenshot-" + timeStamp + ".png");
            Files.copy(screenshot.toPath(), destFile.toPath());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

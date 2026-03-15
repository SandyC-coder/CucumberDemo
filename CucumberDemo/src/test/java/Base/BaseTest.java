package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;

    // Setup browser
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Teardown browser
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Getter for driver
    public static WebDriver getDriver() {
        return driver;
    }
}
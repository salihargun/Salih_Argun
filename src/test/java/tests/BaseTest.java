package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static WebDriver webDriver; // WebDriver nesnesi, tarayıcı örneğini tutar ve testlerde kullanılır.

    @BeforeMethod
    public void initializeDriver() {
        webDriver = getDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver() {
        webDriver.quit();
    }

    public static WebDriver getDriver() {
        // Sistemde tanımlı "BROWSER" ortam değişkeni okunur. Değer yoksa varsayılan olarak "CHROME" atanır.
        String browser = System.getenv("BROWSER");
        browser = (browser == null) ? "CHROME" : browser;

        switch (browser) {
            case "IE":
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "CHROME":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                }
                return new ChromeDriver(options);
        }
    }
}
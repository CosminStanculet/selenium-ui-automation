import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class SeleniumHelper {
    WebDriver driver;
    String baseURL = "https://demowebshop.tricentis.com/";
    @BeforeClass
    public void openChrome() {
        WebDriverManager.chromedriver().setup();

        // Path to the standalone Chrome for Testing binary
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/cosminstanculet/Downloads/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

//    @BeforeClass
//    public void openFirefox(){
//        System.setProperty("webdriver.gecko.driver", "/Users/cosminstanculet/Documents/geckodriver");
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get(baseURL);
//    }
}

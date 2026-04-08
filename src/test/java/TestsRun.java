import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestsRun extends SeleniumMethodsNew {

    @Test
    public void createUserTest (){
        createUser();
    }

    @Test
    public void loginUserAndAddAddressTest (){
        loginUser();
        addAddress();
    }

    @Test
    public void buyDesktopAsGuestTest () throws InterruptedException {
        buyDesktop();
        goToShoppingCart();
        completeFormGuest();
        shippingMethod();
        completeCardInfoAndPlaceOrder();
    }

    @Test
    public void loginAndBuyMultipleItemsTest () throws InterruptedException {
        loginUser();
        addMultipleItems();
        goToShoppingCart();
        shippingMethod();
        completeCardInfoAndPlaceOrder();
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SeleniumMethodsNew extends SeleniumHelper {
    String firstName = "Ethan";
    String lastName = "Carter";
    String email = "ethancarter1@yopmail.com";
    String passwordTest = "test1234";

    @Test
    public void createUser() {
        //create user
        driver.findElement(By.xpath("//div[1]/div[2]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
        WebElement registerFirstName = driver.findElement(By.id("FirstName"));
        registerFirstName.sendKeys(firstName);
        WebElement registerLastName = driver.findElement(By.id("LastName"));
        registerLastName.sendKeys(lastName);
        WebElement registerEmail = driver.findElement(By.id("Email"));
        registerEmail.sendKeys(email);
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(passwordTest);
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys(passwordTest);
        driver.findElement(By.id("register-button")).click();
        String registrationCompleted = driver.findElement(By.xpath("//div[2]/div/div[2]/div[1]")).getText();
        //Assert.assertEquals(registrationCompleted,"Your registration completed");
        driver.findElement(By.xpath("//div[2]/div[2]/input")).click();
    }

    @Test
    public void loginUser() {
        driver.findElement(By.className("ico-login")).click();
        WebElement emailLogin = driver.findElement(By.id("Email"));
        emailLogin.sendKeys(email);
        WebElement passwordlogin = driver.findElement(By.id("Password"));
        passwordlogin.sendKeys(passwordTest);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    @Test
    public void addAddress () {
        driver.findElement(By.xpath("//div[1]/div[2]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//div[1]/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.className("add-button")).click();
        WebElement firstNameAddress = driver.findElement(By.id("Address_FirstName"));
        firstNameAddress.sendKeys(firstName);
        WebElement lastNameAddress = driver.findElement(By.id("Address_LastName"));
        lastNameAddress.sendKeys(lastName);
        WebElement emailAddress = driver.findElement(By.id("Address_Email"));
        emailAddress.sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"Address_CountryId\"]/option[176]")).click();
        WebElement cityAddress = driver.findElement(By.id("Address_City"));
        cityAddress.sendKeys("Sibiu");
        WebElement address1Address = driver.findElement(By.id("Address_Address1"));
        address1Address.sendKeys("Blv. Unirii, no. 19,Building A, floor 6, ap. 65");
        WebElement zipAddress = driver.findElement(By.id("Address_ZipPostalCode"));
        zipAddress.sendKeys("111666");
        WebElement phoneAddress = driver.findElement(By.id("Address_PhoneNumber"));
        phoneAddress.sendKeys("0707222333");
        driver.findElement(By.xpath("//form/div/div[2]/div[2]/input")).click();
        driver.findElement(By.className("header-logo")).click();
    }

    @Test
    public void buyDesktop () throws InterruptedException {
        //buy a desktop
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[4]/div[1]/div[2]/ul[1]/li[2]/a "))).perform();
        WebElement elementDesktop = driver.findElement(By.xpath("//ul[1]/li[2]/ul/li[1]/a"));
        elementDesktop.click();
        driver.findElement(By.xpath("(//div[@class='details'])[2]//input[@type='button']")).click();
        driver.findElement(By.id("product_attribute_16_6_5")).click();
        driver.findElement(By.id("product_attribute_16_3_6_19")).click();
        driver.findElement(By.id("product_attribute_16_4_7_21")).click();
        driver.findElement(By.id("product_attribute_16_8_8_23")).click();
        driver.findElement(By.id("product_attribute_16_8_8_24")).click();
        driver.findElement(By.id("add-to-cart-button-16")).click();
        driver.findElement(By.className("close")).click();
    }

    @Test
    public void goToShoppingCart() throws InterruptedException {
        //go to cart and checkout
        Thread.sleep(250);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a")).click();
        //driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/p/a")).click();
        WebElement checkboxTerms = driver.findElement(By.id("termsofservice"));
        checkboxTerms.click();
        Assert.assertEquals(checkboxTerms.getAttribute("checked"), "true");
        driver.findElement(By.id("checkout")).click();
    }

    @Test
    public void addMultipleItems (){
        //add a book
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[2]/input")).click();
        //add an apparel
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//div[3]/div/div[2]/div[3]/div[2]/input")).click();
        //add a jewelry
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/ul/li[6]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"product_attribute_71_9_15\"]/option[3]")).click();
        WebElement length = driver.findElement(By.id("product_attribute_71_10_16"));
        String lengthJewelry = "25";
        length.sendKeys(lengthJewelry);
        driver.findElement(By.id("product_attribute_71_11_17_50")).click();
        driver.findElement(By.id("add-to-cart-button-71")).click();
    }

    @Test
    public void completeFormGuest () throws InterruptedException {
        //fill all mandatory fields for checkout as Guest
        driver.findElement(By.xpath("//div[1]/div[3]/input[1]")).click(); //checkout as Guest button
        driver.findElement(By.xpath("//div[1]/div[3]/input[1]")).click();
        WebElement firstName = driver.findElement(By.id("BillingNewAddress_FirstName"));
        String firstName1 = "John";
        firstName.sendKeys(firstName1);
        WebElement lastName = driver.findElement(By.id("BillingNewAddress_LastName"));
        String lastName1 = "Bing";
        lastName.sendKeys(lastName1);
        WebElement email = driver.findElement(By.id("BillingNewAddress_Email"));
        String email1 = "john.bing@yopmail.com";
        email.sendKeys(email1);
        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        String city1 = "Bucharest";
        city.sendKeys(city1);
        WebElement address = driver.findElement(By.id("BillingNewAddress_Address1"));
        String addressA = "Sector 3, Blv. Unirii, no. 19,Building A, floor 6, ap. 65";
        address.sendKeys(addressA);
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]/option[176]")).click();
        WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        String zipCode1 = "555191";
        zipCode.sendKeys(zipCode1);
        WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        String phoneNumber1 = "0712345678";
        phoneNumber.sendKeys(phoneNumber1);
    }

        @Test
        public void shippingMethod (){
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
        //select second 2Air shipping Method
        driver.findElement(By.id("shippingoption_2")).click();
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
        //select Credit Card (mastercard) as a payment method
        driver.findElement(By.id("paymentmethod_2")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"CreditCardType\"]/option[2]")).click();
    }

    @Test
    public void completeCardInfoAndPlaceOrder () throws InterruptedException {
        //complete credit card info and place the order
        WebElement name = driver.findElement(By.id("CardholderName"));
        String cardHolderName = "John Bing";
        name.sendKeys(cardHolderName);
        WebElement cardNumber = driver.findElement(By.id("CardNumber"));
        String cardNumberMasterCard = "5454 5454 5454 5454";
        cardNumber.sendKeys(cardNumberMasterCard);
        driver.findElement(By.xpath("//*[@id=\"ExpireMonth\"]/option[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"ExpireYear\"]/option[6]")).click();
        WebElement cardCode = driver.findElement(By.id("CardCode"));
        String cardCode1 = "737";
        cardCode.sendKeys(cardCode1);
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
        //maybe an improvement for sleep
        Thread.sleep(1000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String orderProcessed =  driver.findElement(By.tagName("strong")).getText();
        Assert.assertEquals(orderProcessed, "Your order has been successfully processed!");
    }

    @Test
    public void addTBlueJeans() throws InterruptedException {
        // add in Cart - TBlue Jeans from the second page
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//div[2]/div[4]/ul/li[3]")).click();
        driver.findElement(By.xpath("//div[3]/div/div[2]/div[3]/div[2]/input")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        Thread.sleep(25);
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a")).click();
        String jeans = driver.findElement(By.className("product-name")).getText();
        Assert.assertEquals(jeans,"TBlue Jeans");
    }


}

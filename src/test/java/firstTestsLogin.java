import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

public class firstTestsLogin {
    private WebDriver driver;
    private String url;
    private WebDriverWait wait;

    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        url = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

    }
    @AfterClass
    public void AfterClass(){

        //driver.quit();
    }

    @Test(enabled = true)
    public void TestLoginPositiv(){
        driver.get(url);
        driver.findElement(By.name("email")).sendKeys("buquxahu@cars2.club");
        driver.findElement(By.name("password")).sendKeys("kisulea");
        //driver.findElement(By.id("login")).click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("login")));

        String actualId = driver.findElement(By.xpath("//em[@class='icon-user']")).getAttribute("class");
        assertEquals("icon-user", actualId);

    }
   @Test(enabled = false)
    public void TestLoginNegativ1(){
        //Wrong email and correct password
        driver.get(url);
        driver.findElement(By.name("email")).sendKeys("buquxahu@cars22.club");
        driver.findElement(By.name("password")).sendKeys("kisulea");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("login")));

        String invalidCredentials = driver.findElement(By.xpath("//div[text() = 'Invalid Email or Password.']")).getText();
        assertEquals("Invalid Email or Password.", invalidCredentials);
    }
    @Test(enabled = false)
    public void TestLoginNegativ2(){
        //Wrong password and correct email
        driver.get(url);
        driver.findElement(By.name("email")).sendKeys("buquxahu@cars2.club");
        driver.findElement(By.name("password")).sendKeys("kisulea1");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("login")));

        String invalidCredentials = driver.findElement(By.xpath("//div[text() = 'Invalid Email or Password.']")).getText();
        assertEquals("Invalid Email or Password.", invalidCredentials);
    }
    @Test(enabled = false)
    public  void  TestLoginNegative3(){
        //empty password field and correct email
        driver.get(url);
        driver.findElement(By.name("email")).sendKeys("buquxahu@cars2.club");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("login")));

        String emptyPassword = driver.findElement(By.xpath("//form/div[2]/span[2]")).getText();
        assertEquals("This value is required.", emptyPassword);
    }
    @Test(enabled = false)
    public  void  TestLoginNegative4(){
        //empty email field and correct password
        driver.get(url);
        driver.findElement(By.name("password")).sendKeys("kisulea");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("login")));

        String emptyEmail = driver.findElement(By.xpath("(//span[text() = 'This value is required.'])[1]")).getText();
        assertEquals("This value is required.", emptyEmail);
    }

    //Registration test
    @Test(enabled = false)
    public void TestRegistration(){
        driver.get(url);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Register Now']"))).click();
        driver.findElement(By.xpath("//a[text()='Register Now']")).click();
        //user type
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("userType")));
       // Type first name
        driver.findElement(By.id("signUpFirstName")).sendKeys("MASHA");
        //Type last name
        driver.findElement(By.id("signUpLastName")).sendKeys("DANA");
        //Type email
        driver.findElement(By.id("signUpRegisterEmail")).sendKeys("MASHA13545@YAHOO.COM");
        //Type phone
        driver.findElement(By.id("signUpPhone")).sendKeys("7898767896");
        //TYPE PASSWORD
        String password="MASHA12534";
        driver.findElement(By.id("signUpRegisterPassword")).sendKeys(password);
        driver.findElement(By.id("signUpRegisterRePassword")).sendKeys(password);


        //Select country
        String country = "Venezuela";
        driver.findElement(By.xpath(".//*[@id='signUpCountry']/span")).click();
        driver.findElement(By.xpath("//span[contains(.,'"+ country +"')]")).click();


        //type address
        String address = "123 MAIN ST.";
        driver.findElement(By.id("signUpAddress")).sendKeys(address);
        //Type city
        String city ="Mountain View";
        driver.findElement(By.id("signUpCity")).sendKeys(city);
        //TYPE state
        String state = "California";
        driver.findElement(By.id("signUpState")).sendKeys(state);
        //Type postal code
        String zip = Integer.toString(55555);
        driver.findElement(By.id("signUpZip")).sendKeys(zip);

        //Submit
        driver.findElement(By.id("createAccount")).click();
        //verification
        String expected = driver.findElement(By.xpath("//strong[text()= 'SIGN IN TO CONTINUE']")).getText();
                //(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[text()= 'SIGN IN TO CONTINUE']"))).getText());
        String actual = "";
        assertEquals(actual, expected);




    }
}

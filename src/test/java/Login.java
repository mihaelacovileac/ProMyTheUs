import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class Login {
    private WebDriver driver;
    private String url;

    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        url = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @AfterClass
    public void AfterClass(){
        driver.quit();
    }

    @Test
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
   @Test
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
    @Test
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
    @Test
    public  void  TestLoginNegative3(){
        //empty password field and correct email
        driver.get(url);
        driver.findElement(By.name("email")).sendKeys("buquxahu@cars2.club");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("login")));

        String emptyPassword = driver.findElement(By.xpath("//form/div[2]/span[2]")).getText();
        assertEquals("This value is required.", emptyPassword);
    }
    @Test
    public  void  TestLoginNegative4(){
        //empty email field and correct password
        driver.get(url);
        driver.findElement(By.name("password")).sendKeys("kisulea");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("login")));

        String emptyEmail = driver.findElement(By.xpath("(//span[text() = 'This value is required.'])[1]")).getText();
        assertEquals("This value is required.", emptyEmail);
    }
}

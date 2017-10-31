package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {
     protected WebDriver driver;
     private String url;
     protected WebDriverWait wait;
     protected LoginPage login;



    @BeforeClass
    public void baseBeforeClass() {
        driver = new ChromeDriver();
        url = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        driver.get(url);
        login = new LoginPage(driver);
    }
    @AfterClass
    public void baseAfterClass(){ //driver.close();
    }

    @Test(enabled = false)
    public void assertLogo(){
        assertTrue(login.getLogo().isDisplayed());
    }
    }

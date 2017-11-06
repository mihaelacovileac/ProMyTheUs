package Tests;

import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
     protected WebDriver driver;
     private String url;
     protected WebDriverWait wait;
     protected LoginPage login;


@Parameters({"browser", "url"})
    @BeforeClass
    public void baseBeforeClass(String browser, String url)throws MalformedURLException {
//        driver = new ChromeDriver();
//        url = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, 5);
//        driver.get(url);
//        login = new LoginPage(driver);
    //run FireFox
    if(browser.equalsIgnoreCase("firefox")){
        driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //run Chrome
    }else if (browser.equalsIgnoreCase("chrome")){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //run Appium
    }else  if (browser.equalsIgnoreCase("appium")){
        //Create object of DesiredCapabilities class and specify android platform
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");

        capabilities.setCapability(MobileCapabilityType.VERSION,"7.1.1");

        URL urlHub = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(urlHub, capabilities);

        driver.get(url);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }else if ((browser.equalsIgnoreCase("saucelab"))){
        String USERNAME = "mihaela04";
        String ACCESS_KEY = "4263ab2a-bbcb-4348-a149-c95e9ecbcff1";
        String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "47.0");
        driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    }
    @AfterClass
    public void baseAfterClass(){// driver.close();
    //driver.quit();
    }

    @Test(enabled = false)
    public void assertLogo(){
        assertTrue(login.getLogo().isDisplayed());
    }
    }

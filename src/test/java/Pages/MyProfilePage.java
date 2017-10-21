package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyProfilePage extends BasePage{
    public MyProfilePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//p[contains(.,'My Profile')]")
    private WebElement myProfileLink;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    public void clickMyProfileLink(){
        wait.until(ExpectedConditions.elementToBeClickable(myProfileLink));
        executor.executeScript("arguments[0].click();",myProfileLink);
    }
    //Have to check value"Milla"
    public String getFirstNameAttribute(){
        return firstName.getAttribute("value");
    }

}

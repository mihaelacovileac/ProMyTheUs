package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyProfilePage extends BasePage{
    public MyProfilePage(WebDriver driver){
        super(driver);
    }
    //My Profile Link
    @FindBy(xpath = "//p[contains(.,'My Profile')]")
    private WebElement myProfileLink;

    //Personal Settings
    @FindBy(xpath = "//a[@ng-click='MyProfileCtrl.openTabByIndex(1)']")
    private WebElement profileLink;
    @FindBy(xpath = "//a[@ng-click='MyProfileCtrl.openTabByIndex(2)']")
    private WebElement passwordChange;


    //Profile form input fields
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='middleName']")
    private  WebElement middleName;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='phone']")
    private  WebElement phone;
    @FindBy(xpath= "//div[@name='country']")
    private  WebElement country;
    @FindBy(xpath = "//input[@id='address']")
    private WebElement address;
    @FindBy(xpath = "//input[@name='address2']")
    private  WebElement address2;
    @FindBy(xpath = "//input[@id='city']")
    private  WebElement city;
    @FindBy(xpath = "//input[@id='state']")
    private WebElement state;
    @FindBy(xpath = "//input[@id='zip']")
    private WebElement zip;

    //update button
    @FindBy(xpath = "//button[@id='updateProfile']")
    private WebElement updateBtn;

    //Password Change form
    @FindBy(xpath ="//input[@id='currentPassword']")
    private WebElement currentPassword;
    @FindBy(xpath = "//input[@id='newPassword']")
    private  WebElement newPassword;
    @FindBy(xpath = "//input[@id='confirmNewPassword']")
    private WebElement confirmNewPassword;
    @FindBy(xpath = "//button[@class = 'btn btn-primary']")
    private  WebElement updatePasswordBtn;


    //Methods for setPassword


    public void setCurrentPassword(String strCurrentPassword) {
        currentPassword.clear();
        currentPassword.sendKeys(strCurrentPassword);
    }
    public void setNewPassword(String strNewPassword){
        newPassword.clear();
        newPassword.sendKeys(strNewPassword);
    }
    public void setConfirmNewPassword(String strConfirmNewPassword){
        confirmNewPassword.clear();
        confirmNewPassword.sendKeys(strConfirmNewPassword);
    }
    public void clickUpdatePassword(){
        wait.until(ExpectedConditions.elementToBeClickable(updatePasswordBtn));
        executor.executeScript("arguments[0].click();",updatePasswordBtn);
    }
    public void ChangePassword(String strCurrentPassword, String strNewPassword,String strConfirmNewPassword){
        this.setCurrentPassword(strCurrentPassword);
        this.setNewPassword(strNewPassword);
        this.setConfirmNewPassword(strConfirmNewPassword);
        this.updatePasswordBtn.click();
    }
    //need to add methods for second form

    public void clickMyProfileLink(){
        wait.until(ExpectedConditions.elementToBeClickable(myProfileLink));
        executor.executeScript("arguments[0].click();",myProfileLink);
    }
    //Have to check value"Milla", no value present on html page
    public String getFirstNameAttribute(){
        return firstName.getAttribute("value");
    }

}

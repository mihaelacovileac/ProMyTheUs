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

    @FindBy(css = "button.confirm")
    private WebElement okBtn;

    //Password Change form
    @FindBy(xpath ="//input[@id='currentPassword']")
    private WebElement currentPassword;
    @FindBy(xpath = "//input[@id='newPassword']")
    private  WebElement newPassword;
    @FindBy(xpath = "//input[@id='confirmNewPassword']")
    private WebElement confirmNewPassword;
    @FindBy(xpath = "//*[@id='formPassword']/button")
    private  WebElement updatePasswordBtn;
   // @FindBy(css = "div.sweet-alert showSweetAlert.visible")
    @FindBy(xpath = "//p[contains(.,'Password changed successfully.')]")
    private WebElement passwordChangeSuccessfully;
    @FindBy(xpath = "//div[@class='sa-placeholder']")
    private WebElement popUpLogo;


    //error message locators for change password form
    @FindBy(xpath = "//span[contains(.,'This value is required.')]")
    private WebElement requiredValue;
    @FindBy(xpath = "//span[contains(.,'Current password is wrong.')]")
    private WebElement currentPasswordWrong;
    @FindBy(xpath = "//span[contains(.,'This value is too long. It should have 255 characters or fewer.')]")
    private WebElement valueIsToLong;
    @FindBy(xpath = "//span[contains(.,'The passwords do not match.')]")
    private WebElement passwordNotMatch;

    //Methods for error messages change password form
    public String getErrorTextRequiredField(){
        return requiredValue.getText();
    }
    public String getErrorCurrentPasswordWrong(){
        wait.until(ExpectedConditions.visibilityOf(currentPasswordWrong));
        return currentPasswordWrong.getText();
    }
    public String getErrorValueIsToLong(){
        return valueIsToLong.getText();
    }
    public String getErrorPasswordNotMatch(){
        return passwordNotMatch.getText();
    }


    public void clickOkBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(okBtn));
        okBtn.click();
    }



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
       // executor.executeScript("arguments[0].click();",updatePasswordBtn);
        updatePasswordBtn.click();

    }
    //get methods for change password form
    public String getCurrentPassword(){
        return currentPassword.getAttribute("value");
    }
    public String getNewPassword(){
        return newPassword.getAttribute("value");
    }
    public String getConfirmNewPassword(){
        return confirmNewPassword.getAttribute("value");
    }
    public String getPasswordChangeSuccessfully(){
        wait.until(ExpectedConditions.visibilityOf(passwordChangeSuccessfully));
        return passwordChangeSuccessfully.getText();}
    public WebElement getPopUpLogo() {
        return wait.until(ExpectedConditions.visibilityOf(popUpLogo));
    }

    public void ChangePassword(String strCurrentPassword, String strNewPassword,String strConfirmNewPassword){
        this.setCurrentPassword(strCurrentPassword);
        this.setNewPassword(strNewPassword);
        this.setConfirmNewPassword(strConfirmNewPassword);
        this.updatePasswordBtn.click();
    }
    public void clickProfileLink(){
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        executor.executeScript("arguments[0].click();",profileLink);
    }
    public void clickChangePasswordLink(){
        wait.until(ExpectedConditions.elementToBeClickable(passwordChange));
        executor.executeScript("arguments[0].click();",passwordChange);
    }
    //methods for update profile form
    public void setFirstName(String strfirstName){
        firstName.clear();
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(strfirstName);
    }
    public void setLastName(String strLastName){
        lastName.clear();
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(strLastName);
    }
    public void setMiddleName(String strMiddleName){
        middleName.clear();
        wait.until(ExpectedConditions.visibilityOf(middleName)).sendKeys(strMiddleName);
    }
    public void setEmail(String strEmail){
        email.clear();
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(strEmail);
    }
    public void setPhone(String intPhone){
        phone.clear();
        wait.until(ExpectedConditions.visibilityOf(phone)).sendKeys(intPhone);
    }
    public void setCountry(String strCountry){
        country.clear();
        wait.until(ExpectedConditions.visibilityOf(country)).sendKeys(strCountry);
    }
    public void setAddress(String strAddress){
        address.clear();
        wait.until(ExpectedConditions.visibilityOf(address)).sendKeys(strAddress);
    }
    public void setAddress2(String strAddress2){
        address2.clear();
        wait.until(ExpectedConditions.visibilityOf(address2)).sendKeys(strAddress2);
    }
    public void setCity(String strCity){
        city.clear();
        wait.until(ExpectedConditions.visibilityOf(city)).sendKeys(strCity);
    }
    public void setState(String strState){
        state.clear();
        wait.until(ExpectedConditions.visibilityOf(state)).sendKeys(strState);
    }
    public void setZip(String intZip){
        zip.clear();
        wait.until(ExpectedConditions.visibilityOf(zip)).sendKeys(intZip);
    }
    public void clickUpdateBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        executor.executeScript("arguments[0].click();",updateBtn);
    }
    public void MyProfile (String strfirstName, String strLastName, String strMiddleName, String strEmail,
                                  String intPhone,String strCountry, String strAddress, String strAddress2, String strCity,String strState, String intZip ){
        this.profileLink.click();
        this.setFirstName(strfirstName);
        this.setLastName(strLastName);
        this.setMiddleName(strMiddleName);
        this.setEmail(strEmail);
        this.setPhone(intPhone);
        this.setCountry(strCountry);
        this.setAddress(strAddress);
        this.setAddress2(strAddress2);
        this.setCity(strCity);
        this.setState(strState);
        this.setZip(intZip);
        this.updateBtn.click();
    }
    public void clickMyProfileLink(){
        wait.until(ExpectedConditions.elementToBeClickable(myProfileLink));
        executor.executeScript("arguments[0].click();",myProfileLink);
    }
    //Have to check inserted values, no value present on html page
    //used for assertion

    public String getFirstName(){
        return firstName.getAttribute("value");
    }
    public String getLastName(){
        return lastName.getAttribute("value");
    }
    public String getMiddleName(){
        return middleName.getAttribute("value");
    }
    public String getEmail(){
        return email.getAttribute("value");
    }
    public String getPhone(){
        return phone.getAttribute("value");
    }
    public String getCountry(){
        return country.getText();
    }
    public String getAddress(){
        return address.getAttribute("value");
    }
    public String getAddress2(){
        return address2.getAttribute("value");
    }
    public String getCity(){
        return city.getAttribute("value");
    }
    public String getState(){
        return state.getAttribute("value");
    }
    public String getZip(){
        return zip.getAttribute("value");
    }



}

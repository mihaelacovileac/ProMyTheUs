package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage  {

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Register Now']")
    private WebElement registerButton;

    @FindBy(id = "userType")
    private WebElement userType ;

    @FindBy(id = "signUpFirstName")
    private WebElement firstName;

    @FindBy(id = "signUpLastName")
    private WebElement lastName;

    @FindBy(id = "signUpMiddleName")
    private WebElement middleNameInitial;

    @FindBy(id = "signUpRegisterEmail")
    private WebElement registrationEmail;

    @FindBy(id = "signUpPhone")
    private WebElement phoneNumber;

    @FindBy(id = "signUpRegisterPassword")
    private WebElement password;

    @FindBy(id = "signUpRegisterRePassword")
    private WebElement retypePassword;

    @FindBy(id = "signUpAddress")
    private WebElement typeAddress;
    @FindBy(xpath = "//*[@id=\"registerForm\"]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/input")
    private  WebElement apartment;

    @FindBy(id = "signUpCity")
    private WebElement typeCity;

    @FindBy(id = "signUpState")
    private WebElement typeState;

    @FindBy(id = "signUpZip")
    private WebElement typeZipCode;

    @FindBy(id = "createAccount")
    private WebElement createAccount;

    @FindBy(xpath = ".//*[@id='signUpCountry']/span")
    private WebElement clickCountryField;

    @FindBy(xpath="//span[contains(.,'Albania')]")
    private WebElement chooseCountry;

    @FindBy(xpath = "//strong[text()= 'SIGN IN TO CONTINUE']")
    private WebElement verifyReg;

    public String getTextCountry(){
        return  chooseCountry.getText();
    }

    public void clickSelectedCountry(String country){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'"+ country +"')]")));
        driver.findElement(By.xpath("//span[contains(.,'" + country + "')]")).click();
    }


    public void clickCountryField(){
        wait.until(ExpectedConditions.elementToBeClickable(clickCountryField));
        executor.executeScript("arguments[0].click();",clickCountryField);
    }

    public void clickCreateAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(createAccount));
        executor.executeScript("arguments[0].click();",createAccount);
    }

    public void setTypeZipCode(String intZipCode){
        typeZipCode.clear();
        wait.until(ExpectedConditions.visibilityOf(typeZipCode)).sendKeys(intZipCode);
    }

    public void setState(String strState){
        typeState.clear();
        wait.until(ExpectedConditions.visibilityOf(typeState)).sendKeys(strState);
    }
    public void setCity(String strCity){
        typeCity.clear();
        wait.until(ExpectedConditions.visibilityOf(typeCity)).sendKeys(strCity);
    }
    public void setAddress(String strAddress){
        typeAddress.clear();
        wait.until(ExpectedConditions.visibilityOf(typeAddress)).sendKeys(strAddress);
    }
    public void setAddressApartment(String strApartment){
        apartment.clear();
        wait.until(ExpectedConditions.visibilityOf(apartment)).sendKeys(strApartment);
    }
    public void setRetypePassword(String strPassword){
        retypePassword.clear();
        wait.until(ExpectedConditions.visibilityOf(retypePassword)).sendKeys(strPassword);
    }
    public void setPassword(String strPassword){
        password.clear();
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(strPassword);
    }
    public void setPhoneNumber(String intPhoneNumber){
        phoneNumber.clear();
        wait.until(ExpectedConditions.visibilityOf(phoneNumber)).sendKeys(intPhoneNumber);
    }
    public void setRegistrationEmail(String strRegistrationEmail){
        registrationEmail.clear();
        wait.until(ExpectedConditions.visibilityOf(registrationEmail)).sendKeys(strRegistrationEmail);
    }
    public void setMiddleNameInitial(String strMiddleNameInitial){
        middleNameInitial.clear();
        wait.until(ExpectedConditions.visibilityOf(middleNameInitial)).sendKeys(strMiddleNameInitial);
    }
    public void setLastName(String strLastName){
        lastName.clear();
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(strLastName);
    }
    public void setFirstName(String strFirstName){
        firstName.clear();
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(strFirstName);
    }
    public void userTypeCheckBox() {
        executor.executeScript("arguments[0].click();", userType);
    }
    public void clickRegisterBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        executor.executeScript("arguments[0].click();",registerButton);
    }


    public void RegistrationPage (String strFirstName, String strLastName, String strMiddleNameInitial, String strRegistrationEmail,
                                  String intPhoneNumber, String strPassword, String strAddress, String strCity,String strState, String intZipCode ){
        this.registerButton.click();
        this.userType.click();
        this.setFirstName(strFirstName);
        this.setLastName(strLastName);
        this.setMiddleNameInitial(strMiddleNameInitial);
        this.setRegistrationEmail(strRegistrationEmail);
        this.setPhoneNumber(intPhoneNumber);
        this.setPassword(strPassword);
        this.setRetypePassword(strPassword);
        this.clickCountryField.click();
        this.chooseCountry.click();
        this.setAddress(strAddress);
        this.setCity(strCity);
        this.setState(strState);
        this.setTypeZipCode(intZipCode);
        this.createAccount.click();
    }
    public String getVerificationRegistration(){
        return verifyReg.getText();
    }

}

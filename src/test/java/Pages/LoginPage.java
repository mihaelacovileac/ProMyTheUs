package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy(how = How.CSS, using = ".logo")
    private WebElement logo;

    @FindBy(name="email")
    private WebElement userLogin;

    @FindBy(name = "password")
    private WebElement passwordLogin;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(xpath="(//span[text() = 'This value is required.'])[1]")
    private WebElement emailRequiredField;

    @FindBy(xpath = "//form/div[2]/span[2]")
    private WebElement passwordRequiredField;

    @FindBy(xpath = "//div[text() = 'Invalid Email or Password.']")
    private WebElement invalidCredentials;

    @FindBy(xpath = "//em[@class='icon-user']")
    private WebElement userIcon;


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void setUserLogin(String strUserLogin){
        userLogin.clear();
        wait.until(ExpectedConditions.visibilityOf(userLogin)).sendKeys(strUserLogin);
    }

    public void setPasswordLogin(String strPasswordLogin){
        passwordLogin.clear();
        wait.until(ExpectedConditions.visibilityOf(passwordLogin)).sendKeys(strPasswordLogin);
    }

    public void clickLoginButton(){

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        executor.executeScript("arguments[0].click();",loginButton);
    }
    public void LoginPage(String strUserLogin, String strPasswordLogin){
        this.setUserLogin(strUserLogin);
        this.setPasswordLogin(strPasswordLogin);
        this.loginButton.click();


    }

    public WebElement getLogo() {
        return wait.until(ExpectedConditions.visibilityOf(logo));
    }

    public String getEmailRequiredField(){
        return emailRequiredField.getText();
    }

    public String getPasswordRequiredField(){
        return passwordRequiredField.getText();
    }

    public String getWrongCredentialsMessage(){
        return invalidCredentials.getText();
    }

    public String getUserIconAttribut(){
        return userIcon.getAttribute("class");
    }

}

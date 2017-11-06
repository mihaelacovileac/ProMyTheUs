package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TalentsDashboardPage extends BasePage {
    public TalentsDashboardPage(WebDriver driver){
        super(driver);
    }
    //Assert That you are on the talents page
    @FindBy(xpath = "//h3[contains(.,'Talents')]")
    private WebElement pageTitle;

    //Search Box and search button
    public void setSearchBox(String strSearchBox){
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(strSearchBox);
    }
    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBox;

    public void clickSearchBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }
    @FindBy(xpath = "//button[@class='btn btn-sm btn-default']")
    private  WebElement searchBtn;
    //Pencil button(for update talents)
    @FindBy(xpath = "//table/tbody/tr/td[9]/a")
    private WebElement pencil;
    public void clickPencilIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(pencil));
        pencil.click();
    }
    //Disable/Enable Status locators
    @FindBy(xpath = "//em[@class = 'icon-minus text-danger' and @title = 'INACTIVE']")
    private WebElement inactive;
    //This xpath is an array and need a loop or to check checkbox for a specific talent(check box is an array too)
    //instead of 1 can put i
    @FindBy(xpath = "(//em[@class = 'icon-check text-success' and @title = 'ACTIVE'])[1]")
    private WebElement active;

    //Talents name link .need array or change index i instead of 1
    @FindBy(xpath = "(//a[@class='ng-binding'])[1]")
    private WebElement nameLink;
    public void clickNameLink(){
        wait.until(ExpectedConditions.elementToBeClickable(nameLink));
        nameLink.click();
    }

    //Buttons
    @FindBy(xpath = "//a[@class='btn btn-default btn-outline mr']")
    private WebElement newBtn;
    @FindBy(xpath= "//div[@class = 'btn-group']/button[1]")
    private WebElement enableBtn;

    @FindBy(xpath = "//div[@class = 'btn-group']/button[2]")
    private WebElement disableBtn;

    @FindBy(xpath = "//div[@class = 'btn-group']/button[3]")
    private WebElement archiveBtn;

    //Number of talents on page select box(10.25.50.100)
    @FindBy(xpath = "//select[@ng-model='TalentsCtrl.rowsOnPageCount']")
    private WebElement nrTalentsOnPageSelect;

    @FindBy(xpath = "//table/tbody/tr/td[1]/div/label")
    private List<WebElement> checkBox;

    //For This Method i need to write a for loop
    public List<WebElement> getCheckBox() {
        wait.until(ExpectedConditions.visibilityOfAllElements(checkBox));
        return checkBox;
    }
    //For this method need to check if all checkboxes are checked
    public void clickDropBoxAllElements(String nrOfRows){
        wait.until(ExpectedConditions.visibilityOf(nrTalentsOnPageSelect));
        Select dropdown = new Select(nrTalentsOnPageSelect);
        dropdown.selectByVisibleText(nrOfRows);
    }

    //Method for asertion right title
    public String getPageTitle(){
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    //Click button NEW
    public void clickButtonNew(){
        wait.until(ExpectedConditions.visibilityOf(newBtn));
        newBtn.click();
    }
    //click button enable
    public void clickEnableBtn(){
        wait.until(ExpectedConditions.visibilityOf(enableBtn));
        enableBtn.click();
    }
    //click button disable
    public void clickDisableBtn(){
        wait.until(ExpectedConditions.visibilityOf(disableBtn));
        disableBtn.click();
    }
    //click button archive
    public void clickArchiveBtn(){
        wait.until(ExpectedConditions.visibilityOf(archiveBtn));
        archiveBtn.click();
    }


}

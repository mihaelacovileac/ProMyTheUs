package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;

public class NewTalentsPage extends BasePage {
    public NewTalentsPage(WebDriver driver){
        super(driver);
    }
    //Personal info Page locators

    @FindBy(id = "firstName")
    public WebElement firstNameField; // input field First name
    @FindBy(id = "middleName")
    public WebElement middleNameField; // input field Middle name
    @FindBy(id = "lastName")
    public WebElement lastNameField; // input field Last name
    @FindBy(id = "dateBirth")
    public WebElement dobField; // input field Date of birth
    @FindBy(id = "placeBirth")
    public WebElement placeOfBirthField; //input field Place of birth
    @FindBy(id = "country")
    public WebElement countryField; //input field Country
    @FindBy(id = "address")
    public WebElement addressField; //input field Address
    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityField;  //input city
    @FindBy(xpath = "//input[@name='addressState']")
    public WebElement addressStateField;//inputState
    @FindBy(xpath = "//input[@name='zip']")
    public WebElement zipField;//Input zip code
    @FindBy(xpath = "//input[@name='location']")
    public List<WebElement> chooseLocations; //radio buttons to choose Location
    @FindBy(xpath = "//input[@name='state']")
    public List<WebElement> chooseLocationStatusBtn; //radio buttons to choose Status of location
    @FindBy(id = "email")
    public WebElement emailField; //input field Email
    @FindBy(id = "phone")
    public WebElement phoneField; //input field Phone
    @FindBy(xpath = "//a[@class='social-account-more ng-binding']")
    public WebElement socialAccountLink; //link to add social account
    @FindBy(xpath = "//span[@class='ui-select-placeholder text-muted ng-binding']")
    public WebElement socialAccountDropdown; //dropdown to select social network
    @FindBy(id = "ui-select-choices-row-1-0")
    public WebElement facebookOption; //line with Facebook option
    @FindBy(xpath = "//div[@class='col-lg-9']/input")
    public WebElement facebookAccount; //input field Social account
    @FindBy(xpath = "//a[@class='social-account-more ng-binding']")
    public WebElement moreSocialAcountsLink;// more social accounts link
    @FindBy(id = "height")
    public WebElement heightField; //input field Height
    @FindBy(id = "weight")
    public WebElement weightField; //input field Weight

    //talent Traits page locators
    @FindBy(xpath = "//*[@id='traits']/tbody/tr/td[2]/input")
    private List<WebElement> scaleRow;
    @FindBy(xpath = "//*[@id='traits']/tbody/tr/td[2]/span[2]")
    private List<WebElement> errorRequiredField;

    //Personality traits page locators
    @FindBy(xpath = "//table/tbody/tr/td[2]/label/span")
    private List<WebElement> checkboxPersonalityTraits;

    //Story Page locators
    @FindBy(name = "headline")
    public WebElement headlineField; //input field Headline
    @FindBy(name = "discoveryYears")
    public WebElement discoveryYearsField; //input field for age, when talent was discovered
    @FindBy(xpath = "//select[@name='interestLevel']")
    private  WebElement clickInterestLevelField;
    @FindBy(name = "//option[@value='PASSIONATE']")
    public WebElement interestLevelOption; //dropdown to choose interest level passionate

    @FindBy(name = "trainingHistory")
    public WebElement trainingHistoryOption; //dropdown to choose years of training
    @FindBy(xpath = "(//input[@name='coached'])[2]")
    public WebElement coachedOption; //radiobuttons to choose if talent was coached
    @FindBy(xpath = "(//input[@name='training'])[1]")
    public WebElement trainingOption; //choose training option
    @FindBy(name = "schoolName")
    public WebElement schoolNameField; //input field for School or college name
    @FindBy(name = "schoolSuccessLevel")
    public WebElement schoolSuccessLevelField; //input field for academic success level
    @FindBy(name = "skill")
    public List<WebElement> skills; //radiobutton to choose skills level
    @FindBy(xpath = "(//span[@class='fa fa-check'])[2]")
    public WebElement testimoniesList; //checkbox to choose source of testimonies (family, friends, etc.)
    @FindBy(name = "testimony0")
    public WebElement testimonyField; //input field Testimony
    @FindBy(name = "workProduct")
    public WebElement workProductField; //input field Work product
    @FindBy(xpath = "(//span[@class='fa fa-circle'])[12]")
    public WebElement familyIncomeLevel; //radiobutton to choose income level
    @FindBy(xpath = "//input[@placeholder='USD']")
    public WebElement familyIncomeField; //input field for income amount


    @FindBy(id = "talentGutFeel")
    public WebElement talentGutFeelField; //input field for Gut feel
    @FindBy(id = "rationalGutFeel")
    public WebElement talentRationaleField; //input field for Rational reason for gut feel
    @FindBy(id = "independentScore")
    public WebElement scoreField; //input field Score
    @FindBy(id = "relativeRankAmongTalents")
    public WebElement rankField; //input field Rank
    @FindBy(name = "categoryTrait0")
    public WebElement tTrait1; //input field for talent trait
    @FindBy(name = "categoryTrait2")
    public WebElement tTrait2; //input field for talent trait
    @FindBy(name = "categoryTrait3")
    public WebElement tTrait3; //input field for talent trait
    @FindBy(xpath = "(//span[@class='fa fa-check'])[5]")
    public WebElement personalTrait1; //checkbox for personal trait
    @FindBy(xpath = "(//span[@class='fa fa-check'])[7]")
    public WebElement personalTrait2; //checkbox for personal trait
    @FindBy(xpath = "(//span[@class='fa fa-check'])[8]")
    public WebElement personalTrait3; //checkbox for personal trait

    //methods for insert scales into TalentTraits page(list)
    public List<WebElement> getNrOfRowsInputFields(){
        wait.until(ExpectedConditions.visibilityOfAllElements(scaleRow));
        return scaleRow;
    }
    public void insertScaleNumber1To10(String intScale){
        Iterator<WebElement> iterator = scaleRow.iterator();
        while (iterator.hasNext()){
            iterator.next().sendKeys(intScale);
        }
    }

    //methods for selecting checkBoxes on personality traits page
    public List<WebElement> getNumberOfCheckBxPersonalityTraits() {
        wait.until(ExpectedConditions.visibilityOfAllElements(checkboxPersonalityTraits));
        return checkboxPersonalityTraits;
    }
    public void clickCheckboxPersonalityTreats(){
        Iterator<WebElement> iterator =checkboxPersonalityTraits.iterator();
        while (iterator.hasNext()){
            iterator.next().click();
        }
    }
    //methods for story page
    public void setHeadlineField(String strHeadlineField) {
        wait.until(ExpectedConditions.visibilityOf(headlineField));
        headlineField.sendKeys(strHeadlineField);
    }
    public void setDiscoveryYearsField(String intDiscoveryYear){
        wait.until(ExpectedConditions.visibilityOf(discoveryYearsField));
        discoveryYearsField.sendKeys(intDiscoveryYear);
    }
    public void clickInterestLevelOption1(){
        wait.until(ExpectedConditions.visibilityOf(interestLevelOption));
        interestLevelOption.click();
    }
    public void clickInterestdropdown(){
        wait.until(ExpectedConditions.visibilityOf(clickInterestLevelField));
        clickInterestLevelField.click();
    }




}

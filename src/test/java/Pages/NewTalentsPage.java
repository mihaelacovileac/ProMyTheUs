package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class NewTalentsPage extends BasePage {
    public NewTalentsPage(WebDriver driver){
        super(driver);
    }
    //Personal info Page locators

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameField; // input field First name
    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleNameField; // input field Middle name
    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameField; // input field Last name
    @FindBy(xpath = "//input[@name='dateBirth']")
    public WebElement dobField; // input field Date of birth
    @FindBy(xpath = "//input[@name='placeBirth']")
    public WebElement placeOfBirthField; //input field Place of birth
    @FindBy(id = "country")
    public WebElement countryField; //input field Country
    @FindBy(xpath = "//input[@id='address']")
    public WebElement addressField; //input field Address
    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityField;  //input city
    @FindBy(xpath = "//input[@name='addressState']")
    public WebElement addressStateField;//inputState
    @FindBy(xpath = "//input[@name='zip']")
    public WebElement zipField;//Input zip code
    @FindBy(xpath = "//input[@name='location']")
    public List<WebElement> chooseLocations; //radio buttons to choose Location
    @FindBy(css = "div.form-group:nth-child(10) > div:nth-child(2) > label:nth-child(1) > span:nth-child(2)")
    private WebElement radioPrivileged;
    @FindBy(xpath = "//input[@value='PRIVILEGED']")
    private WebElement privilegedClass;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField; //input field Email
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneField; //input field Phone
    @FindBy(xpath = "//a[@class='social-account-more ng-binding']")
    public WebElement socialAccountLink; //link to add social account
    @FindBy(xpath = "//span[@class='ui-select-placeholder text-muted ng-binding']")
    private WebElement selectSocialAccount;
    @FindBy(xpath = "//div[@class='col-lg-9']/input")
    public WebElement facebookAccount; //input field Social account
    @FindBy(xpath = "//a[@class='social-account-more ng-binding']")
    public WebElement moreSocialAcountsLink;// more social accounts link
    @FindBy(xpath = "//*[@id='talentForm']/wizard-form/div/div[1]/div[1]/fieldset[2]/div/div/div[12]/div/div[2]/div[3]/a")
    private WebElement removeLink;
    @FindBy(xpath = "//input[@name='height']")
    public WebElement heightField; //input field Height
    @FindBy(xpath = "//input[@name='weight']")
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

//    @FindBy(name = "trainingHistory")
//    public WebElement trainingHistoryOption; //dropdown to choose years of training
//    @FindBy(xpath = "(//input[@name='coached'])[2]")
//    public WebElement coachedOption; //radiobuttons to choose if talent was coached
//    @FindBy(xpath = "(//input[@name='training'])[1]")
//    public WebElement trainingOption; //choose training option
//    @FindBy(name = "schoolName")
//    public WebElement schoolNameField; //input field for School or college name
//    @FindBy(name = "schoolSuccessLevel")
//    public WebElement schoolSuccessLevelField; //input field for academic success level
//    @FindBy(name = "skill")
//    public List<WebElement> skills; //radiobutton to choose skills level
//    @FindBy(xpath = "(//span[@class='fa fa-check'])[2]")
//    public WebElement testimoniesList; //checkbox to choose source of testimonies (family, friends, etc.)
//    @FindBy(name = "testimony0")
//    public WebElement testimonyField; //input field Testimony
//    @FindBy(name = "workProduct")
//    public WebElement workProductField; //input field Work product
//    @FindBy(xpath = "(//span[@class='fa fa-circle'])[12]")
//    public WebElement familyIncomeLevel; //radiobutton to choose income level
//    @FindBy(xpath = "//input[@placeholder='USD']")
//    public WebElement familyIncomeField; //input field for income amount


//    @FindBy(id = "talentGutFeel")
//    public WebElement talentGutFeelField; //input field for Gut feel
//    @FindBy(id = "rationalGutFeel")
//    public WebElement talentRationaleField; //input field for Rational reason for gut feel
//    @FindBy(id = "independentScore")
//    public WebElement scoreField; //input field Score
//    @FindBy(id = "relativeRankAmongTalents")
//    public WebElement rankField; //input field Rank
//    @FindBy(name = "categoryTrait0")
//    public WebElement tTrait1; //input field for talent trait
//    @FindBy(name = "categoryTrait2")
//    public WebElement tTrait2; //input field for talent trait
//    @FindBy(name = "categoryTrait3")
//    public WebElement tTrait3; //input field for talent trait
//    @FindBy(xpath = "(//span[@class='fa fa-check'])[5]")
//    public WebElement personalTrait1; //checkbox for personal trait
//    @FindBy(xpath = "(//span[@class='fa fa-check'])[7]")
//    public WebElement personalTrait2; //checkbox for personal trait
//    @FindBy(xpath = "(//span[@class='fa fa-check'])[8]")
//    public WebElement personalTrait3; //checkbox for personal trait



    //Methods for personal page
    public void setFirstNameField(String setFirst){
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(setFirst);
    }
    public void setMiddleName(String middleName) {
        wait.until(ExpectedConditions.visibilityOf(middleNameField));
        middleNameField.sendKeys(middleName);
    }
    public void setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.sendKeys(lastName);
    }
    public void setDOB(String dob) {
        wait.until(ExpectedConditions.visibilityOf(dobField));
        dobField.sendKeys(dob);
    }
    public void setPlaceOfBirth(String placeOfBirth) {
        wait.until(ExpectedConditions.visibilityOf(placeOfBirthField));
        placeOfBirthField.sendKeys(placeOfBirth);
    }
    public void setAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(addressField));
        addressField.sendKeys(address);
    }
    public void setcityField(String strCity){
        wait.until(ExpectedConditions.visibilityOf(cityField));
        cityField.sendKeys(strCity);
    }
    public void setStateField(String strStateField){
        wait.until(ExpectedConditions.visibilityOf(addressStateField));
        addressStateField.sendKeys(strStateField);
    }
    public  void setzipField(String intZipField){
        wait.until(ExpectedConditions.visibilityOf(zipField));
        zipField.sendKeys(intZipField);
    }
    public void chooseLocation() {
        List<WebElement> locations = chooseLocations;
        Random random = new Random();
        int indexL = random.nextInt(locations.size());
        locations.get(indexL).click();
    }
    public String selectPrivileged(){
    wait.until(ExpectedConditions.elementToBeClickable(radioPrivileged));
    executor.executeScript("arguments[0].click()", radioPrivileged);
    return privilegedClass.getAttribute("class");
    }
    public void setTalentEmail(String newEmail) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(newEmail);
    }
    public void setPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.sendKeys(phone);
    }
    public void addSocialAccount() {
        wait.until(ExpectedConditions.visibilityOf(socialAccountLink));
        socialAccountLink.click();
    }
    public void selectSocial(String social){
//        executor.executeScript("arguments[0].click()", selectSocialAccount);
    selectSocialAccount.click();
    wait.until(ExpectedConditions.presenceOfElementLocated(

            By.xpath("//span[contains(.,'" + social + "')]"))).click();
}
    public void setFacebookAccount(String socialAccount) {
        wait.until(ExpectedConditions.visibilityOf(facebookAccount));
        facebookAccount.sendKeys(socialAccount);
    }
    public  void clickmoreSocialAcountsLink(){
        wait.until(ExpectedConditions.visibilityOf(moreSocialAcountsLink));
        moreSocialAcountsLink.click();
    }
    public  void clickRemoveLink(){
        wait.until(ExpectedConditions.visibilityOf(removeLink));
        removeLink.click();
    }
    public void setHeight(String intheight) {
        wait.until(ExpectedConditions.visibilityOf(heightField));
        heightField.sendKeys(intheight);
    }
    public void setWeight(String intweight) {
        wait.until(ExpectedConditions.visibilityOf(weightField));
        weightField.sendKeys(intweight);
    }

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

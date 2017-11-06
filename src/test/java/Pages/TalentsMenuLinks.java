package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TalentsMenuLinks extends BasePage {
    public TalentsMenuLinks(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//span[contains(.,'Category')]")
    private WebElement categorylink;// menu
    @FindBy(xpath = "//div/ol/li[2]/span")
    private WebElement personalLink;
    @FindBy(xpath = "//div/ol/li[3]/span")
    private WebElement talentTraitsLink;
    @FindBy(xpath = "//div/ol/li[4]/span")
    private WebElement personalityTraitsLink;
    @FindBy(xpath = "//div/ol/li[5]/span")
    private WebElement storyLink;
    @FindBy(xpath = "//div/ol/li[6]/span")
    private WebElement evidenceLink;
    @FindBy(xpath = "//div/ol/li[7]/span")
    private WebElement trainingLink;
    @FindBy(xpath = "//div/ol/li[8]/span")
    private WebElement ratingLink;
    @FindBy(xpath = "//div/ol/li[9]/span")
    private WebElement socialBackgroundLink;
    @FindBy(xpath = "//div/ol/li[10]/span")
    private WebElement quickTestsLink;

    public void clickCategoryLink() {
        wait.until(ExpectedConditions.visibilityOf(categorylink));
        categorylink.click();
    }
    public void clickPersonalLink() {
        wait.until(ExpectedConditions.elementToBeClickable(personalLink));
        personalLink.click();
    }
    public void clickTalentTraitsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(talentTraitsLink));
        talentTraitsLink.click();
    }
    public void clickPersonalityTraitsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(personalityTraitsLink));
        personalityTraitsLink.click();
    }
    public void clickStoryLink() {
        wait.until(ExpectedConditions.elementToBeClickable(storyLink));
        storyLink.click();
    }
    public void clickEvidenceLink() {
        wait.until(ExpectedConditions.elementToBeClickable(evidenceLink));
        evidenceLink.click();
    }
    public void clickTrainingLink() {
        wait.until(ExpectedConditions.elementToBeClickable(trainingLink));
        trainingLink.click();
    }
    public void clickRatingLink() {
        wait.until(ExpectedConditions.elementToBeClickable(ratingLink));
        ratingLink.click();
    }
    public void clickSocialBackgroundLink() {
        wait.until(ExpectedConditions.elementToBeClickable(socialBackgroundLink));
        socialBackgroundLink.click();
    }
    public void clickQuickTestLink() {
        wait.until(ExpectedConditions.elementToBeClickable(quickTestsLink));
        quickTestsLink.click();

    }
}

package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[@class='btn btn-default form-control ui-select-toggle']")
    private WebElement clickEnterCategory ;//arrow to open dropdown category list
    @FindBy(xpath = "(//span[@class='ui-select-choices-row-inner'])[13]")
    private WebElement selectCategory ;//architecture

    @FindBy(xpath = "//button[contains(.,'Next')]")
    private WebElement clickNextBtn;
    @FindBy(xpath = "//button[contains(.,'Previous')]")
    private WebElement clickPreviousBtn;


//    public void clickSelectedCategory(String category){
//        wait.until(ExpectedConditions.visibilityOf(selectCategory));
//        Select dropdown = new Select(selectCategory);
//        dropdown.selectByVisibleText(category);
//
//    }
    public void clickSelectedCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(selectCategory));
        selectCategory.click();
    }

    public void clickEnterCategory() {
        wait.until(ExpectedConditions.visibilityOf(clickEnterCategory));
        executor.executeScript("arguments[0].click();",clickEnterCategory);

    }

    public void clickNextBtn() {
        wait.until(ExpectedConditions.visibilityOf(clickNextBtn));
        clickNextBtn.click();
    }

    public void clickPreviousBtn() {
        wait.until(ExpectedConditions.visibilityOf(clickPreviousBtn));
        clickPreviousBtn.click();
    }


}

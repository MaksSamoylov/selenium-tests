package udemy.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='udlite-heading-xxl']")
    private WebElement textOfValidSearching;
    @FindBy(xpath = "//h1[@class='udlite-heading-xl']")
    private WebElement textOfInvalidSearching;
    @FindBy(xpath = "//div[@class='course-list--container--3zXPS']/child::div[2]//div[contains(@class, 'udlite-focus-visible-target')]")
    private WebElement textOfFirstItem;
    @FindBy(xpath = "//fieldset[@name='Тема']//label")
    private List<WebElement> listOfTopicCheckboxes;
    @FindBy(xpath = "//fieldset[@name='Уровень']//label")
    private List<WebElement> listOfLevelsCheckboxes;
    @FindBy(xpath = "(//button[contains(@class, 'udlite-btn udlite-btn-medium')])[2]")
    private WebElement topicExpandButton;


    public SearchPage clickOnTopicCheckbox(int indexOfCheckbox) {
        wait = new WebDriverWait(driver, 4);
        topicExpandButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(listOfTopicCheckboxes.get(indexOfCheckbox)));
        listOfTopicCheckboxes.get(indexOfCheckbox).click();
        return this;
    }

    public SearchPage clickOnLevelsCheckboxes(int indexOfCheckbox) {
        wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.elementToBeClickable(listOfLevelsCheckboxes.get(indexOfCheckbox)));
        listOfLevelsCheckboxes.get(indexOfCheckbox).click();
        return this;
    }

    public String getTextOfSearchPage() {
        return textOfValidSearching.getText();
    }

    public String getTextOfInvalidSearching() {
        return textOfInvalidSearching.getText();
    }

    public String getTextOfFirstItem() {
        return textOfFirstItem.getText();
    }
}

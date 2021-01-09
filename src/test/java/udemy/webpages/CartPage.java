package udemy.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private Actions actions;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    //h3[@class='styles--sc-shopping-list__title--3giMp']
    @FindBy(xpath = "//h3[contains(text(), 'в корзине')]")
    private WebElement cartListTitle;
    @FindBy(xpath = "(//div[@class='styles--sc-shopping-list--2_s4L'])[2]/div")
    private List<WebElement> listOfSavedForLater;
    @FindBy(xpath = "//a[contains(text(),'Сохранить на потом')]")
    private WebElement saveForLaterButton;

    public int sizeOfListSaveForLater() {
        return listOfSavedForLater.size();
    }

    public CartPage clickOnSaveForLaterButton() {
        saveForLaterButton.click();
        return this;
    }
}

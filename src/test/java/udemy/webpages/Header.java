package udemy.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    private WebDriver driver;
    private Actions actions;

    public Header(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='udlite-btn udlite-btn-medium udlite-btn-secondary udlite-heading-sm']")
    private WebElement logInButton;
    @FindBy(xpath = "//a[@class='udlite-btn udlite-btn-medium udlite-btn-primary udlite-heading-sm']")
    private WebElement signUpButton;
    @FindBy(xpath = "//input[contains(@class, 'udlite-text-input udlite-text-input-small')]")
    private WebElement searchField;
    @FindBy(xpath = "//a[@class='udlite-btn udlite-btn-large udlite-btn-ghost udlite-heading-md udlite-btn-icon udlite-btn-icon-large js-header-button header--dropdown-button--1BviY']")
    private WebElement cartButton;
    @FindBy(xpath = "//div[@class='udlite-text-md panel-menu--gap-bottom--2CAzZ panel-menu--no-items--1w4aG']")
    private WebElement emptyCartMessage;
    @FindBy(xpath = "//div[text()='Your cart is empty.']")
    private WebElement emptyCartLinkKeepShopping;
    @FindBy(xpath = "//a[contains(@class,'udlite-btn udlite-btn-large udlite-btn-ghost udlite-heading-md js-header-button')]")
    private WebElement teachOnUdemy;
    @FindBy(xpath = "//button[@class='udlite-btn udlite-btn-large udlite-btn-ghost udlite-heading-md js-header-button header--dropdown-button--1BviY']")
    private WebElement Categories;
    @FindBy(xpath = "//div[@class='udlite-text-sm header--header--3sK1h header--flex-middle--2Xqjv']//img[@alt='Udemy']")
    private WebElement udemyLogo;

    public Header clickLogIn() {
        logInButton.click();
        return this;
    }

    public Header clickSignUp() {
        signUpButton.click();
        return this;
    }

    public CartPage clickCart() {
        cartButton.click();
        return new CartPage(driver);
    }

    public Header moveToCart() {
        actions.moveToElement(cartButton).build().perform();
        return this;
    }

    public String getEmptyCartMessage() {
        return emptyCartMessage.getText();
    }

    public TeachingPage clickTeachOnUdemy() {
        teachOnUdemy.click();
        return new TeachingPage();
    }

    public SearchPage typeToSearchField(String value) {
        searchField.sendKeys(value);
        searchField.submit();
        return new SearchPage(driver);
    }
}

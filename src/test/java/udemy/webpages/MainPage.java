package udemy.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,4);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'course-card--main')]")
    private List<WebElement> listOfCourses;
    @FindBy(xpath = "(//div[@class='carousel--scroll-item--3Wciz'])[9]")
    private WebElement firstCourseItem;
    @FindBy(xpath = "(//div[@class='carousel--scroll-item--3Wciz'])[10]")
    private WebElement secondCourseItem;
    @FindBy(xpath = "//button[@class='udlite-btn udlite-btn-large udlite-btn-brand udlite-heading-md add-to-cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//button[@class='udlite-btn udlite-btn-large udlite-btn-primary udlite-heading-md']")
    private WebElement getToCartButton;
    @FindBy(xpath = "//div[@class='udlite-modal modal--dialog--16df1 modal--default-size--cbk60']")
    private WebElement itemAddedToCartWindow;

    public CoursePage clickOnCourseItem(int itemIndex) {
        listOfCourses.get(itemIndex).click();
        return new CoursePage(driver);
    }

    public MainPage addToCartFirstItem() {
        actions.moveToElement(firstCourseItem).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//button[@class='udlite-btn udlite-btn-large udlite-btn-brand udlite-heading-md add-to-cart']")));
        addToCartButton.click();
        return this;
    }

    public CartPage getToCart() {
        getToCartButton.click();
        return new CartPage(driver);
    }

    public MainPage closeItemAddedToCartWindow() {
        itemAddedToCartWindow.sendKeys(Keys.ESCAPE);
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


}

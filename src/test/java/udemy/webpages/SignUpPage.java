package udemy.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private WebDriver driver;
    private Actions actions;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=' loginbox-v4__header loginbox-v4__header--signup']")
    private WebElement titleOfPage;
    @FindBy(xpath = "//input[@name='fullname']")
    private WebElement fullnameField;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//div[@class='checkbox']/label")
    private WebElement checkboxSubscribeToEmails;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//a[@class='sign-link']")
    private WebElement linkLogin;
    @FindBy(xpath = "//div[contains(@class, 'alert alert-danger')]/div/div")
    private WebElement errorCheckEmail;

    public String checkTextOfPageTitle() {
        return titleOfPage.getText();
    }

    public String checkTextOfEmailError() {
        return errorCheckEmail.getText();
    }

    public SignUpPage setCredential(String fullname, String email, String password, Boolean selected) {
        fullnameField.sendKeys(fullname);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        if (selected==true) {
            checkboxSubscribeToEmails.click();
        }
        submitButton.click();
        return this;
    }

    public SignUpPage clickOnCheckbox() {
        checkboxSubscribeToEmails.click();
        return this;
    }

}

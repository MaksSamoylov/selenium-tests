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

    @FindBy(xpath = "//div[@class = 'loginbox-v4__header']")
    private WebElement TitleOfPage;
    @FindBy(xpath = "//a[contains(@class, 'facebook-auth--social-btn--facebook--3SDC_')]")
    private WebElement facebookLogin;
    @FindBy(xpath = "//a[contains(@class, 'google-auth--social-btn--google--1H6_f')]")
    private WebElement gmailLogin;
    @FindBy(xpath = "//a[contains(@class, 'apple-auth--social-btn--apple--3Zv96')]")
    private WebElement appleLogin;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//a[@class='forgot-password-link']")
    private WebElement linkForgotPassword;
    @FindBy(xpath = "//a[@class='sign-link']")
    private WebElement linkSignUp;

}

package udemy.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import udemy.webpages.*;

import java.util.concurrent.TimeUnit;

public class LoginSignUpTests {
    private static WebDriver driver;
    private Header header;
    private SignUpPage signUpPage;
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maks\\projects\\udemy\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Before
    public void beforeTests() {
        driver.get("https://www.udemy.com/");
        header = new Header(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void searchValidCourse() {

        //Assert.assertTrue(.getTextOfSearchPage().contains(""));
        //Assert.assertTrue(.getTextOfFirstItem().toLowerCase().contains(""));
    }

    @Test
    public void SignUpWithDuplicateEmail() {
        header.clickSignUp();
        signUpPage.setCredential("UserUdemyCom", "maks14@gmail.com", "admin1192", false);
        Assert.assertTrue(signUpPage.checkTextOfEmailError().toLowerCase().contains("проверьте правильность написания электронного адреса"));
    }

    @Test
    public void SignUpWithEmptyPassword() {
        header.clickSignUp();
        signUpPage.setCredential("UserUdemyCom", "maks14@gmail.com", "", false);
        Assert.assertTrue(signUpPage.checkTextOfEmailError().toLowerCase().contains("пожалуйста введите пароль"));
    }

    @Test
    public void SignUpWithValidData() {
        header.clickSignUp();
        signUpPage.setCredential("UserUdemyCom", "maks13@gmail.com", "admin1192", true);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.udemy.com/?signupsuccess=1"));
    }

    @AfterClass
    public static void tearDown() {
       // driver.quit();
    }
}

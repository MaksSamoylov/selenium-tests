package udemy.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import udemy.webpages.CartPage;
import udemy.webpages.Header;
import udemy.webpages.MainPage;
import udemy.webpages.SearchPage;

import java.util.concurrent.TimeUnit;

public class CartTests {
    private static WebDriver driver;
    private static Header header;
    private static SearchPage searchPage;
    private static CartPage cartPage;
    private static MainPage mainPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maks\\projects\\udemy\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        header = new Header(driver);
        searchPage = new SearchPage(driver);
        cartPage = new CartPage(driver);
        mainPage = new MainPage(driver);
    }

    @Before
    public void beforeTests() {
        driver.get("https://www.udemy.com/");
    }

    @Test
    public void checkListOfItemsSavedForLater() {
        System.out.println(cartPage.sizeOfListSaveForLater());
    }

    @Test
    public void searchInvalidCourse() {
        mainPage.addToCartFirstItem();
        mainPage.getToCart();
        cartPage.clickOnSaveForLaterButton();
        System.out.println(cartPage.sizeOfListSaveForLater());
    }

    @Test
    public void searchfInvalidCourse() {
        mainPage.addToCartFirstItem();
    }


    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}

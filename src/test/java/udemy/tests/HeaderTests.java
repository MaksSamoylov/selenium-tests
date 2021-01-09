package udemy.tests;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import udemy.webpages.Header;
import udemy.webpages.MainPage;
import udemy.webpages.SearchPage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class HeaderTests {
    private static WebDriver driver;
    private Header header;
    private SearchPage searchPage;

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
        searchPage = new SearchPage(driver);
    }

    @Test
    public void searchValidCourse() {
        header.typeToSearchField("postman");
        searchPage.clickOnLevelsCheckboxes(0);
        Assert.assertTrue(searchPage.getTextOfSearchPage().contains("результатов по запросу «postman»"));
        Assert.assertTrue(searchPage.getTextOfFirstItem().toLowerCase().contains("postman"));
    }

    @Test
    public void searchInvalidCourse() {
        header.typeToSearchField("cxdfhsfhsdfh");
        Assert.assertTrue(searchPage.getTextOfInvalidSearching().contains("К сожалению, мы не смогли ничего найти по запросу"));
    }

    @AfterClass
    public static void tearDown() {
    //driver.quit();
    }
}

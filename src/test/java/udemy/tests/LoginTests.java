package udemy.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import udemy.webpages.Header;
import udemy.webpages.SearchPage;

import java.util.concurrent.TimeUnit;

public class LoginTests {
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

        Assert.assertTrue(searchPage.getTextOfSearchPage().contains(""));
        Assert.assertTrue(searchPage.getTextOfFirstItem().toLowerCase().contains(""));
    }

    @Test
    public void searchInvalidCourse() {

        Assert.assertTrue(searchPage.getTextOfInvalidSearching().contains(""));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

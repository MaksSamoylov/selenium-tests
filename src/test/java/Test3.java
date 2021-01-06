import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Test3 {
    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maks\\projects\\udemy\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.udemy.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void CheckMessageWithEmptyCart() {
        mainPage.moveToCart();
        mainPage.getEmptyCartMessage();
        assertTrue(mainPage.getEmptyCartMessage().equals("Корзина пуста."));
    }

    @Test
    public void TeachingPageOpenAfterClickingTeachOnUdemy() {
        mainPage.clickTeachOnUdemy();

    }

    @Test
    public void senValidValueForSearchField() {
        mainPage.typeToSearchField("Selenium");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}

import Models.HomePageElement;
import Models.LoginElement;
import Models.SearchElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestAutomation {
    public static WebDriver driver;
    public Actions actions;
    public String url;
    public HomePageElement hpe;
    public LoginElement login_element;
    public SearchElement search_element = new SearchElement();
    public static String email = "username";
    public static String password = "password";


    @Before
    public void setupTestDriver () {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://www.hepsiburada.com/";
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        hpe = new HomePageElement(driver);
    }

    @Test
    public void Run_Test() {
        //Siteye giriş yapılır.
        driver.get(url);
        System.out.println("Web sayfasına giriş başarılı.");
        /* Üye giriş sayfasına gidilir. */
        login_element = new LoginElement();
        actions = new Actions(driver);
        actions.moveToElement(login_element.login()).perform();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        String loginLink = login_element.loginLink().getAttribute("href");
        driver.get(loginLink);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        //Kullanıcı adı ile şifre giriş yapılır.
        login_element.userName().sendKeys(email);
        login_element.password().sendKeys(password);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        login_element.loginButton().click();
        System.out.println("Login Başarılı");

        //Arama kutucuğuna veri girilir.
        actions = new Actions(driver);
        actions.moveToElement(login_element.login()).perform();
        search_element.searchBox().sendKeys("Dji Mavic 2 Pro Fly More Combo");
        search_element.searchButton().click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        System.out.println("Arama kutucuğuna veri girişi başarılı.");

        //Ürün seçilir.
        search_element.chooseProduct().click();

    }

    @After
    public void exitDriver() {
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
        driver.quit();
    }
}

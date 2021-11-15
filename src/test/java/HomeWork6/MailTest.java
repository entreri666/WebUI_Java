package HomeWork6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://account.mail.ru");
    }

    @Test
    void LoginTest() {
        new LoginPageMail(driver)
                .fillLogin("test_gb00@mail.ru")
                .submitLogin()
                .fillPassword("3SfSyTIaeo4")
                .submitLogin();

        new MainPageMail(driver)
                .navigationFolder
                .newFolder();

        new CreateFolder(driver)
                .fillFolderName("test folder")
                .addNewFolder();


        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[@title = ('test folder, нет писем')]")));
        List<WebElement> navFolders = driver.findElements(By.xpath(
                "//*[@class='nav nav_expanded nav_hover-support']/a"));
        Assertions.assertTrue(navFolders.get(5).getText().contains("test folder"));


    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

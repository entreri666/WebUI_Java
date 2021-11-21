package HomeWork6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

@Story("HomeWork_7")
public class MailTest {

    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://account.mail.ru");
    }

    @Test
    @DisplayName("Создание новой папки")
    @Description("Проверка создания новой папки в почтовом ящике")
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
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);

        Iterator<LogEntry> iterator =browserLogs.iterator();
        while (iterator.hasNext()){
            Allure.addAttachment("Лог консоли", iterator.next().getMessage());
        }
        driver.quit();
    }
}

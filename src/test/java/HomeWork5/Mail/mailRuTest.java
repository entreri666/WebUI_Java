package HomeWork5.Mail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class mailRuTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
    }

    @Test
    void mailLogin() {
        driver.get("https://account.mail.ru");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='submit']")));
        driver.findElement(By.name("username")).sendKeys("test_gb00@mail.ru");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
        driver.findElement(By.name("password")).sendKeys("3SfSyTIaeo4");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//*[@class='nav nav_expanded nav_hover-support']/a")));

        List<WebElement> navFolders = driver.findElements(By.xpath(
                "//*[@class='nav nav_expanded nav_hover-support']/a"));
        Assertions.assertTrue(navFolders.get(0).getText().contains("Входящие"));
    }

    @Test
    void createFolder() {
        driver.get("https://account.mail.ru");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='submit']")));
        driver.findElement(By.name("username")).sendKeys("test_gb00@mail.ru");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
        driver.findElement(By.name("password")).sendKeys("3SfSyTIaeo4");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='button2__txt']")));
        driver.findElement(By.xpath("//*[@id='sideBarContent']/div/nav/div/div/span")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
        driver.findElement(By.name("name")).sendKeys("test folder");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='button2__txt']")));

        List<WebElement> navFolders = driver.findElements(By.xpath(
                "//*[@class='nav nav_expanded nav_hover-support']/a"));
        Assertions.assertTrue(navFolders.get(5).getText().equals("test folder"));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }


}

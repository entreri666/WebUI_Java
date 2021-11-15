package HomeWork5.CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;


public class crmTest {

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
        loginCrm(driver);
    }

    @Test
    void createProject() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class = 'unclickable']/span[.='Проекты']"))).build().perform();
        driver.findElement(By.xpath(" //span[.='Все проекты']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать проект']")));
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("test354312253");
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Укажите организацию']"))).build().perform();
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='12323142342134']")));
        driver.findElement(By.xpath("//div[text()='12323142342134']")).click();
        driver.findElement(By.name("crm_project[businessUnit]")).sendKeys("Research & Development");
        driver.findElement(By.name("crm_project[curator]")).sendKeys("Applanatest1 Applanatest1 Applanatest1");
        driver.findElement(By.name("crm_project[rp]")).sendKeys("Applanatest1 Applanatest1 Applanatest1");
        driver.findElement(By.name("crm_project[administrator]")).sendKeys("Applanatest1 Applanatest1 Applanatest1");
        driver.findElement(By.name("crm_project[manager]")).sendKeys("Амелин Владимир");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class = 'validation-failed']")));

        String success = driver.findElement(By.xpath("//span[@class = 'validation-failed']")).getText();
        Assertions.assertEquals("Это значение уже используется.", success);

    }

    @Test
    void createContact() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class = 'unclickable']/span[.='Контрагенты']")))
                .build().perform();
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Создать контактное лицо")));
        driver.findElement(By.linkText("Создать контактное лицо")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='crm_contact[lastName]']")));
        driver.findElement(By.xpath("//*[@name='crm_contact[lastName]']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[lastName]']")).sendKeys("34561");
        driver.findElement(By.xpath("//*[@name='crm_contact[firstName]']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[firstName]']")).sendKeys("4321");
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Укажите организацию']"))).build().perform();
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='12323142342134']")));
        driver.findElement(By.xpath("//div[text()='12323142342134']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[jobTitle]']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[jobTitle]']")).sendKeys("test");
        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Создать контактное лицо")));

        String success = driver.findElement(By.xpath("//div[. = 'Контактное лицо сохранено']")).getText();
        Assertions.assertEquals("Контактное лицо сохранено", success);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    static void loginCrm(WebDriver driver) {
        driver.get("https://crm.geekbrains.space");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }
}
package HomeWork3.CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class crmCreateProject {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space");
        loginCrm(driver);
        createProjectCrm(driver);
        Thread.sleep(5000);
        driver.quit();
    }

    static void loginCrm(WebDriver driver) {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
    static void createProjectCrm(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/a/span"))).build().perform();
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/ul/li[3]/a/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='container']/div[1]/div/div/div[2]/div/div/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("crm_project[name]")).sendKeys("test3543123");
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Укажите организацию']"))).build().perform();
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='12323142342134']")).click();
        driver.findElement(By.name("crm_project[businessUnit]")).sendKeys("Research & Development");
        driver.findElement(By.name("crm_project[curator]")).sendKeys("Applanatest1 Applanatest1 Applanatest1");
        driver.findElement(By.name("crm_project[rp]")).sendKeys("Applanatest1 Applanatest1 Applanatest1");
        driver.findElement(By.name("crm_project[administrator]")).sendKeys("Applanatest1 Applanatest1 Applanatest1");
        driver.findElement(By.name("crm_project[manager]")).sendKeys("Амелин Владимир");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();


    }
}

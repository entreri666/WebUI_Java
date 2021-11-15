package HomeWork3.CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class crmCreateContact {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space");
        loginCrm(driver);
        createContactCrm(driver);
        Thread.sleep(5000);
        driver.quit();
    }

    static void loginCrm(WebDriver driver) {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    static void createContactCrm(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span"))).build().perform();
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/ul/li[4]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Создать контактное лицо")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name='crm_contact[lastName]']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[lastName]']")).sendKeys("34561");
        driver.findElement(By.xpath("//*[@name='crm_contact[firstName]']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[firstName]']")).sendKeys("4321");
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Укажите организацию']"))).build().perform();
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='12323142342134']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[jobTitle]']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[jobTitle]']")).sendKeys("test");
        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();

    }
}

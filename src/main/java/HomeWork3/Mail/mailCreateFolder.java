package HomeWork3.Mail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mailCreateFolder {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://account.mail.ru");
        Thread.sleep(2000);
        mailLogin(driver);
        Thread.sleep(3000);
        mailCreateFolder(driver);
        Thread.sleep(5000);
        driver.quit();
    }

    static void mailLogin(WebDriver driver) throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("test_gb00@mail.ru");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("3SfSyTIaeo4");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    static void mailCreateFolder(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='sideBarContent']/div/nav/div/div/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='input-0-2-86']")).sendKeys("test folder");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }
}

package HomeWork3.Mail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mailLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://account.mail.ru");
        Thread.sleep(3000);
        mailLogin(driver);
        //createContactCrm(driver);
        Thread.sleep(5000);
        driver.quit();
    }

    static void mailLogin(WebDriver driver) throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("test_gb00@mail.ru");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("3SfSyTIaeo4");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }
}

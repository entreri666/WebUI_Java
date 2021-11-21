package HomeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class MailLogin {

    private SelenideElement inputLogin = $(By.name("username"));

    private SelenideElement inputPassword = $(By.name("password"));

    private SelenideElement buttonLogin = $(By.xpath("//*[@type='submit']"));

    @Step("Заполняем поле логин")
    public MailLogin fillLogin (String login){
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполняем поле пароль")
    public MailLogin fillPassword (String password){
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку войти")
    public MailLogin submitLogin (){
        buttonLogin.click();
        return this;
    }
}

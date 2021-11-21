package HomeWork8;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationFolder {

    private SelenideElement createFolder = $(By.xpath("//*[@id='sideBarContent']/div/nav/div/div/span"));

    public SelenideElement successMessage = $(By.xpath("//a[@title = ('test folder, нет писем')]"));

    @Step("Клик на кнопку \"Новая папка\"")
    public void newFolder() {
        createFolder.click();
    }
}

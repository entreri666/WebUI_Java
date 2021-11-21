package HomeWork8;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateNewFolder {

    private SelenideElement nameNewFolder = $(By.name("name"));

    private SelenideElement addFolder =$(By.xpath("//*[@type='submit']"));

    @Step("Вводим название новой папки")
    public void fillFolderName(String nameFolder) {
        nameNewFolder.sendKeys(nameFolder);
    }

    @Step("Клик на кнопку \"Добавить папку\"")
    public void addNewFolder() {
        addFolder.click();
    }
}

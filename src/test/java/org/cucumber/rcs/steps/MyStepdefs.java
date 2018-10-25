package org.cucumber.rcs.steps;

import Pages.MainPage;
import com.codeborne.selenide.Condition;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
//import cucumber.api.java.ru.Тогда;
//
//import static com.codeborne.selenide.Selectors.byName;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.Selenide.page;
//
//public class MyStepdefs {
//
//
//    @Когда("^открывается страница сайта$")
//    public void openPage() {
//        open("http://rotfront.org");
//    }
//
//    @Тогда("^пользователь нажимает на кнопку \"([^\"]*)\"$")
//    public void clickButton(String nameOfElement) {
//       mainPage.get(nameOfElement).waitUntil(Condition.visible, 1000).click();
//    }
//
//    @Тогда("^вводит текст \"([^\"]*)\" в поле \"([^\"]*)\"$")
//    public void fillField(String text, String input) {
//        $(byName(input)).sendKeys(text);
//    }
//
//    @И("^нажимает клавишу \"([^\"]*)\"$")
//    public void keyboardButton(String key) {
//        $(byName(key)).pressEnter();
//    }
//
//    MainPage mainPage = page(MainPage.class);
//}
//

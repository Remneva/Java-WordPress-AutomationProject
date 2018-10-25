package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver) {
       PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    private Select select;

    @NameOfElement("Слайдшоу ")
    @FindBy(xpath = "//*[@data-statlog='afisha.title.link']")
    public WebElement afisha;

    @NameOfElement("Раздел Статьи")
    @FindBy(xpath = "//div[@class='section c6 border-right']//h1//a")
    public WebElement section1;

    @NameOfElement("Раздел Новости")
    @FindBy(xpath = "//div[@class='section c6 ']/h1//a")
    public WebElement section2;

    @NameOfElement("Раздел Рабочее движение")
    @FindBy(xpath = "//div[@id='lower-section-1']//h1//a")
    public WebElement section3;

    @NameOfElement("Раздел Наши акции")
    @FindBy(xpath = "//div[@id='lower-section-2']//h1//a")
    public WebElement section4;

    @NameOfElement("Раздел Теория")
    @FindBy(xpath = "//div[@id='lower-section-3']//h1//a")
    public WebElement section5;

    @NameOfElement("Блок Наши союзники")
    @FindBy(xpath = "//*[@id='text-11']//h3")
    public WebElement widgetAllies;

    @NameOfElement("Список союзниов")
    @FindBy(xpath = "//*[@id='text-11']//a")
    public WebElement listAllies;

    public String sectionTitles () {
        String title = section1.getText();
        return title;
    }
    public String sectionNews () {
        String news = section2.getText();
        return news;
    }

    public String workersPower () {
        String workers = section3.getText();
        return workers;
    }

    public String ourActions () {
        String actions = section4.getText();
        return actions;
    }

    public String polithTheory () {
        String theory = section5.getText();
        return theory;
    }

    public String ourAllies () {
        String allies = widgetAllies.getText();
        return allies;
    }

}

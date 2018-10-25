package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    @NameOfElement("Горизонтальное Главное меню с выпадающими списками")
    @FindBy(xpath = "//div[@class='header_menu menu-bottom']")
    public SelenideElement headerMenu;

    @NameOfElement("Вертикальное меню")
    @FindBy(xpath = "//div[@class='menu-main-top-container']")
    public SelenideElement topMenu;

    @NameOfElement("Блок виджетов")
    @FindBy(xpath = "//div[@id='header-widgets']")
    public SelenideElement widgets;

    @NameOfElement("Виджет Вконтакте")
    @FindBy(xpath = "//div[@id='header-widgets']//a[@href='//vk.com/rot_front']")
    public SelenideElement VKwidget;

    @NameOfElement("Виджет Твиттер")
    @FindBy(xpath = "//div[@id='header-widgets']//a[@href='//twitter.com/RotFrontSu']")
    public SelenideElement Twitwidget;

    @NameOfElement("Виджет YouTube")
    @FindBy(xpath = "//div[@id='header-widgets']//a[@href='//www.youtube.com/c/RotFrontTV']")
    public SelenideElement YTwidget;

    @NameOfElement("Виджет feed")
    @FindBy(xpath = "//div[@id='header-widgets']//a[@href='//www.rotfront.su/feed/']")
    public SelenideElement Fdwidget;

    @NameOfElement("Виджет Telegramm")
    @FindBy(xpath = "//div[@id='header-widgets']//a[@href='//t.me/RotFront_su']")
    public SelenideElement Tlgwidget;




}

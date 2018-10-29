package org.cucumber.rcs.tests;

import Pages.MainPage;
import io.qameta.allure.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static java.util.Optional.*;

public class FirstTest {


    private static MainPage mainPage;
    private RemoteWebDriver driver;

    /// Предусловия для запуска на Selenoid

    @Before
    public void openDriver() throws Exception {
        final DesiredCapabilities browser = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL(
                "http://localhost:4444/wd/hub"
        ), browser);
        driver.get("http://rotfront.su");
        mainPage = new MainPage(driver);

    }

    /// Предусловия для запуска на Selenium

//    private static WebDriver driver;
//    @BeforeClass
//    public static void setup() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("http://rotfront.su");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        mainPage = new MainPage(driver);
//    }

    @Feature("Проверка блоков главной страницы")
    @Description(value = "Проверка блоков главной страницы")
    @Test
    public void mainPageTest() {

        String titleSect = mainPage.sectionTitles();
        Assert.assertEquals("Статьи", titleSect);
        System.out.println(titleSect);

        String newsSect = mainPage.sectionNews();
        Assert.assertEquals("Новости", newsSect);
        System.out.println(newsSect);

        String workers = mainPage.workersPower();
        Assert.assertEquals("Рабочее движение", workers);
        System.out.println(workers);

        String act = mainPage.ourActions();
        Assert.assertEquals("Наши акции", act);
        System.out.println(act);

        String theory = mainPage.polithTheory();
        Assert.assertEquals("Теория", theory);
        System.out.println(theory);

        String ally = mainPage.ourAllies();
        Assert.assertEquals("НАШИ СОЮЗНИКИ", ally);
        System.out.println(ally);
    }

    @Feature("Проверка разделов вертикального главного меню")
    @Description(value = "Проверка разделов вертикального главного меню")
    @Test
    public void getListText() {

        List<WebElement> innerBlockList = driver.findElements(By.xpath("//div[@class='menu-main-top-container']//ul//li"));
        for (WebElement we : innerBlockList
                ) {
            System.out.println(we.getText());
        }
        String[] expected = {"О нас", "Программа", "Устав", "История", "Руководство", "Заявления", "Помочь"};
        ArrayList<String> elementNames = new ArrayList<>();
        for (WebElement we : innerBlockList) {
            elementNames.add(we.getText());
        }
        System.out.println(elementNames.size());
        String[] actual = elementNames.toArray(new String[elementNames.size()]);
        Assert.assertArrayEquals(expected, actual);
    }

    @Feature("Проверка меню - разделы сайта")
    @Description(value = "Проверка меню - разделы сайта")
    @Test
    public void getListHref() {
        List<WebElement> innerBlockList = driver.findElements(By.xpath("//div[@class='menu-main-top-container']//ul//li/a"));
        for (WebElement we : innerBlockList
                ) {
        }
        ArrayList<String> elementNames = new ArrayList<>();
        for (WebElement we : innerBlockList) {
            elementNames.add(we.getAttribute("href"));
            System.out.println(we.getAttribute("href"));
        }
        String[] expected = {"http://www.rotfront.su/faq",
                "http://www.rotfront.su/program",
                "http://www.rotfront.su/ustav",
                "http://www.rotfront.su/%d0%b8%d1%81%d1%82%d0%be%d1%80%d0%b8%d1%8f-%d1%80%d0%be%d1%82-%d1%84%d1%80%d0%be%d0%bd%d1%82%d0%b0/",
                "http://www.rotfront.su/leaders",
                "http://www.rotfront.su/category/all-articles/political-declarations/",
                "http://www.rotfront.su/wanted"
        };
        String[] actual = elementNames.toArray(new String[elementNames.size()]);
        Assert.assertArrayEquals(expected, actual);
    }

    @Feature("Проверка блока Наши Союзники")
    @Description(value = "Проверка блока Наши Союзники")
    @Test
    public void getAllwidgetsAllies() {

        List<WebElement> innerBlockList = driver.findElements(By.xpath("//*[@id='text-11']//a"));
        for (WebElement we : innerBlockList) {
        }
        ArrayList<String> elementNames = new ArrayList<>();
        for (WebElement we : innerBlockList) {
            elementNames.add(we.getAttribute("href"));
            System.out.println(we.getAttribute("href"));
        }

        String[] expected = {"http://rkrp-rpk.ru/",
                "http://tr.rkrp-rpk.ru/",
                "http://krasnoe.tv/",
                "http://rksmb.org/",
                "http://www.len.ru/",
                "http://igpr.ru/",
                "http://comstol.info/",
                "http://com-piter.ru/",
                "http://www.great-country.ru/"
        };

        String[] actual = elementNames.toArray(new String[elementNames.size()]);
        Assert.assertEquals(elementNames.size(), 9);
        Assert.assertArrayEquals(expected, actual);
    }

//    @AfterClass
//    public static void tearChDown() {
//
//        driver.quit();
//    }

    @After
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

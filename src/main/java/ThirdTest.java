import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThirdTest {
    WebDriver driver;
    LogPage logPage;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logPage = PageFactory.initElements(driver, LogPage.class);
        driver.get("https://www.facebook.com");
    }

    @Test
    public void LoginNoData() {
        String error = "Эл. адрес или номер телефона, который вы указали, не соответствует ни одному аккаунту. Зарегистрируйте аккаунт.";
        String title = "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей.";
        Assert.assertEquals(driver.getTitle(), title);
        logPage.logAndPass("", "");
        Assert.assertEquals(logPage.error_message.getText(), error, "Error message is not as Expected");
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }
}

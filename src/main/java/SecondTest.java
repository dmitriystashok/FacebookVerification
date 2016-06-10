import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmytro_Stashok on 6/9/2016.
 */
public class SecondTest {

    WebDriver driver;

    @BeforeClass
    public void launch() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void secondTest() {
        String title = "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей.";
        driver.get("https://www.facebook.com");
        Assert.assertEquals(driver.getTitle(), title, "Title is not as expected");
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }
}

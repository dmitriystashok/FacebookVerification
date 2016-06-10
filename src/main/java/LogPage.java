import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogPage {
    final WebDriver driver;


    @FindBy(how = How.CLASS_NAME, using = "inputtext")
    WebElement txtBox_log;

    @FindBy(className = "inputtext")
    WebElement txtBox_pass;

    @FindBy(how = How.XPATH, using = "//*[@type='submit']")
    WebElement button_submit;

    @FindBy(className = "_1tp8")
    WebElement error_message;

    public LogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logAndPass(String log, String pass) {
        txtBox_log.sendKeys(log);
        txtBox_pass.sendKeys(pass);
        button_submit.click();
    }
}

package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.SelectBrowser;

public class MyFireFoxDriver implements SelectBrowser {
    @Override
    public WebDriver setUpBrowser() {
        return new FirefoxDriver();
    }
}

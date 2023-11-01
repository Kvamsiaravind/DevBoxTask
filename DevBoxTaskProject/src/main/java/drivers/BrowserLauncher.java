package drivers;

import exceptions.InvalidBrowserException;
import org.openqa.selenium.WebDriver;
import utilities.BrowserType;

import java.io.IOException;

public class BrowserLauncher {
    private BrowserLauncher() {
    }

    public static WebDriver getBrowserDriver() throws InvalidBrowserException, IOException {
        switch (BrowserType.FIREFOX) {
            case CHROME:
                return new MyChromeDriver().setUpBrowser();
            case EDGE:
                return new MyEdgeDriver().setUpBrowser();
            case FIREFOX:
                return new MyFireFoxDriver().setUpBrowser();
            default:
                throw new InvalidBrowserException("Please enter valid browser");
        }
    }

    public static void quit() throws IOException, InvalidBrowserException {
        getBrowserDriver().quit();
    }
}

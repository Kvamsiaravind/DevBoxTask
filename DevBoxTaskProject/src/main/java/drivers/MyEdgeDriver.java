package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.SelectBrowser;

public class MyEdgeDriver implements SelectBrowser {
    @Override
    public WebDriver setUpBrowser() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}

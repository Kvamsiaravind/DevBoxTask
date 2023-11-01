package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {
    private WebDriver driver;
    public ServicesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}

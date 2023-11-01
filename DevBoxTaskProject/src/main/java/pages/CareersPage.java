package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {
    private WebDriver driver;
    public CareersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}

package contactspagetesting.basetest;

import drivers.BrowserLauncher;
import exceptions.InvalidBrowserException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;


import java.io.IOException;

import static constants.Constants.BASE_URL;
import static drivers.BrowserLauncher.getBrowserDriver;

public class BaseConfigurationTest{
    protected WebDriver driver;
    protected HomePage homePage;
    protected AboutPage aboutPage;
    protected CareersPage careersPage;
    protected ClientsPage clientsPage;
    protected ContactsPage contactsPage;
    protected PortfolioPage portfolioPage;
    protected ServicesPage servicesPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException, InvalidBrowserException {
        driver = getBrowserDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        homePage = new HomePage(driver);
        aboutPage = new AboutPage(driver);
        careersPage = new CareersPage(driver);
        clientsPage = new ClientsPage(driver);
        contactsPage = new ContactsPage(driver);
        portfolioPage = new PortfolioPage(driver);
        servicesPage = new ServicesPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearClose() {
        driver.close();
    }

    @AfterSuite
    public void tearQuit() throws IOException, InvalidBrowserException {
        BrowserLauncher.quit();
    }
}

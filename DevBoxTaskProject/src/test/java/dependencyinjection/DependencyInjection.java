package dependencyinjection;


import org.openqa.selenium.WebDriver;
import pages.*;

public class DependencyInjection {

    protected WebDriver driver;
    private HomePage homePage;
    private AboutPage aboutPage;
    private CareersPage careersPage;
    private ClientsPage clientsPage;
    private ContactsPage contactsPage;
    private PortfolioPage portfolioPage;
    private ServicesPage servicesPage;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public AboutPage getAboutPage() {
        return aboutPage;
    }

    public void setAboutPage(AboutPage aboutPage) {
        this.aboutPage = aboutPage;
    }

    public CareersPage getCareersPage() {
        return careersPage;
    }

    public void setCareersPage(CareersPage careersPage) {
        this.careersPage = careersPage;
    }

    public ClientsPage getClientsPage() {
        return clientsPage;
    }

    public void setClientsPage(ClientsPage clientsPage) {
        this.clientsPage = clientsPage;
    }

    public ContactsPage getContactsPage() {
        return contactsPage;
    }

    public void setContactsPage(ContactsPage contactsPage) {
        this.contactsPage = contactsPage;
    }

    public PortfolioPage getPortfolioPage() {
        return portfolioPage;
    }

    public void setPortfolioPage(PortfolioPage portfolioPage) {
        this.portfolioPage = portfolioPage;
    }

    public ServicesPage getServicesPage() {
        return servicesPage;
    }

    public void setServicesPage(ServicesPage servicesPage) {
        this.servicesPage = servicesPage;
    }

    public void initializePageObjects() {
        homePage = new HomePage(driver);
        aboutPage = new AboutPage(driver);
        careersPage = new CareersPage(driver);
        clientsPage = new ClientsPage(driver);
        contactsPage = new ContactsPage(driver);
        portfolioPage = new PortfolioPage(driver);
        servicesPage = new ServicesPage(driver);

    }
}
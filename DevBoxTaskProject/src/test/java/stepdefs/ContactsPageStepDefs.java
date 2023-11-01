package stepdefs;

import dependencyinjection.DependencyInjection;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

import static constants.Constants.*;
import static utilities.Utility.getStatusCodeForUrl;


public class ContactsPageStepDefs extends DependencyInjection {

    private DependencyInjection dependencyInjection;
    public ContactsPageStepDefs(DependencyInjection dependencyInjection){
        this.dependencyInjection = dependencyInjection;
    }

    @Given(": Open the base URL {string}")
    public void openTheBaseURL(String url){
        dependencyInjection.getDriver().get(url);
    }

    @When(": Click on the Contacts page")
    public void clickOnTheContactsPage() {
        dependencyInjection.getContactsPage().clickOnContactSection();
    }


    @Then(": Validating the page title and status code {int}")
    public void validatingThePageTitleAndStatusCode(int expectedStatusCode) {
        int actualStatusCode = getStatusCodeForUrl(dependencyInjection.getDriver());
        Assert.assertEquals( actualStatusCode, expectedStatusCode,"Pass");
        String pageTitle = dependencyInjection.getContactsPage().getPageTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle, "GDC");
    }


    @When(": Click on the Home section")
    public void clickOnTheHomeSection() {
        dependencyInjection.getContactsPage().clickOnHomeSection();
    }

    @Then(": Validating the home page title and status code {int}")
    public void validatingTheHomePageTitleAndStatusCode(int statusCode) {
        int actualStatusCode = getStatusCodeForUrl(dependencyInjection.getDriver());
        Assert.assertNotEquals(actualStatusCode, statusCode);

        String homePageTitle =  dependencyInjection.getHomePage().getHomePageTitle();
        System.out.println(actualStatusCode+" "+homePageTitle);
    }

    @When(": Click on the About section")
    public void clickOnTheAboutSection() {
        dependencyInjection.getContactsPage().clickOnAboutSection();
    }

    @Then(": Validating the About page And title status code {int}")
    public void validatingTheAboutPageAndTitleStatusCode(int expectedStatusCode) {
        int actualStatusCode = getStatusCodeForUrl(dependencyInjection.getDriver());
        Assert.assertEquals(actualStatusCode, expectedStatusCode);

        String aboutPageTitle = dependencyInjection.getAboutPage().getAboutPageTitle();
        Assert.assertEquals(aboutPageTitle, ABOUT_PAGE_TITLE);
    }

    @When("fill the contact form with valid data")
    public void fillTheContactFormWithValidData(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);

        dependencyInjection.getContactsPage().enterNameIntoNameField(map.get("Name"));
        dependencyInjection.getContactsPage().enterEmailIntoEmailField(map.get("Email"));
        dependencyInjection.getContactsPage().enterMobileNumberIntoMobileNumberField(map.get("MobileNumber"));
        dependencyInjection.getContactsPage().enterYourSubjectIntoSubjectField(map.get("YourSubject"));
        dependencyInjection.getContactsPage().enterMessageIntoMessageField(map.get("Message"));
    }

    @And("Click on submit message button")
    public void clickOnSubmitMessageButton() {
        dependencyInjection.getContactsPage().clickOnSendMessageButton();
    }

    @Then("see a success message")
    public void seeASuccessMessage() {
        int statusCode = getStatusCodeForUrl(dependencyInjection.getDriver());
        Assert.assertEquals(statusCode, SUCCESS_STATUSCODE);
    }


    @When(": fill the contact form with invalid data")
    public void fillTheContactFormWithInvalidData(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);

        dependencyInjection.getContactsPage().enterNameIntoNameField(map.get("Name"));
        dependencyInjection.getContactsPage().enterEmailIntoEmailField(map.get("Email"));
        dependencyInjection.getContactsPage().enterMobileNumberIntoMobileNumberField(map.get("MobileNumber"));
        dependencyInjection.getContactsPage().enterYourSubjectIntoSubjectField(map.get("YourSubject"));
        dependencyInjection.getContactsPage().enterMessageIntoMessageField(map.get("Message"));
        dependencyInjection.getContactsPage().enterCaptchaIntoCaptchaField(map.get("Captcha"));
    }

    @Then("validating the please enter invalid data in different fields")
    public void validatingThePleaseEnterInvalidDataInDifferentFields() {
        String emailInvalid = dependencyInjection.getContactsPage().getEmailInvalidText();
        Assert.assertEquals(emailInvalid, INVALID_EMAIL);

        String nameInvalid = dependencyInjection.getContactsPage().getNameInvalidText();
        Assert.assertEquals(nameInvalid, INVALID_NAME);

        String mobileNumberInvalid =  dependencyInjection.getContactsPage().getMobileNumberInvalidText();
        Assert.assertEquals(mobileNumberInvalid, INVALID_MOBILE_NUMBER);

        String subjectTextInvalid = dependencyInjection.getContactsPage().getSubjectInvalidText();
        Assert.assertEquals(subjectTextInvalid, INVALID_SUBJECT);

        String captchaInvalidText = dependencyInjection.getContactsPage().getInvalidCaptchaText();
        Assert.assertEquals(captchaInvalidText, INVALID_CAPTCHA);
    }

    @When(": fill the email field by giving {string}")
    public void fillTheEmailFieldByGiving(String email) {
        dependencyInjection.getContactsPage().enterEmailIntoSubscribeEmailField(email);
    }

    @Then(": Validating the successfully subscribed message")
    public void validatingTheSuccessfullySubscribedMessage() {
        int statusCode = getStatusCodeForUrl(dependencyInjection.getDriver());
        Assert.assertNotEquals(statusCode, CREATED_SUCCESSCODE);
    }

    @Then(": Validating the please enter the invalid email text")
    public void validatingThePleaseEnterTheInvalidEmailText() {
        String pleaseEnterValidEmailText = dependencyInjection.getContactsPage().getPleaseEnterInvalidEmailText();
        Assert.assertEquals(pleaseEnterValidEmailText, PLEASE_ENTER_VALID_EMAIL);
    }
}

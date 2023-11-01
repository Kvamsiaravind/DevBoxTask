package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.restassured.RestAssured.given;
import static utilities.Utility.*;
import static utilities.Utility.getTextFromElement;


public class ContactsPage {
    private WebDriver driver;
    public ContactsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "IndexId")
    private WebElement homeSection;

    @FindBy(xpath = "//*[@id='Services1']")
    private WebElement servicesSection;

    @FindBy(id = "Portfolio1")
    private WebElement portfolioSection;

    @FindBy(id = "Clients1")
    private WebElement clientSection;

    @FindBy(id = "Careers1")
    private WebElement careersSection;

    @FindBy(id = "Contacts1")
    private WebElement contactsSection;

    @FindBy(linkText = "ABOUT")
    private WebElement aboutSection;

    @FindBy(className = "logo-g")
    private WebElement logoButton;

    @FindBy(name = "FullName")
    private WebElement nameField;

    @FindBy(name = "Email")
    private WebElement emailField;

    @FindBy(name = "Phone")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@placeholder='your-subject']")
    private WebElement yourSubjectField;

    @FindBy(id = "txtDescription")
    private WebElement messageField;

    @FindBy(name = "CaptchaText")
    private WebElement captchaField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement sendMessageButton;

    @FindBy(id = "txtEmail-error")
    private WebElement invalidEmailText;

    @FindBy(id = "txtName-error")
    private WebElement invalidNameText;

    @FindBy(id = "//*[@id='txtcategory-error']")
    private WebElement invalidMobileNumberText;

    @FindBy(id = "txtSubject-error")
    private WebElement invalidSubjectText;

    @FindBy(xpath = "//*[contains(text(),'Please Enter Captcha')]")
    private WebElement invalidCaptchaText;

    @FindBy(id = "txtSubscribe")
    private WebElement subscribeEmailField;

    @FindBy(id = "ErrorValidation")
    private WebElement pleaseEnterValidEmailText;

    public String getPleaseEnterInvalidEmailText(){
        return getTextFromElement(driver, pleaseEnterValidEmailText);
    }

    public void enterEmailIntoSubscribeEmailField(String email){
        sendKeysIntoField(driver, subscribeEmailField, email);
    }

    public String getInvalidCaptchaText(){
        return getTextFromElement(driver, invalidCaptchaText);
    }

    public String getSubjectInvalidText(){
        return getTextFromElement(driver, invalidSubjectText);
    }

    public String getMobileNumberInvalidText(){
        return getTextFromElement(driver, invalidMobileNumberText);
    }

    public String getEmailInvalidText(){
        return getTextFromElement(driver, invalidEmailText);
    }

    public String getNameInvalidText(){
        return getTextFromElement(driver, invalidNameText);
    }

    public void clickOnContactSection(){
        clickOnFields(driver,contactsSection,5);
    }

    public String getPageTitle(){
       return driver.getTitle();
    }



    public void clickOnHomeSection(){
        clickOnFields(driver, homeSection, 5);
    }

    public void clickOnAboutSection(){
        clickOnFields(driver, aboutSection, 5);
    }

    public void enterNameIntoNameField(String name){
        sendKeysIntoField(driver, nameField, name);
    }

    public void enterEmailIntoEmailField(String email){
        sendKeysIntoField(driver, emailField, email);
    }

    public void enterMobileNumberIntoMobileNumberField(String mobileNumber){
        sendKeysIntoField(driver, phoneNumberField, mobileNumber);
    }

    public void enterYourSubjectIntoSubjectField(String yourSubject){
        sendKeysIntoField(driver, yourSubjectField, yourSubject);
    }

    public void enterMessageIntoMessageField(String message){
        sendKeysIntoField(driver, messageField, message);
    }

    public void clickOnSendMessageButton(){
        clickOnFields(driver, sendMessageButton, 5);
    }

    public void enterCaptchaIntoCaptchaField(String captcha){
        sendKeysIntoField(driver, captchaField, captcha);
    }
}

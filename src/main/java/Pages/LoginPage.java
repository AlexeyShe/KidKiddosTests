package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.logging.Level;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LoginPage extends BasePage {

    private static final String LOGO_XPATH = "//h1[text()='Login']";
    private static final String SIGN_IN_BUTTON_XPATH = "//input[@value = 'Sign In']";
    private static final String ERROR_SIGNIN_MESSAGE_XPATH = "//*[@id='customer_login']/div[1]/ul/li";
    private static final String EMAIL_LABEL_XPATH = "//label[text()='Email']";
    private static final String EMAIL_FIELD_LOCATOR = "//input[@name='customer[email]']";
    private static final String PASSWORD_FIELD_XPATH = "//input[@id='CustomerPassword']";
    private static final String FORGOT_PASSWORD_XPATH = "//*[@id='RecoverPassword']";
    private static final String CREATE_ACCOUNT_BTN_XPATH = "//a[text()='Create account']";
    private static final String RESET_PASSWORD_HEADER_XPATH = "//h2[text()='Reset your password']";
    private static final String CREATE_ACCOUNT_HEADER_XPATH = "//h1[text()='Create Account']";
    private static final String EMAIL_IS_TAKEN_HEADER = "//*[@id='create_customer']/div/ul/li";
    private static final String FIRST_NAME_XPATH = "//input[@name='customer[first_name]']";
    private static final String LAST_NAME_XPATH = "//input[@name='customer[last_name]']";
    private static final String EMAIL_CREATE_ACC_XPATH = "//input[@name='customer[email]']";
    private static final String PASSW_CREATE_ACC_XPATH = "//input[@name='customer[password]']";
    private static final String SUBMIT_CREATE_ACC_BTN_XPATH = "//*[@id='create_customer']/p/input";
    private static final String TOO_SHORT_PASSWORD_ERR_MSG_XPATH = "//*[@id='create_customer']/div/ul/li";


    public void navigateLoginPage() {

        webDriver.get(Consts.LOGIN_PAGE);
    }

    public String getCurrentURL() {

        return webDriver.getCurrentUrl();
    }

    public boolean isLogoVisible() {
        return elementExistsByXpath(LOGO_XPATH);
    }

    public void loginButtonClick() {
        clickElementByXpath(SIGN_IN_BUTTON_XPATH);
    }

    public boolean isElementVisible(String xpath) {
        return elementExistsByXpath(xpath);
    }

    public void sendKeysEmail(String email) {

        sendTextToElementByXpath(EMAIL_FIELD_LOCATOR, email);
    }

    public void sendKeysFirstName(String firstName) {
        sendTextToElementByXpath(FIRST_NAME_XPATH, firstName);
    }

    public void sendKeysLastName(String lastName) {
        sendTextToElementByXpath(LAST_NAME_XPATH, lastName);
    }

    public void sendKeysPassword(String password) {

        sendTextToElementByXpath(EMAIL_FIELD_LOCATOR,  password);
    }

    public void sendKeysNewPassword(String newPassword) {

        sendTextToElementByXpath(PASSW_CREATE_ACC_XPATH, newPassword);
    }

    public void sendKeysNewEmail(String newEmail) {

        sendTextToElementByXpath(EMAIL_CREATE_ACC_XPATH, newEmail);
    }

    public boolean forgotPasswordIsOpen() {
        webDriver.findElement(with(By.xpath("//a")).below(findElementByXpath(PASSWORD_FIELD_XPATH))).click();
        return isElementVisible(RESET_PASSWORD_HEADER_XPATH);
    }

    public boolean createAccountIsOpen() {
        webDriver.findElement(with(By.xpath("//a")).below(findElementByXpath(SIGN_IN_BUTTON_XPATH))).click();
        return isElementVisible(CREATE_ACCOUNT_HEADER_XPATH);
    }

    public void openCreateAccPage() {
        clickElementByXpath(CREATE_ACCOUNT_BTN_XPATH);
    }

    public void createAccBtnClick() {
        clickElementByXpath(SUBMIT_CREATE_ACC_BTN_XPATH);
    }

    public boolean isErrorSingIsVisible() {
        return elementExistsByXpath(ERROR_SIGNIN_MESSAGE_XPATH);
    }

    public boolean isEmailsIsTakenVisible() {
        return elementExistsByXpath(EMAIL_IS_TAKEN_HEADER);
    }

    public boolean isErrTooShortPasswIsVisible() {
        return elementExistsByXpath(TOO_SHORT_PASSWORD_ERR_MSG_XPATH);
    }

    public Level severeWarnings() {
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entries.getAll();

        for (LogEntry e : logs) {
            if (e.getLevel() == Level.SEVERE) {
                System.out.println("Message " + e.getMessage());
                System.out.println("Level " + e.getLevel());
                return e.getLevel();
            }

        }
        return null;
    }

}

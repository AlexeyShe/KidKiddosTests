package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.logging.Level;

public class ContactUsPage extends BasePage {

    private static final String CONTACT_US_HEADER = "//h1[text()='Contact us']";
    private static final String NAME_INPUT_XPATH = "//input[@name = 'field[3]']";
    private static final String EMAIL_INPUT_XPATH = "//input[@name = 'email']";
    private static final String MESSAGE_INPUT_XPATH = "//textarea[@name = 'field[7]']";
    private static final String SEND_MESSAGE_BUTTON = "//button[text()= ' Send your message ']";
    private static final String ERROR_MESSAGE_XPATH = "//div[text()='This field is required.']";
    private static final String INCORRECT_EMAIL_ERROR_MESSAGE = "//div[text()='Enter a valid email address.']";

    public boolean isPageTitleVisible() {

        return elementExistsByXpath(CONTACT_US_HEADER);

    }

    public void navigateToContactUsPage() {
        webDriver.get(Consts.CONTACT_US_URL);
    }

    public String getCurrentURL() {

        return webDriver.getCurrentUrl();
    }

    public void sendKeys(String xpath, String text) {

        sendTextToElementByXpath(xpath, text);
    }

    public void sendMessageClick() {

        webDriver.findElement(By.xpath(SEND_MESSAGE_BUTTON)).click();
    }

    public void nameSendKeys(String name) {
        sendKeys(NAME_INPUT_XPATH, name);
    }

    public void messageSendKeys(String message) {
        sendKeys(MESSAGE_INPUT_XPATH, message);
    }

    public void emailSendKeys(String email) {
        sendKeys(EMAIL_INPUT_XPATH, email);
    }

    public boolean errorMessageIsShown() {
        return elementExistsByXpath(ERROR_MESSAGE_XPATH);
    }

    public boolean incorrectEmailMessageIsShown() {

        return elementExistsByXpath(INCORRECT_EMAIL_ERROR_MESSAGE);
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

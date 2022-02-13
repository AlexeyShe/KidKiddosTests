package Pages;

import Consts.Consts;
import org.openqa.selenium.By;

public class ContactUsPage extends BasePage {

    public static final String CONTACT_US_HEADER = "//h1[text()='Contact us']";
    public static final String NAME_INPUT_XPATH = "//input[@name = 'field[3]']";
    public static final String EMAIL_INPUT_XPATH = "//input[@name = 'email']";
    public static final String MESSAGE_INPUT_XPATH = "//textarea[@name = 'field[7]']";
    public static final String SEND_MESSAGE_BUTTON = "//button[text()= ' Send your message ']";
    public static final String ERROR_MESSAGE_XPATH = "//div[text()='This field is required.']";
    public static final String INCORRECT_EMAIL_ERROR_MESSAGE = "//div[text()='Enter a valid email address.']";

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

    public boolean errorMessageIsShown() {
        return elementExistsByXpath(ERROR_MESSAGE_XPATH);
    }

    public boolean incorrectEmailMessageIsShown() {

        return elementExistsByXpath(INCORRECT_EMAIL_ERROR_MESSAGE);
    }

}

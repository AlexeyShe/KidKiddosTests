import Pages.*;
import Utiliies.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ContactUsPageTests extends UseCaseBase {

    private static ContactUsPage contactUsPage;
    public final Logger logger = LogManager.getLogger("ContactUsLogger");

    @BeforeAll
    public static void classSetUp() {
        contactUsPage = new ContactUsPage();
    }

    @BeforeEach
    public void beforeTests() {
        contactUsPage.navigateToContactUsPage();
    }

    @Test
    public void pageIsOpenTest() {
        contactUsPage.takeScreenshot("contact_us_page_is_opened");
        assertEquals(contactUsPage.getCurrentURL(), "https://kidkiddos.com/pages/contact-us");
    }

    @Test
    public void emptyNameFieldErrorTest() {
        logger.info("Empty Name field test");
        contactUsPage.sendKeys(contactUsPage.MESSAGE_INPUT_XPATH, "qqq");
        contactUsPage.sendKeys(contactUsPage.EMAIL_INPUT_XPATH, "rrr");
        contactUsPage.sendMessageClick();
        contactUsPage.takeScreenshot("empty_name_field_error_message");
        assertTrue(contactUsPage.errorMessageIsShown());
    }

    @Test
    public void emptyEmailFieldErrorTest() {
        logger.info("Empty Email field test");
        contactUsPage.sendKeys(contactUsPage.MESSAGE_INPUT_XPATH, "qqq");
        contactUsPage.sendKeys(contactUsPage.NAME_INPUT_XPATH, "rrr");
        contactUsPage.sendMessageClick();
        contactUsPage.takeScreenshot("empty_email_field_error_message");
        assertTrue(contactUsPage.errorMessageIsShown());
    }

    @Test
    public void emptyTextFieldErrorTest() {
        logger.info("Empty Text field test");
        contactUsPage.sendKeys(contactUsPage.EMAIL_INPUT_XPATH, "qqq");
        contactUsPage.sendKeys(contactUsPage.NAME_INPUT_XPATH, "rrr");
        contactUsPage.sendMessageClick();
        contactUsPage.takeScreenshot("empty_tex_field_error_message");
        assertTrue(contactUsPage.errorMessageIsShown());
    }

    @Test
    public void incorrectEmailErrorTest() {
        logger.info("Incorrect Email field test");
        contactUsPage.sendKeys(contactUsPage.EMAIL_INPUT_XPATH, "qqq");
        contactUsPage.sendMessageClick();
        assertTrue(contactUsPage.incorrectEmailMessageIsShown());
    }


    @ParameterizedTest
    @CsvSource(value = {
            "assad, 343434.asasas, asdffdfd",
            ".,      asss,            ''",
            "'',     '1',               ''",
            "1,          @#$$% , #$#$##$#$^&*",
            "@,        @,            @  ",
            "'','' ,''  ",
            "asdiunjk2nbk3988s7dfbjsbdfiuhsdjbfbijshdfuishidfiuhsuberjwiuiusbfijsdbcbsbbdjbfijsbijfbijsdkbnf, asas@dfdf.com, ''",

    })

    public void contactUsNegativeTests(String name, String email, String message) {
        logger.info("Contact page negative tests");
        Date d = new Date();
        contactUsPage.sendKeys(ContactUsPage.NAME_INPUT_XPATH, name);
        contactUsPage.sendKeys(ContactUsPage.EMAIL_INPUT_XPATH, email);
        contactUsPage.sendKeys(ContactUsPage.MESSAGE_INPUT_XPATH, message);
        contactUsPage.sendMessageClick();
        contactUsPage.takeScreenshot("incorrect_input_contact_us_page" + d);
        assertEquals(contactUsPage.getCurrentURL(), "https://kidkiddos.com/pages/contact-us");

    }
}
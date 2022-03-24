import Pages.*;
import Utiliies.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTests extends UseCaseBase {

    private static LoginPage loginPage;
    public final Logger logger = LogManager.getLogger("LoginPageTestLogger");

    @BeforeAll
    public static void classSetUp() {
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void beforeTests() {
        loginPage.navigateLoginPage();
    }

    @Test
    public void loginPageLoadtest() {
        assertTrue(loginPage.isLogoVisible());
    }

    @Test
    public void errorMessageVisible() {
        loginPage.loginButtonClick();
        assertTrue(loginPage.isErrorSingIsVisible() || loginPage.getCurrentURL().equals("https://kidkiddos.com/challenge"));
    }

    @ParameterizedTest
    @CsvSource({"" +
            "asdasd, asdasd",
            "!@#$#%#$%, $%$%$%",
            "'', ''",
            "aasdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsfdsdfsdfdfsdf, qweqe@mail.com",
            "a, as@sdf",
            "123123, 1313",
            "www, @"
    })

    public void loginPageNegativeTests(String email, String password) {
        logger.info("Login page negative tests");
        loginPage.sendKeysEmail(email);
        loginPage.sendKeysPassword(password);
        loginPage.loginButtonClick();
        assertEquals("https://kidkiddos.com/account/login", loginPage.getCurrentURL());
        loginPage.takeScreenshot("login_page_negative_test " + email + " " + password);

    }

    @Test
    public void loginPagePositiveTest() {
        logger.info("login page positive tests");
        loginPage.sendKeysEmail("alexbatanik@gmail.com");
        loginPage.sendKeysPassword("112233A");
        loginPage.loginButtonClick();
        assertTrue(loginPage.getCurrentURL().equals("https://kidkiddos.com/account") || loginPage.getCurrentURL().equals("https://kidkiddos.com/challenge"));
        loginPage.takeScreenshot("login_page_positive_test");
    }

    @Test
    public void forgotPasswordIsOpened() {
        logger.info("login page/ forgotten password test");
        assertTrue(loginPage.forgotPasswordIsOpen());
        loginPage.takeScreenshot("forgotten_password");
    }

    @Test
    public void createAccountPageIsOpen() {
        logger.info("checking Account Page is Open");
        assertTrue(loginPage.createAccountIsOpen());
        loginPage.takeScreenshot("create new account page");
    }

    @Test
    public void takenEmailErrorMessage() {
        logger.info("taken email test");
        loginPage.openCreateAccPage();
        loginPage.sendKeysFirstName("aaaa");
        loginPage.sendKeysLastName("bbbb");
        loginPage.sendKeysNewEmail("alexbatanik@gmail.com");
        loginPage.sendKeysNewPassword("password");
        loginPage.createAccBtnClick();
        loginPage.takeScreenshot("taken_email_error_message");
        assertTrue(loginPage.isEmailsIsTakenVisible());
    }

    @ParameterizedTest

    @CsvSource({
            "1",
            "123",
            "sasd"
    })
    public void tooShortPasswordErrMsg(String password) {
        logger.info("short password test");
        loginPage.openCreateAccPage();
        loginPage.sendKeysFirstName("aaaa123");
        loginPage.sendKeysLastName("bbbb122");
        loginPage.sendKeysNewEmail("aaa@gmail.com");
        loginPage.sendKeysNewPassword(password);
        loginPage.createAccBtnClick();
        loginPage.takeScreenshot("too_short_passw " + password);
        assertTrue(loginPage.isErrTooShortPasswIsVisible());
    }

    @Test

    public void noSevereMessagesTest() {
        assertNotEquals(Level.SEVERE, loginPage.severeWarnings());
    }

}

import Pages.*;
import Utiliies.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertTrue(loginPage.isElementVisible(LoginPage.ERROR_SIGNIN_MESSAGE_XPATH) || loginPage.getCurrentURL().equals("https://kidkiddos.com/challenge"));
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
        loginPage.sendKeys(LoginPage.EMAIL_FIELD_XPATH, email);
        loginPage.sendKeys(LoginPage.PASSWORD_FIELD_XPATH, password);
        loginPage.loginButtonClick();
        assertEquals("https://kidkiddos.com/account/login", loginPage.getCurrentURL());
        loginPage.takeScreenshot("login_page_negative_test " + email + " " + password);

    }

    @Test
    public void loginPagePositiveTest() {
        logger.info("login page positive tests");
        loginPage.sendKeys(LoginPage.EMAIL_FIELD_XPATH, "alexbatanik@gmail.com");
        loginPage.sendKeys(LoginPage.PASSWORD_FIELD_XPATH, "112233A");
        loginPage.loginButtonClick();
        assertTrue(loginPage.getCurrentURL().equals("https://kidkiddos.com/account") || loginPage.getCurrentURL().equals("https://kidkiddos.com/challenge"));
        loginPage.takeScreenshot("login_page_posistive_test");
    }

    @Test
    public void forgotPasswordIsOpened() {
        logger.info("login page/ forgotten password test");
        assertTrue(loginPage.forgotPasswordIsOpen());
        loginPage.takeScreenshot("frogotten_password");
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
        loginPage.sendKeys(LoginPage.FIRST_NAME_XPATH, "aaaa");
        loginPage.sendKeys(LoginPage.LAST_NAME_XPATH, "bbbb");
        loginPage.sendKeys(LoginPage.EMAIL_CREATE_ACC_XPATH, "alexbatanik@gmail.com");
        loginPage.sendKeys(LoginPage.PASSW_CREATE_ACC_XPATH, "password");
        loginPage.createAccBtnClick();
        loginPage.takeScreenshot("teken_email_error_message");
        assertTrue(loginPage.isElementVisible(LoginPage.EMAIL_IS_TAKEN_HEADER));
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
        loginPage.sendKeys(LoginPage.FIRST_NAME_XPATH, "aaaa");
        loginPage.sendKeys(LoginPage.LAST_NAME_XPATH, "bbbb");
        loginPage.sendKeys(LoginPage.EMAIL_CREATE_ACC_XPATH, "aaa@gmail.com");
        loginPage.sendKeys(LoginPage.PASSW_CREATE_ACC_XPATH, password);
        loginPage.createAccBtnClick();

        loginPage.takeScreenshot("too_short_passw " + password);
        assertTrue(loginPage.isElementVisible(LoginPage.TOO_SHORT_PASSWORD_ERR_MSG_XPATH));
    }

}

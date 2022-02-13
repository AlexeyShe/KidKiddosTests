package Pages;


import Consts.Consts;

public class LoginPage extends BasePage {

    private static final String LOGO_XPATH = "//h1[text()='Login']";
    private static final String SIGN_IN_BUTTON_XPATH = "//input[@value = 'Sign In']";
    public static final String ERROR_SIGNIN_MESSAGE_XPATH = "//*[@id='customer_login']/div[1]/ul/li";
    public static final String EMAIL_FIELD_XPATH = "//input[@name='customer[email]']";
    public static final String PASSWORD_FIELD_XPATH = "//input[@id='CustomerPassword']";
    private static final String FORGOT_PASSWORD_XPATH = "//*[@id='RecoverPassword']";
    private static final String CREATE_ACCOUNT_BTN_XPATH = "//a[text()='Create account']";
    private static final String RESET_PASSWORD_HEADER_XPATH = "//h2[text()='Reset your password']";
    private static final String CREATE_ACCOUNT_HEADER_XPATH = "//h1[text()='Create Account']";
    public static final String EMAIL_IS_TAKEN_HEADER = "//*[@id='create_customer']/div/ul/li";
    public static final String FIRST_NAME_XPATH = "//input[@name='customer[first_name]']";
    public static final String LAST_NAME_XPATH = "//input[@name='customer[last_name]']";
    public static final String EMAIL_CREATE_ACC_XPATH = "//input[@name='customer[email]']";
    public static final String PASSW_CREATE_ACC_XPATH = "//input[@name='customer[password]']";
    public static final String SUBMIT_CREATE_ACC_BTN_XPATH = "//*[@id='create_customer']/p/input";
    public static final String TOO_SHORT_PASSWORD_ERR_MSG_XPATH = "//*[@id='create_customer']/div/ul/li";


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

    public void sendKeys(String xpath, String text) {

        sendTextToElementByXpath(xpath, text);
    }

    public boolean forgotPasswordIsOpen() {
        clickElementByXpath(FORGOT_PASSWORD_XPATH);
        return isElementVisible(RESET_PASSWORD_HEADER_XPATH);
    }

    public boolean createAccountIsOpen() {
        clickElementByXpath(CREATE_ACCOUNT_BTN_XPATH);
        return isElementVisible(CREATE_ACCOUNT_HEADER_XPATH);
    }

    public void openCreateAccPage() {
        clickElementByXpath(CREATE_ACCOUNT_BTN_XPATH);
    }

    public void createAccBtnClick() {
        clickElementByXpath(SUBMIT_CREATE_ACC_BTN_XPATH);
    }


}

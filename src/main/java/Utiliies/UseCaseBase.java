package Utiliies;

import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class UseCaseBase {

    private static WebDriver webDriver;

        private static BasePage page;

    @BeforeAll

    public static void setUPMain () {

        page = new BasePage();
        webDriver = SharedDriver.getWebDriver();
        page.setWebDriver(webDriver);
    }

    @AfterAll

    public static void tearDownMain (){

        SharedDriver.closeDriver();
        webDriver = null;

    }


}

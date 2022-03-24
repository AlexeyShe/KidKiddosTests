import Pages.*;
import Utiliies.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTests extends UseCaseBase {

    private static MainPage mainPage;
    public final Logger logger = LogManager.getLogger("MainPageTestLogger");


    @BeforeAll
    public static void classSetUp() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTests() {
        mainPage.navigateToMainPage();
    }

    @Test
    public void mainPageLoadTest() {
        boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("Main_page_is_loaded");
        assertTrue(success);
    }

    @Test
    public void openContactPageTest() {
        logger.info("Check if page is opened");
        ContactUsPage contactUsPage = mainPage.openContactUsPage();
        boolean isLoaded = contactUsPage.isPageTitleVisible();
        mainPage.takeScreenshot("Contact_page_is_loaded");
        assertTrue(isLoaded);

    }

    @Test
    public void openBooksByLangPageTest() {
        logger.info("open Books by lang page");
        BooksByLanguagePage booksByLanguagePage = mainPage.openBooksByLanguage();
        boolean isLoaded = booksByLanguagePage.isPageTitleVisisble();
        mainPage.takeScreenshot("Main_books_by_lang");
        assertTrue(isLoaded);

    }

    @Test
    public void openEbooksByLangPageTest() {
        logger.info("open eBooks by lang page");
        EbooksByLanguagePage ebooksByLanguagePage = mainPage.openEbooksByLanguage();
        boolean isLoaded = ebooksByLanguagePage.isPageIsVisible();
        mainPage.takeScreenshot("Ebooks_by_lang_is_loaded");
        assertTrue(isLoaded);
    }

    @Test
    public void openBlogPageTest() {
        logger.info("opening Blog page");
        BlogPage blogPage = mainPage.openBlogPage();
        boolean isLoaded = blogPage.isPageVisible();
        mainPage.takeScreenshot("Blog_page_is_opened");
        assertTrue(isLoaded);
    }

    @Test
    public void openChinesePageTest() {
        logger.info("opening Chinese language page test");
        mainPage.openChinesePage();
        LanguagePage languagePage = new LanguagePage();
        assertTrue(languagePage.isPageVisible(LanguagePage.CHINESE_LANG_HEADER));
        mainPage.takeScreenshot("Chinese_lang_page_is_opened");
    }

    @Test
    public void openEspanolPageTest() {
        logger.info("opening Chinese language page test");
        LanguagePage languagePage = new LanguagePage();
        mainPage.openEspanolPage();
        assertTrue(languagePage.isPageVisible(LanguagePage.ESPANOL_PAGE_HEADER));
        mainPage.takeScreenshot("Chinese_lang_page_is_opened");
    }

    @Test
    public void openFaqPageTest() {
        logger.info("opening FAQ page test");
        FaqPage faqPage = mainPage.openFaqPage();
        boolean isLoaded = faqPage.isPageVisible();
        mainPage.takeScreenshot("FAQ_page_is_opened");
        assertTrue(isLoaded);
    }

    @Test
    public void openFrancaisPageTest() {
        logger.info("opening Chinese language page test");
        mainPage.openFrancaisPage();
        LanguagePage languagePage = new LanguagePage();
        assertTrue(languagePage.isPageVisible(LanguagePage.FRANCAIS_PAGE_HEADER));
        mainPage.takeScreenshot("Chinese_lang_page_is_opened");
    }

    @Test
    public void openLanguagePageTest() {
        logger.info("opening LangPage page");
        LanguagePage languagePage = mainPage.openLanguagePage(MainPage.ESPANOL_LANG_PAGE);
        boolean isLoaded = languagePage.isPageVisible(LanguagePage.ESPANOL_PAGE_HEADER);
        mainPage.takeScreenshot("Page_is_opened");
        assertTrue(isLoaded);
    }

    @Test
    public void openGalleryPageTest() {
        logger.info("opening Gallery page test");
        GalleryPage galleryPage = mainPage.openGalleryPage();
        boolean isLoaded = galleryPage.isPageVisible();
        mainPage.takeScreenshot("Gallery_page_is_opened");
        assertTrue(isLoaded);
    }

    @Test
    public void openGiftCardPageTest() {
        logger.info("opening Gift page test");
        GiftCardPage giftCardPage = mainPage.openGiftCardPage();
        boolean isLoaded = giftCardPage.isPageVisible();
        mainPage.takeScreenshot("Gift_card_page_is_opened");
        assertTrue(isLoaded);
    }

    @Test
    public void openHomePageTest() {
        logger.info("opening Home page from Gift page test");
        mainPage.openGiftCardPage();
        HomePage homePage = mainPage.openHomePage();
        boolean isLoaded = homePage.isPageVisible();
        mainPage.takeScreenshot("Home_page_is_opened");
        assertTrue(isLoaded);
    }

    @Test
    public void openResourcePageTest() {
        logger.info("opening Resource page test");
        ResourcesPage resourcesPage = mainPage.openResourcePage();
        boolean isLoaded = resourcesPage.isPageVisible();
        mainPage.takeScreenshot("Resource_page_is_opened");
        assertTrue(isLoaded);
    }

    @Test
    public void booksByLanguageDropDownTest() {
        logger.info("checking Select language drop down list for Books");

        mainPage.booksByLanguageDropDownListClick(MainPage.LANG_LIST_ENGLISH);
        mainPage.takeScreenshot("English_lang_books_page_opened");
        assertEquals(mainPage.getCurrentURL(), MainPage.LANG_LIST_ENGLISH_PAGE_URL);

        mainPage.booksByLanguageDropDownListClick(MainPage.LANG_LIST_DUTCH);
        mainPage.takeScreenshot("Dutch_lang_books_page_opened");
        assertEquals(mainPage.getCurrentURL(), MainPage.LANG_LIST_DUTCH_PAGE_URL);

        mainPage.booksByLanguageDropDownListClick(MainPage.LANG_LIST_NON_ENGLISH);
        mainPage.takeScreenshot("NON_English_lang_books_page_opened");
        assertEquals(mainPage.getCurrentURL(), MainPage.LANG_LIST_NON_ENG_PAGE_URL);

    }

    @Test
    public void eBooksByLanguageDropDownTest() {
        logger.info("checking Select language drop down list for eBooks");

        mainPage.eBooksByLanguageDropDownListClick(MainPage.EBOOK_LANG_LIST_BULGARIAN_OPTION);
        mainPage.takeScreenshot("Bulgarian_lang_ebooks_page_opened");
        assertEquals(mainPage.getCurrentURL(), MainPage.EBOOK_BULGARIAN_URL);


        mainPage.eBooksByLanguageDropDownListClick(MainPage.EBOOK_LANG_LIST_RUSSIAN_OPTION);
        mainPage.takeScreenshot("Russian_lang_ebooks_page_opened");
        assertEquals(mainPage.getCurrentURL(), MainPage.EBOOK_RUSSIAN_URL);

        mainPage.eBooksByLanguageDropDownListClick(MainPage.EBOOK_LANG_LIST_VIETNAMESE_OPTION);
        mainPage.takeScreenshot("Vietnamese_lang_ebooks_page_opened");
        assertEquals(mainPage.getCurrentURL(), MainPage.EBOOK_VIETNAMESE_URL);

    }

    @Test
    public void resourcesDropDownTest() {
        logger.info("checking drop down list for resource option");
        mainPage.resourcesListClick(MainPage.RESOURCES_LIST_VIDEO_OPTION);
        mainPage.takeScreenshot("Resource_video_page_opened");
        assertEquals(mainPage.getCurrentURL(), MainPage.RESOURCES_VIDEO_URL);
    }

    @Test
    public void openYourCartPage() {
        logger.info("opening Resource page test");
        mainPage.openYourCartPage();
        YourCartPage yourCartPage = new YourCartPage();
        mainPage.takeScreenshot("cartPage_is_opened");
        assertTrue(yourCartPage.isPAgeVisible());
    }

    @ParameterizedTest
    @CsvSource({
            "1, CAD",
            "2, AUD",
            "3, BRL",
            "4, CAD",
            "5, EUR",
            "6, GBP",
            "7, INR",
            "8, NZD",
            "9, SGD",
            "10, USD"

    })
    public void selectCurrencyTest(String listNumber, String currency) throws InterruptedException {
        logger.info("checking currency options");
        assertTrue(mainPage.selectCurrency(listNumber, currency));
        mainPage.takeScreenshot("currency " + currency);
        Thread.sleep(1000);
    }

    @Test

    public void captureLogoImgTest() throws IOException {
        logger.info("Capturing logo image");
        mainPage.captureLogo();
    }

    @Test

    public void logsNoSevereWarningsTest() {
        assertNotEquals(Level.SEVERE, mainPage.severeWarnings());
    }
}



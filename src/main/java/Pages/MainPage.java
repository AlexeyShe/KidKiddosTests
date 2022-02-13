package Pages;

import Consts.Consts;

public class MainPage extends BasePage {

    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    private static final String CONTACT_US_OPTION = "//a[text()= 'Contact us']";
    private static final String BOOKS_BY_LANGUAGE = "//a[@aria-controls='SiteNavLabel-books-by-language']";
    private static final String EBOOKS_BY_LANGUAGE = "//a[@aria-controls='SiteNavLabel-ebooks-by-language']";
    private static final String BLOG_PAGE = "//a[text()='Blog']";
    private static final String CHINISE_LANG_PAGE = "//a[text()= '中文']";
    public static final String ESPANOL_LANG_PAGE = "//a[text()= 'Español']";
    private static final String FAQ_PAGE = "//a[text()= 'FAQs']";
    private static final String FRANCAIS_LANG_PAGE = "//a[text()= 'Français']";
    private static final String GALLERY_PAGE = "//a[text()= 'Gallery']";
    private static final String HOME_PAGE = "//a[text()= 'Home']";
    private static final String RESOURCE_PAGE = "//a[@aria-controls= 'SiteNavLabel-resources']";
    private static final String GIFT_CARD_PAGE = "//a[text()= 'Gift Card']";
    private static final String YOUR_CART_PAGE_XPATH = "//a[@class='site-header__cart']";


    // Language List Options
    public static final String LANG_LIST_ENGLISH = "//a[text()='English Only']";
    public static final String LANG_LIST_ENGLISH_PAGE_URL = "https://kidkiddos.com/collections/english-only";

    public static final String LANG_LIST_DUTCH = "//a[text()='Dutch - Nederlands']";
    public static final String LANG_LIST_DUTCH_PAGE_URL = "https://kidkiddos.com/collections/dutch";

    public static final String LANG_LIST_NON_ENGLISH = "//a[text()='Non English languages combination']";
    public static final String LANG_LIST_NON_ENG_PAGE_URL = "https://kidkiddos.com/collections/non-english-language-combinationa";

    // eBooks Language List Options

    public static final String EBOOK_LANG_LIST_BULGARIAN_OPTION = "//a[@class = 'site-nav__link site-nav__child-link' and @href='/collections/ebooks-in-bulgarian']";
    public static final String EBOOK_BULGARIAN_URL = "https://kidkiddos.com/collections/ebooks-in-bulgarian";

    public static final String EBOOK_LANG_LIST_RUSSIAN_OPTION = "//a[@class = 'site-nav__link site-nav__child-link' and @href='/collections/ebooks-in-russian']";
    public static final String EBOOK_RUSSIAN_URL = "https://kidkiddos.com/collections/ebooks-in-russian";

    public static final String EBOOK_LANG_LIST_VIETNAMESE_OPTION = "//a[@class = 'site-nav__link site-nav__child-link site-nav__link--last' and @href='/collections/ebooks-in-vietnamese-ti-ng-vi-t']";
    public static final String EBOOK_VIETNAMESE_URL = "https://kidkiddos.com/collections/ebooks-in-vietnamese-ti-ng-vi-t";

    // Resources List Options

    public static final String RESOURCES_LIST_VIDEO_OPTION = "//a[text()='Videos']";
    public static final String RESOURCES_VIDEO_URL = "https://kidkiddos.com/pages/videos-for-kids";

    //Currency converter Xpaths
    public static final String CURRENCY_CONVERTOR_XPATH = "//span[@class='currency-converter-currency-button-text']";


    public void navigateToMainPage() {
        webDriver.get(Consts.MAIN_URL);
    }

    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public boolean isLogoVisible() {
        return elementExistsByXpath(LOGO_IMG);
    }

    public ContactUsPage openContactUsPage() {
        clickElementByXpath(CONTACT_US_OPTION);
        return new ContactUsPage();
    }

    public BooksByLanguagePage openBooksByLanguage() {
        doubleClickElementByXpath(BOOKS_BY_LANGUAGE);
        return new BooksByLanguagePage();
    }

    public EbooksByLanguagePage openEbooksByLanguage() {
        doubleClickElementByXpath(EBOOKS_BY_LANGUAGE);
        return new EbooksByLanguagePage();
    }

    public BlogPage openBlogPage() {
        clickElementByXpath(BLOG_PAGE);
        return new BlogPage();
    }

    public void openChinesePage() {
        clickElementByXpath(CHINISE_LANG_PAGE);
    }

    public void openEspanolPage() {
        clickElementByXpath(ESPANOL_LANG_PAGE);
    }

    public FaqPage openFaqPage() {
        clickElementByXpath(FAQ_PAGE);
        return new FaqPage();
    }

    public void openFrancaisPage() {
        clickElementByXpath(FRANCAIS_LANG_PAGE);
    }

    public LanguagePage openLanguagePage(String xpath) {
        clickElementByXpath(xpath);
        return new LanguagePage();
    }

    public GalleryPage openGalleryPage() {
        clickElementByXpath(GALLERY_PAGE);
        return new GalleryPage();
    }

    public GiftCardPage openGiftCardPage() {
        clickElementByXpath(GIFT_CARD_PAGE);
        return new GiftCardPage();
    }


    public HomePage openHomePage() {
        clickElementByXpath(HOME_PAGE);
        return new HomePage();
    }

    public ResourcesPage openResourcePage() {
        doubleClickElementByXpath(RESOURCE_PAGE);
        return new ResourcesPage();
    }

    public void booksByLanguageDropDownListClick(String xpath) {
        clickElementByXpath(BOOKS_BY_LANGUAGE);
        clickElementByXpath(xpath);
    }

    public void eBooksByLanguageDropDownListClick(String xpath) {
        clickElementByXpath(EBOOKS_BY_LANGUAGE);
        clickElementByXpath(xpath);
    }

    public void resourcesListClick(String xpath) {
        clickElementByXpath(RESOURCE_PAGE);
        clickElementByXpath(xpath);
    }

    public void openYourCartPage() {
        clickElementByXpath(YOUR_CART_PAGE_XPATH);

    }

    public boolean selectCurrency(String currencyXpath, String actualCurrency) {
        openEspanolPage();
        clickElementByXpath(CURRENCY_CONVERTOR_XPATH);
        clickElementByXpath(currencyXpath);
        return elementExistsByXpath(actualCurrency);
    }
}

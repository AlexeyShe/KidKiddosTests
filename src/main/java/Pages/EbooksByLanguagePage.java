package Pages;

public class EbooksByLanguagePage extends BasePage {

    private static final String EBOOKS_BY_LANGUAGE_HEADER = "//h1[text()='ebooks']";

    public boolean isPageIsVisible() {

        return elementExistsByXpath(EBOOKS_BY_LANGUAGE_HEADER);
    }
}

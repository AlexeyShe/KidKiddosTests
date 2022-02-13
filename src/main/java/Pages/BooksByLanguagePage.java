package Pages;

public class BooksByLanguagePage extends BasePage {

    private static final String BOOKS_BY_LANG_HEADER = "//h1[text()='Find your language']";

    public boolean isPageTitleVisisble() {
        return elementExistsByXpath(BOOKS_BY_LANG_HEADER);
    }
}

package Pages;

public class LanguagePage extends BasePage {

    public static final String ESPANOL_PAGE_HEADER = "//h1[text()='Spanish - Español']";
    public static final String FRANCAIS_PAGE_HEADER = "//h1[text()='French - Français']";
    public static final String CHINESE_LANG_HEADER = "//h1[text()='Mandarin Chinese - 中文']";

    public boolean isPageVisible(String xpath) {
        return elementExistsByXpath(xpath);
    }
}

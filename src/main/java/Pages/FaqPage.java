package Pages;

public class FaqPage extends BasePage {
    private static final String FAQPAGE_HEADER = "//h1[text()='FAQ/addition info']";

    public boolean isPageVisible (){

        return elementExistsByXpath(FAQPAGE_HEADER);
    }
}

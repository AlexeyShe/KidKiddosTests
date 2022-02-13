package Pages;

public class GiftCardPage extends BasePage {

    private static final String GIFT_CARD_HEADER = "//h1[text()='Gift Card']";

    public boolean isPageVisible() {

        return elementExistsByXpath(GIFT_CARD_HEADER);
    }

}

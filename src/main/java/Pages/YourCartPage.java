package Pages;

public class YourCartPage extends BasePage{
    private static final String YOUR_CART_PAGE_HEADER = "//h1[text()='Your cart']";

    public boolean isPAgeVisible () {

        return elementExistsByXpath(YOUR_CART_PAGE_HEADER);
    }

}

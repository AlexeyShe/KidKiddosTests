import Pages.YourCartPage;
import Utiliies.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartTests extends UseCaseBase {

    private static YourCartPage yourCartPage;

    @BeforeAll
    public static void classSetUp() {
        yourCartPage = new YourCartPage();
    }

    @BeforeEach
    public void beforeTests() {
        yourCartPage.navigateToMainPage();
    }

    @Test

    public void addOneBookToCartTest() {
        yourCartPage.isCartEmpty();
        yourCartPage.addOneEngBookToCart();
        assertEquals("1", yourCartPage.isCartEmpty());
    }

    @Test

    public void addMultipleEngBooksToCartTest() {
        yourCartPage.isCartEmpty();
        yourCartPage.addMultipleEngBookToCart();
        assertEquals("3", yourCartPage.isCartEmpty());
    }

    @Test

    public void addMultipleLangBooksToCartTest() {
        yourCartPage.isCartEmpty();
        yourCartPage.addMultipleLangBookToCart();
        assertEquals(yourCartPage.getCount().toString(), yourCartPage.isCartEmpty());
    }
}

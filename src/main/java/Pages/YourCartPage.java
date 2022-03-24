package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class YourCartPage extends BasePage {

    public final Logger logger = LogManager.getLogger("CartLogger");
    private static final String YOUR_CART_PAGE_HEADER = "//h1[text()='Your cart']";
    public static final String BOOKS_LIST_XPATH = "//*[@id='SiteNav']/li[2]/a";

    public static final String ENG_LANG_BOOKS_XPATH = "//a[text()='English Only']";
    public static final String GERMAN_LANG_BOOKS_XPATH = "//a[text()='German - Deutsch']";
    public static final String WELSH_LANG_BOOKS_XPATH = "//a[text()='Welsh - Cymraeg']";


    private static final String MAIN_PAGE_URL = "https://kidkiddos.com/";
    private static final String CART_ITEMS_XPATH = "//*[@id='CartCount']/span[1]";

    private static final String BOOK_ENG_1_XPATH = "//div[contains(text(), 'I Love to Brush')]";
    private static final String BOOK_ENG_2_XPATH = "//div[contains(text(), 'Amanda')]";
    private static final String BOOK_ENG_3_XPATH = "//div[contains(text(), 'I Love My Dad')]";

    private static final String BOOK_GERM_1_XPATH = "//div[contains(text(), 'I Love My Mom')]";
    private static final String BOOK_GERM_2_XPATH = "//div[contains(text(), 'I Love to Tell the Truth')]";
    private static final String BOOK_GERM_3_XPATH = "//div[contains(text(), 'I Love to Eat Fruits and Vegetables')]";

    private static final String BOOK_WELSH_1_XPATH = "//div[contains(text(), 'The Wheels: The Friendship')]";
    private static final String BOOK_WELSH_2_XPATH = "//div[contains(text(), 'I Love My Dad')]";
    private static final String BOOK_WELSH_3_XPATH = "//div[contains(text(), 'I Love to Help')]";

    private static final String ADD_TO_CART_BTN_XPATH = "//*[@id='AddToCart-product-template']";

    List<String> langList = List.of(ENG_LANG_BOOKS_XPATH, ENG_LANG_BOOKS_XPATH, ENG_LANG_BOOKS_XPATH, GERMAN_LANG_BOOKS_XPATH, GERMAN_LANG_BOOKS_XPATH, GERMAN_LANG_BOOKS_XPATH, WELSH_LANG_BOOKS_XPATH, WELSH_LANG_BOOKS_XPATH, WELSH_LANG_BOOKS_XPATH);
    List<String> bookList = List.of(BOOK_ENG_1_XPATH, BOOK_ENG_2_XPATH, BOOK_ENG_3_XPATH, BOOK_GERM_1_XPATH, BOOK_GERM_2_XPATH, BOOK_GERM_3_XPATH, BOOK_WELSH_1_XPATH, BOOK_WELSH_2_XPATH, BOOK_WELSH_3_XPATH);


    public boolean isPAgeVisible() {

        return elementExistsByXpath(YOUR_CART_PAGE_HEADER);
    }

    public void navigateToMainPage() {
        webDriver.get(MAIN_PAGE_URL);
    }

    public String isCartEmpty() {
        if (isElementVisible(CART_ITEMS_XPATH)) {
            String items_amount = webDriver.findElement(By.xpath(CART_ITEMS_XPATH)).getText();
            System.out.println("Cart contains " + items_amount + " book/s");
            return items_amount;
        }
        System.out.println("Cart is empty");

        return null;
    }

    private int count = 0;

    public void countBooks() {
        count++;
    }

    public Integer getCount() {
        return count;
    }


    public void addBookToCart(int numberOfBooks) {
        //  webDriver.get(BOOKS_IN_ENG_URL);
        for (int i = 0; i < numberOfBooks; i++) {
            webDriver.findElement(By.xpath(BOOKS_LIST_XPATH)).click();
            webDriver.findElement(By.xpath(langList.get(i))).click();
            webDriver.findElement(By.xpath(bookList.get(i))).click();
            this.takeScreenshot("Book " + i);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADD_TO_CART_BTN_XPATH))).click();
            countBooks();
            logger.info("Book was added to Cart. Total added: " + getCount());

        }

    }

    public void addOneEngBookToCart() {
        addBookToCart(1);
    }

    public void addMultipleEngBookToCart() {
        addBookToCart(3);
    }

    public void addMultipleLangBookToCart() {
        addBookToCart(9);
    }


}

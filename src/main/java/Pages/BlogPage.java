package Pages;

public class BlogPage extends BasePage {

    private static final String BLOG_HEADER = "//h1[text()='Blog']";

    public boolean isPageVisible() {
        return elementExistsByXpath(BLOG_HEADER);
    }
}

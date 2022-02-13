package Pages;

public class ResourcesPage extends BasePage{
    private static final String RESOURCE_PAGE_HEADER = "//h1[text()='Fun and Educational Videos for Kids']";

    public boolean isPageVisible () {
        return elementExistsByXpath(RESOURCE_PAGE_HEADER);
    }
}

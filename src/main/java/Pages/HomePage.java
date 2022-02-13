package Pages;

public class HomePage extends BasePage{

    private static final String HOME_PAGE_LOGO = "//strong[text()='ONE BOOK']";

    public boolean isPageVisible (){
       return elementExistsByXpath(HOME_PAGE_LOGO);
    }

}

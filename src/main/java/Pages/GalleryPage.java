package Pages;

public class GalleryPage extends BasePage {
    private static final String GALLERY_PAGE_HEADER = "//h1[text()='Gallery']";

    public boolean isPageVisible (){
        return elementExistsByXpath(GALLERY_PAGE_HEADER);
    }
}

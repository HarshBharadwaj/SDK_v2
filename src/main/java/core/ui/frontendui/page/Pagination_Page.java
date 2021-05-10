package core.ui.frontendui.page;

import core.ui.page.UiBase;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class Pagination_Page extends UiBase {
    @FindBy(xpath = "//input[@class='UNX-searchbox__input']")
    public FluentWebElement searchBox;
    @FindBy(xpath = "//button[@data-testid='UNX_pageNumber2']")
    public FluentWebElement goTo2ndPage;
    @FindBy(xpath = "//button[text()='>']")
    public static FluentWebElement forwardArrow;
    @FindBy(xpath = "//button[text()='<']")
    public FluentWebElement backwardArrow;
    @FindBy(xpath = "//button[@class='UNX-pageNavigation__button -selected']")
    public static FluentWebElement currentPage;
    @FindBy (xpath = "//div[@class='UNX-pageNavigation__container']")
    public FluentWebElement unbxdPagination;
    public String productTitle="Beverly Hills Polo Club";
    public String sortByDropdown="//select[@class='UNX-sortby__dropdown']";
    public String productPerPageDropDown="//select[@class='UNX-pageSize__dropdown']";
    @FindBy(xpath = "//span[@class='-pageDescription']")
    public FluentWebElement productDescription;
    public String unbxdSearchQuery="Jacket";
    @FindBy (xpath = "//div[text()='Boys Fashion']")
    public FluentWebElement UnbxdCategoryFacet;
    @FindBy(xpath = "//div[@class='UNX-rangefacet__container']//div[@class='UNX-facet__item ']")
    public FluentWebElement UnbxdRangeFacet;
    @FindBy(xpath = "//button[@class='-apply']")
    public FluentWebElement applyButton;
    @FindBy (xpath = "//select[@class='UNX-pageSize__dropdown']")
    public FluentWebElement unbxdPageSizeDropDown;
    public String unbxdPageSizeDropdown="//select[@class='UNX-pageSize__dropdown']";
//    @FindBy(xpath = "//button[text()='>']")
//    public static FluentWebElement forwardArrow;
    public  String unbxdProductOnPage="//div[@class='UNX-productCard__container']";
    public String paginationUnbxd="//div[@class='UNX-pagination__pageNavigation']";
    public String paginationArrowIcon="//button[@class='UNX-pageNavigation__button -action']";
    public void clickPage() throws InterruptedException {
        forwardArrow.click();
        Thread.sleep(2000);
    }


}

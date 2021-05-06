package core.ui.frontendui.actions;

import core.ui.frontendui.page.Pagination_Page;
import javafx.scene.control.Pagination;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Pagination_Actions extends Pagination_Page {
    SoftAssert softAssert = new SoftAssert();
    //public Select sortList= new Select(getDriver().findElement(By.xpath(sortByDropdown)));
    //Select sortList;


    public Pagination_Actions goToWebsite(String url) {
        getDriver().navigate().to(url);
        awaitForPageToLoad();
        return this;
    }
    public void searchQuery(String query) throws InterruptedException {
        //click(searchBox);
        //searchBox.clear();
        searchBox.fill().with(query);
        searchBox.submit();
    }

    public void testPaginationIsDisplayingOrNot(String url,String query) throws InterruptedException {
        goToWebsite(url);
        searchQuery(query);
        Assert.assertEquals(unbxdPagination.isDisplayed(),true,"Fail: Pagination is not present");
        //System.out.println("Pass: pagination is getting displayed");
    }
    public void testPaginationIsWorkingOrNot(String url,String query) throws InterruptedException {
        goToWebsite(url);
        searchQuery(query);
        int cPage=Integer.parseInt(currentPage.getText());
        goTo2ndPage.click();
        Thread.sleep(2000);
        Assert.assertEquals(Integer.parseInt(currentPage.getText()),cPage+1,"Fail: Pagination is not working");
        //System.out.println("Pass: Pagination is working");
    }

    public void testPaginationBackArrowIsWorking(String url,String query) throws InterruptedException {
        goToWebsite(url);
        searchQuery(query);
        forwardArrow.click();
        Thread.sleep(2000);
        int oldPageNo=Integer.parseInt(currentPage.getText());
        backwardArrow.click();
        Assert.assertEquals(Integer.parseInt(currentPage.getText()),oldPageNo-1,"Pagination back arrow key is not working.");
        //System.out.println("Pass: Pagination Back arrow key is working.");
    }
    public  void testPaginationForwardArrowIsWorking(String url,String query) throws InterruptedException {
        goToWebsite(url);
        searchQuery(query);
        int oldPageNo=Integer.parseInt(currentPage.getText());
        forwardArrow.click();
        //Thread.sleep(2000);
        Assert.assertEquals(Integer.parseInt(currentPage.getText()),oldPageNo+1,"Forward Arrow key is working");
        //System.out.println("Pass: Pagination forward arrow key is working.");
    }

    public void testSelectedPageHighlightOrNot(String url,String query) throws InterruptedException {
        goToWebsite(url);
        searchQuery(query);
        int oldPageNo=Integer.parseInt(currentPage.getText());
        forwardArrow.click();
        //Thread.sleep(2000);
        int newPageNo=Integer.parseInt(currentPage.getText());
        Assert.assertEquals(newPageNo,oldPageNo+1,"Fail: Selected page is not getting highlighted");
        //System.out.println("Pass: Selected page is highlighted.");

    }

    /* total search result on the page calculation methord*/
    public int totalSearchResult()
    {
        String result = productDescription.getText();
        String[] totalSrcResult = result.split("of");
        int totalResult = Integer.parseInt(totalSrcResult[1].replace("products", "").replace(" ", ""));
        return totalResult;
    }
    public void  testPaginationScenarioInCaseOfLastPageResults(String url,String query) throws InterruptedException {
        goToWebsite(url);
        searchQuery(productTitle);
        Thread.sleep(2000);
        int totalResult=totalSearchResult();
        Select proPerPage = new Select(getDriver().findElement(By.xpath(productPerPageDropDown)));
        List<WebElement> allOption = proPerPage.getOptions();
        proPerPage.selectByVisibleText(allOption.get(allOption.size() - 1).getText());
        int maxNum = Integer.parseInt(allOption.get(allOption.size() - 1).getText());
        int i = 0;
        while (i < totalResult / maxNum) {
            clickPage();
            i++;
        }
        List<WebElement> pageArrows = getDriver().findElements(By.xpath(paginationArrowIcon));
        for (int j = 0; j < pageArrows.size()-1; j++) {
            if (pageArrows.get(j).getText() != ">")
                System.out.println("Pass: In case of last page, forward arrow key is not getting displayed.");
            else if (pageArrows.get(j).getText() == ">")
                System.out.println("Fail: In case of last page, forward arrow key is getting displayed, it should not display.");
        }

    }

    public void testPaginationInCaseOfSort(String url, String query) throws InterruptedException {
        int res=0;
        goToWebsite(url);
        searchQuery(query);
        Select sortList = new Select(getDriver().findElement(By.xpath(sortByDropdown)));
        List<WebElement> allSortOptions=sortList.getOptions();
        for(int i=allSortOptions.size()-1; i>=0;i--)
        {
            res=sortByTest(sortList,allSortOptions.get(i).getAttribute("value"));
            if(res==1)
            {
                System.out.println("Fail: Pagination is not working in case of sort["+allSortOptions.get(i).getText()+"]");
            }
            forwardArrow.click();
            Thread.sleep(2000);
        }
        if(res==0)
            System.out.println("Pass: Pagination is working in case of sort");
    }

    public int sortByTest(Select sortOpt, String value) throws InterruptedException {
        sortOpt.selectByValue(value);
        Thread.sleep(2000);
        int newPageNo=Integer.parseInt(currentPage.getText());
        if(newPageNo==1){ return 0;}else return 1;

    }

    public void testPaginationInCaseOfFilter(String url, String query) throws InterruptedException {
        goToWebsite(url);
        searchQuery(unbxdSearchQuery);
        forwardArrow.click();
        Thread.sleep(2000);
        UnbxdRangeFacet.click();
        applyButton.click();
        Thread.sleep(2000);
        int newPageNo=Integer.parseInt(currentPage.getText());
        Assert.assertEquals(newPageNo,1,"Fail: Pagination in case Of filter is not working");
        System.out.println("Pass: Pagination in case of filter is working");


    }

    public void testNumberOfItemsPerPageOption(String url, String query) throws InterruptedException {
        goToWebsite(url);
        searchQuery(query);
        Assert.assertEquals(unbxdPageSizeDropDown.isDisplayed(),true,"Fail: Pagination drop down is not getting displayed");
        Select pageSize=new Select(getDriver().findElement(By.xpath(unbxdPageSizeDropdown)));
        List<WebElement>allPageSizeOptions=pageSize.getOptions();
        System.out.println("Per page size options are");
        for(int i=0;i<allPageSizeOptions.size();i++)
            System.out.print("["+allPageSizeOptions.get(i).getText()+"]");
        System.out.println("");
    }


}

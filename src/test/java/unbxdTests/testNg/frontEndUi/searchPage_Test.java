package unbxdTests.testNg.frontEndUi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import core.ui.frontendui.actions.Search_SiteActions;
import lib.Helper;
import lib.UnbxdFileUtils;
import lib.annotation.FileToTest;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.*;
import unbxdTests.testNg.ui.BaseTest;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class searchPage_Test extends BaseTest {
    @Page
    Search_SiteActions search_SiteActions;
    static int NoOfProducts;
    public static ArrayList<String> array = new ArrayList<String>();

    @BeforeClass
    public void init() {
        super.setUp();
        initFluent(driver);
        initTest();
        maximizeWindow();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Search page functionality test ", dataProvider = "getUrl", priority = 1)
    public void testSearchBoxIsPresentOrNot(String url,String query)
    {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.searchBoxPresentOrNot();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Search box place holder is display or not", dataProvider = "getUrl", priority = 2)
    public void searchBoxPlaceHolderIsDisplayOrNot(String url,String query)
    {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.searchBoxPlaceHolderIsDisplayOrNot();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Search enter button in case of search", dataProvider = "getUrl", priority = 3)
    public void testEnterButtonInCaseOfSearch(String url,String query) throws InterruptedException {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testEnterButtonInCaseOfSearch(query);
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check for special characters are display fine or not", dataProvider = "getUrl", priority = 4)
    public void testCheckForSpecialCharactersAreDisplayedFine(String url,String query) throws InterruptedException {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.checkForSpecialCharactersAreDisplayedFine();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Spacing between two words", dataProvider = "getUrl", priority = 5)
    public void testSpacingBetweenTwoWordsIsWorkingOrNot(String url,String query) throws InterruptedException {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testSpacingBetweenTwoWords();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Spacing between more than two words", dataProvider = "getUrl", priority = 6)
    public void testSpacingBetweenMoreThanTwoWordsIsWorkingOrNot(String url,String query) throws InterruptedException {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testSpacingBetweenMoreThanTwoWords();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "All text in lower case", dataProvider = "getUrl", priority = 7)
    public void testAllTextInLowerCase(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testAllTextInLowerCase();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check searched results message format", dataProvider = "getUrl", priority = 8)
    public void testSearchedResultsMessageFormat(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testSearchedResultsMessageFormat();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check whether enter is working for search option", dataProvider = "getUrl", priority = 9)
    public void testWhetherEnterIsWorkingForSearchOption(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testWhetherEnterIsWorkingForSearchOption();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check combination of lower case and Upper case in searched box", dataProvider = "getUrl", priority = 10)
    public void testCombinationOfLowerCaseAndUpperCaseInSearchedBox(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testCombinationOfLowerCaseAndUpperCaseInSearchedBox();
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check stricken price is display or not", dataProvider = "getUrl", priority = 11)
    public void testStrickenPriceIsDisplayOrNot(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.strickenPriceIsDisplayOrNot();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check Grid view and list view are present or not", dataProvider = "getUrl", priority = 12)
    public void testGridViewAndListViewArePresentOrNot(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testGridViewAndListViewArePresentOrNot();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check list view click is working or not", dataProvider = "getUrl", priority = 13)
    public void testListViewClick(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testListViewClick();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check UI of list view page", dataProvider = "getUrl", priority = 14)
    public void testUIofListViewPage(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testUIofListViewPage();
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check Grid view click", dataProvider = "getUrl", priority = 15)
    public void testGridViewClick(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testGridViewClick();
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check UI of grid view page", dataProvider = "getUrl", priority = 16)
    public void testUIofGridViewPage(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testUIofGridViewPage();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check Filter selection in case of Grid view and move to List view page", dataProvider = "getUrl", priority = 17)
    public void testFilterSelectionInCaseOfGridViewAndMoveToListViewPage(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testFilterSelectionInCaseOfGridViewAndMoveToListViewPage();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check Filter selection in case of list view and move to Grid view page", dataProvider = "getUrl", priority = 18)
    public void testFilterSelectionInCaseOfListViewAndMoveToGridViewPage(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testFilterSelectionInCaseOfListViewAndMoveToGridViewPage();
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check number of products on Grid view and List view", dataProvider = "getUrl", priority = 19)
    public void testNumberOfProductsOnGridViewAndListView(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testNumberOfProductsOnGridViewAndListView();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check don't enter any query and click search icon", dataProvider = "getUrl", priority = 20)
    public void testDontEnterQueryClickSearchIcon(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.dontEnterQueryClickSearchIcon();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check don't enter any query and press the enter key", dataProvider = "getUrl", priority = 21)
    public void testDontEnterQueryPressEnterKey(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.dontEnterQueryPressEnterKey();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Search with blank space is working or not", dataProvider = "getUrl", priority = 22)
    public void testBlankSpaceInSearchedBox(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testBlankSpaceInSearchedBox();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Search using Unique Id is working or not", dataProvider = "getUrl", priority = 23)
    public void searchUsingUniqueId(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.searchUsingUniqueId();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check whether results are displaying as per the searched term in terms of color", dataProvider = "getUrl", priority = 24)
    public void testWhetherResultsAreDisplayingAsPerTheSearchedTerm_InTermsOfColor(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testWhetherResultsAreDisplayingAsPerTheSearchedTerm_InTermsOfColor();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Search for invalid query", dataProvider = "getUrl", priority = 25)
    public void testInvalidSearchQuery(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testInvalidSearchQuery(search_SiteActions.invalidQuery);
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check spell error message is display or not", dataProvider = "getUrl", priority = 26)
    public void spellErrorMessageIsDisplayOrNot(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.spellErrorMessageIsDisplayOrNot();
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check single word spell error is working or not", dataProvider = "getUrl", priority = 27)
    public void singleWordSpellErrorIsWorking(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.singleWordSpellErrorIsWorking();
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check whether two words spell error is working or not", dataProvider = "getUrl", priority = 28)
    public void testWhetherTwoWordsSpellErrorIsWorking(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testWhetherTwoWordsSpellErrorIsWorking();
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check whether three words spell error is working", dataProvider = "getUrl", priority = 29)
    public void testWhetherThreeWordsSpellErrorIsWorking(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testWhetherThreeWordsSpellErrorIsWorking();
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check did you mean link is working or not", dataProvider = "getUrl", priority = 30)
    public void testDidYouMeanLinkIsWorkingOrNot(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testDidYouMeanLinkIsWorkingOrNot();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check whether all the UI elements are loaded or not", dataProvider = "getUrl", priority = 31)
    public void testWhetherAllTheUiElementsAreLoadedOrNot(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testWhetherAllTheUiElementsAreLoadedOrNot();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check product attributes are displaying or not", dataProvider = "getUrl", priority = 32)
    public void checkProductAttributesAreDisplayingOrNot(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.checkProductAttributesAreDisplayingOrNot();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check in case of two prices", dataProvider = "getUrl", priority = 33)
    public void testInCaseOfTwoPrices(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testInCaseOfTwoPrices();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check whether price is displaying in two decimal format all over the site", dataProvider = "getUrl", priority = 34)
    public void testWhetherPriceIsDisplayingInTwoDecimalFormatAllOverTheSite(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.testWhetherPriceIsDisplayingInTwoDecimalFormatAllOverTheSite();
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(description = "Check total number of products in searched results page and API", dataProvider = "getUrl", priority = 35)
    public void checkTotalNumberOfProductsInSearchedResultsPageAndAPI(String url,String query) throws Exception {
        search_SiteActions.goToWebsite(url);
        search_SiteActions.checkTotalNumberOfProductsInSearchedResultsPageAndAPI();
    }


    private final String testFilePath = "target" + File.separator + "test-classes" + File.separator + "testData" + File.separator;

    @DataProvider(name = "getUrl")
    public Object[][] getUrls (Method m){
        Object[][] urls;
        String filePath = (m.getAnnotation(FileToTest.class)).value();
        String fileName = testFilePath + filePath;
        fileName = UnbxdFileUtils.normalizePath(fileName);

        JsonParser parser = new JsonParser();
        int count = 0;
        try {
            List<Object[]> testObjects = new ArrayList<>();
            Object obj = parser.parse(new FileReader(fileName));
            JsonObject object = (JsonObject) obj;
            JsonArray array = object.getAsJsonArray("testData");
            for (int i = 0; i < array.size(); i++){
                String url = array.get(i).getAsJsonObject().get("url").getAsString();
                JsonArray array1 = array.get(i).getAsJsonObject().get("queries").getAsJsonArray();
                for (int j = 0; j < array1.size(); j++) {
                    testObjects.add(new Object[]{url, array1.get(j).getAsString()});
                }
            }
            urls = new Object[testObjects.size()][];
            for (Object testObject : testObjects) {
                Object[] object2 = (Object[]) testObject;
                urls[count] = object2;
                count++;

            }

            return urls;
        }catch (Exception e) {
            e.printStackTrace();

        }
        return new Object[0][0];
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        Helper.tearDown();
    }

}

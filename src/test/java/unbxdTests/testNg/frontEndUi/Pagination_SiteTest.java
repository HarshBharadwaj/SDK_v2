package unbxdTests.testNg.frontEndUi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import core.ui.frontendui.actions.Pagination_Actions;
import core.ui.frontendui.actions.Sort_Actions;
import lib.Helper;
import lib.UnbxdFileUtils;
import lib.annotation.FileToTest;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unbxdTests.testNg.ui.BaseTest;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Pagination_SiteTest extends BaseTest {

    @Page
    Pagination_Actions pagination_actions;
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
    @Test(priority = 1, description = "Pagination is display or not", dataProvider = "getUrl")
    public void testPaginationIsDisplayOrNot(String url, String query) throws InterruptedException {
        pagination_actions.testPaginationIsDisplayingOrNot(url,query);
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 2,description = "Pagination is working or not", dataProvider = "getUrl")
    public void testPaginationIsWorkingOrNot(String url, String query) throws InterruptedException {
        pagination_actions.testPaginationIsWorkingOrNot(url,query);
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 3,description = "Pagination back arrow is working or not", dataProvider = "getUrl")
    public void testPaginationBackArrowIsWorkingOrNot(String url, String query) throws InterruptedException {
        pagination_actions.testPaginationBackArrowIsWorking(url,query);
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 4,description = "Pagination forward arrow is working or not", dataProvider = "getUrl")
    public void testPaginationForwardArrowIsWorkingOrNot(String url, String query) throws InterruptedException {
        pagination_actions.testPaginationForwardArrowIsWorking(url,query);
    }
    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 5,description = "Selected page is high lighted or not", dataProvider = "getUrl")
    public void testSlelectedPaginationIsHighlightedOrNot(String url, String query) throws InterruptedException {
        pagination_actions.testSelectedPageHighlightOrNot(url,query);
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 6,description = "Check pagination scenario in case of last page results", dataProvider = "getUrl")
    public void checkPaginationScenarioInCaseOfLastPageResults(String url, String query) throws InterruptedException {
        pagination_actions.testPaginationScenarioInCaseOfLastPageResults(url,query);
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 7,description = "Check pagination in case of sort.", dataProvider = "getUrl")
    public void checkPaginationInCaseOfSort(String url, String query) throws InterruptedException {
        pagination_actions.testPaginationInCaseOfSort(url,query);
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 8,description = "Check pagination in case of filter.", dataProvider = "getUrl")
    public void checkPaginationInCaseOfFilter(String url, String query) throws InterruptedException {
        pagination_actions.testPaginationInCaseOfFilter(url,query);
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 9,description = "Check number of items per page option.", dataProvider = "getUrl")
    public void checkNumberOfItemsPerPageOption(String url, String query) throws InterruptedException {
        pagination_actions.testNumberOfItemsPerPageOption(url,query);
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 10,description = "Check number of items per page option working or not.", dataProvider = "getUrl")
    public void checkNumberOfItemsPerPageOptionWorkingOrNot(String url, String query) throws InterruptedException {
        pagination_actions.testNumberOfItemsPerPageOptionWorkingOrNot(url,query);
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 11,description = "Check selected page option is showing as highlighted or not.", dataProvider = "getUrl")
    public void checkSelectedPageOptionIsShowingAsHighlighted(String url, String query) throws InterruptedException {
        pagination_actions.testSelectedPageOptionIsShowingAsHighlighted(url,query);
    }

    @FileToTest(value = "/frontEndTestData/SanitySearchUrl.json")
    @Test(priority = 12,description = "Check footer displaying pagination option or not.", dataProvider = "getUrl")
    public void checkFooterDisplayingPaginationOptionOrNot(String url, String query) throws InterruptedException {
        pagination_actions.testFooterDisplayingPaginationOptionOrNot(url,query);
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

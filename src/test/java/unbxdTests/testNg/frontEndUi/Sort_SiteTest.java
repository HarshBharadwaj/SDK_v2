package unbxdTests.testNg.frontEndUi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import core.ui.frontendui.actions.Search_SiteActions;
import core.ui.frontendui.actions.Sort_Actions;
import core.ui.frontendui.page.Sort_Page;
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

public class Sort_SiteTest extends BaseTest {
    @Page
    Sort_Actions sort_actions;
    static int NoOfProducts;
    public static ArrayList<String> array = new ArrayList<String>();

    @BeforeClass
    public void init() {
        super.setUp();
        initFluent(driver);
        initTest();
    }

  

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        Helper.tearDown();
    }

}

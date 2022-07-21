package TestRunner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utils.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TC_Execel_Dependency {
    TestRunner runner = new TestRunner();

    @Test
    public void getData() throws IOException {
        Map<String, List<String>> FeaturesFile = new HashMap<>();
        List<String> RegressionTest = new ArrayList<>();
        ArrayList<String> SmokeTest = new ArrayList<>();
        List<String> SanityTest = new ArrayList<>();
        String path = System.getProperty("user.dir") + "/src/main/java/TestData/LoginData.xlsx";
        int rownum = XLUtils.getRowCount(path, "Sheet1");


        for (int i = 1; i <= rownum; i++) {

            String flag = XLUtils.getCellData(path, "Sheet1", i, 2);
            String TestType = XLUtils.getCellData(path, "Sheet1", i, 0);
            if (flag.equals("Yes")) {
                if (TestType.equals("RegressionTest")) {
                    RegressionTest.add("classpath:Features/" + XLUtils.getCellData(path, "Sheet1", i, 1)+".feature");
                } else if (TestType.equals("SmokeTest")) {
                    SmokeTest.add("classpath:Features/" + XLUtils.getCellData(path, "Sheet1", i, 1)+".feature");
                } else if (TestType.equals("SanityTest")) {
                    SanityTest.add("classpath:Features/" + XLUtils.getCellData(path, "Sheet1", i, 1)+".feature");
                }
            }
        }
        FeaturesFile.put("Regression", RegressionTest);
        FeaturesFile.put("Smoke", SmokeTest);
        FeaturesFile.put("Sanity", SanityTest);
        for (Map.Entry<String, List<String>> entry : FeaturesFile.entrySet()) {
            if (entry.getKey() == "Regression")
                runner.runTest((ArrayList<String>) RegressionTest, "@RegressionTest");
            else if (entry.getKey() == "Smoke")
                runner.runTest(SmokeTest, "@SmokeTest");
            else if (entry.getKey() == "Sanity")
                runner.runTest((ArrayList<String>) SanityTest, "@SanityTest");
            }
        }
    }
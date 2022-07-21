package TestRunner;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestRunner {

public void runTest(ArrayList<String> FeaturesFile, String TestType)
{
    Results results= Runner.path(FeaturesFile).outputCucumberJson(true).tags(TestType).parallel(1);
    generateReport(results.getReportDir(), TestType);
    assertEquals(0, results.getFailCount(), results.getErrorMessages());
}

    public static void generateReport(String karateOutputPath, String tag) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        final List<String> jsonPaths = new ArrayList<String>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("Report/Karate_Cucumber_HTML_Report_"+ getTime() + "_"+ tag), tag);
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
    public static String getTime()
    {
    	DateFormat dateFormat = new SimpleDateFormat("YYYMMdd_HHmmss");
		Date date = new Date();
		String s = dateFormat.format(date);
		return s;
    }
}

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class TestRunner {
  @Test
    public void testParallel() {
        System.out.println("Started");
        Results results = Runner.path("classpath:Features/").outputCucumberJson(true).parallel(9);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
        generateReport(results.getReportDir());
    }
    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        final List<String> jsonPaths = new ArrayList<String>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("Report/Karate_Cucumber_HTML_Report_" + getTime()), "dummy");
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

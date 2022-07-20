package TestRunner;
import java.io.IOException;

import Utils.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_Execel_Dependency {
    TestRunner runner = new TestRunner();
    @Test(dataProvider="LoginData")
    public void loginDDT(String Features_name ,String Test_type, String flag) throws InterruptedException
    {
        if (flag.equals("Yes"))
        {
            String Tag = "@" + Test_type;
            runner.testParallel(Features_name, Tag);
        }

    }


    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/main/java/TestData/LoginData.xlsx";
        int rownum=XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);
        String logindata[][]=new String[rownum][colcount];
        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]= XLUtils.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }

}

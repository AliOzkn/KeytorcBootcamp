package ReportComponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static TestComponents.DriverSetup.driver;

public class GetScreenshot {

    public void failedScreenshot(String testMethodName) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir") + "//screenshots//" + testMethodName + ".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

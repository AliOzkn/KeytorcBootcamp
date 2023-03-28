package ReportComponents;
import org.testng.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class TestNGListener extends GetScreenshot implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        log.info(context.getName() + " Web Automation Test Started.");
    }
    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getName() + " STARTED");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getName() + " PASSED");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        log.info(result.getName() + " FAILED");
        try {
            failedScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(result.getName() + " SKIPPED");
    }
    @Override
    public void onFinish(ITestContext context) {
        log.info(context.getName() + " FINISHED");
    }
}

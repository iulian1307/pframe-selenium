package com.qaitsolutions.pframe.selenium.testng;

import com.qaitsolutions.pframe.core.testng.FrameworkListener;
import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.actions.browser.BrowserActionsImpl;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;

public class PFrameSeleniumListener extends FrameworkListener {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Throwable e = iTestResult.getThrowable();

        if (e instanceof WebDriverException) {
            Log.fail(e.getMessage(), e);
            new BrowserActionsImpl().takeScreenshot();
        } else if (e != null && !(e instanceof AssertionError)) {
            Log.fail("Test failed unexpectedly", e);
        }

        Log.info("Test [%s] failed", super.currentNodeName);
    }
}

package com.qaitsolutions.pframe.selenium.actions.browser;

import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.actions.global.JsExecutorImpl;
import com.qaitsolutions.pframe.selenium.driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class BrowserActionsImpl implements BrowserActions {

    @Override
    public void closeWindow() {
        Log.debug("Closing current browser window");
        Driver.getDriver().close();
    }

    @Override
    public String getPageTitle() {
        Log.debug("Retrieving page title");
        return Driver.getDriver().getTitle();
    }

    @Override
    public String getCurrentUrl() {
        Log.debug("Retrieving current url");
        return Driver.getDriver().getCurrentUrl();
    }

    @Override
    public String getPageSource() {
        Log.debug("Retrieving page source");
        return Driver.getDriver().getPageSource();

    }

    @Override
    public void scrollToBottom() {
        Log.debug("Scrolling to bottom of the page using JS");
        new JsExecutorImpl().execute("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Override
    public void scrollToTop() {
        Log.debug("Scrolling to top of the page using JS");
        new JsExecutorImpl().execute("window.scrollTo(0, -document.body.scrollHeight)");
    }


    @Override
    public void takeScreenshot() {
        Log.debug("Capturing page screenshot");

        var base64Screenshot = ((TakesScreenshot) Driver.getDriver())
                .getScreenshotAs(OutputType.BASE64);

        Log.infoWithScreenshotByBase64String(
                "Page Screenshot attached",
                base64Screenshot
        );
    }

    @Override
    public void pause(int seconds) {
        Log.debug("Waiting for " + seconds + " seconds");

        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Log.warn("Exception thrown for Thread.sleep");
        }
    }

    @Override
    public NavigateActions navigate() {
        return new NavigateActionsImpl();
    }

    @Override
    public AlertActions alert() {
        return new AlertActionsImpl();
    }

    @Override
    public FrameActions frameOrWindow() {
        return new FrameActionsImpl();
    }

    @Override
    public GlobalWaitActions waitUntil() {
        return new GlobalWaitActionsImpl();
    }
}

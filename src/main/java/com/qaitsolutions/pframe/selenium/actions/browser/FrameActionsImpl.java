package com.qaitsolutions.pframe.selenium.actions.browser;

import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public final class FrameActionsImpl implements FrameActions {

    @Override
    public void switchToFrame(int index) {
        Log.debug("Switching to frame with index [%s]", index);
        Driver.getDriver().switchTo().frame(index);
    }

    @Override
    public void switchToFrame(String nameOrId) {
        Log.debug("Switching to frame with name/id [%s]", nameOrId);
        Driver.getDriver().switchTo().frame(nameOrId);
    }

    @Override
    public void switchToFrame(WebElement element) {
        Log.debug("Switching to frame [%s]", element.toString());
        Driver.getDriver().switchTo().frame(element);
    }

    @Override
    public void switchToParentFrame() {
        Log.debug("Switching to parent frame");
        Driver.getDriver().switchTo().parentFrame();
    }

    @Override
    public void switchToDefaultContext() {
        Log.debug("Switching to default context");
        Driver.getDriver().switchTo().defaultContent();
    }

    @Override
    public void switchToWindow(int index) {
        Log.debug("Switching to window with index [%s]", index);
        var windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(index));
    }

    @Override
    public void switchToWindow(int index, int seconds) {
        Log.debug("Switching to window with index [%s]", index);

        var windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> d.switchTo().window(windowHandles.get(index)));

        Driver.getDriver().switchTo().window("");
    }

    @Override
    public void switchToWindow(String nameOrHandle) {
        Log.debug("Switching to window with name/handle [%s]", nameOrHandle);
        Driver.getDriver().switchTo().window(nameOrHandle);
    }

    @Override
    public void switchToWindow(String nameOrHandle, int seconds) {
        Log.debug("Switching to window with name/handle [%s]", nameOrHandle);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> d.switchTo().window(nameOrHandle));
    }

    @Override
    public List<WebElement> getIFrames() {
        Log.debug("Retrieving IFrames");
        return Driver.getDriver().findElements(By.tagName("iframe"));
    }

    @Override
    public List<String> getWindowsHandles() {
        Log.debug("Retrieving Windows Handles");
        return new ArrayList<>(Driver.getDriver().getWindowHandles());
    }
}

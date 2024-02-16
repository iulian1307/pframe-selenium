package com.qaitsolutions.pframe.selenium.actions.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.WebDriver.TargetLocator;

public interface FrameActions {

    /**
     * @see TargetLocator#frame(int)
     */
    void switchToFrame(int index);

    /**
     * @see TargetLocator#frame(String)
     */
    void switchToFrame(String nameOrId);

    /**
     * @see TargetLocator#frame(WebElement)
     */
    void switchToFrame(WebElement element);

    /**
     * @see TargetLocator#parentFrame()
     */
    void switchToParentFrame();

    /**
     * @see TargetLocator#defaultContent()
     */
    void switchToDefaultContext();

    /**
     * @see TargetLocator#window(String)
     */
    void switchToWindow(int index);

    /**
     * @see TargetLocator#window(String)
     */
    void switchToWindow(int index, int seconds);

    /**
     * @see TargetLocator#window(String)
     */
    void switchToWindow(String nameOrHandle);

    /**
     * @see TargetLocator#window(String)
     */
    void switchToWindow(String nameOrHandle, int seconds);

    List<WebElement> getIFrames();

    /**
     * @see WebDriver#getWindowHandles()
     */
    List<String> getWindowsHandles();
}

package com.qaitsolutions.pframe.selenium.actions.browser;

import org.openqa.selenium.WebDriver;

public interface BrowserActions {

    /**
     * @see WebDriver#close()
     */
    void closeWindow();

    /**
     * @see WebDriver#getPageSource()
     */
    String getPageSource();

    /**
     * Scrolls to the bottom of the page
     */
    void scrollToBottom();

    /**
     * Scrolls to the top of the page
     */
    void scrollToTop();

    /**
     * @see WebDriver#getCurrentUrl()
     */
    String getCurrentUrl();

    /**
     * Captures screenshot in browser and attaches it to report
     */
    void takeScreenshot();

    /**
     * Wait that makes the program stop for given amount of seconds
     *
     * @param seconds The time that the program will stop
     * @see Thread#sleep(long)
     */
    void pause(int seconds);

    /**
     * @see WebDriver#getTitle()
     */
    String getPageTitle();

    NavigateActions navigate();

    AlertActions alert();

    FrameActions frameOrWindow();

    GlobalWaitActions waitUntil();
}

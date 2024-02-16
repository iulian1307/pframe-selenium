package com.qaitsolutions.pframe.selenium.actions.browser;

import org.openqa.selenium.WebDriver;

import java.net.URL;

public interface NavigateActions {

    /**
     * @see WebDriver.Navigation#to(String)()
     */
    void navigateTo(String url);

    /**
     * @see WebDriver.Navigation#to(URL)()
     */
    void navigateTo(URL url);

    /**
     * @see WebDriver.Navigation#back()
     */
    void back();

    /**
     * @see WebDriver.Navigation#forward()
     */
    void forward();

    /**
     * @see WebDriver.Navigation#refresh()
     */
    void refresh();

}

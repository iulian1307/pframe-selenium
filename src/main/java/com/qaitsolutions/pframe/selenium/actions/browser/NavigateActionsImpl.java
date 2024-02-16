package com.qaitsolutions.pframe.selenium.actions.browser;

import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.driver.Driver;

import java.net.URL;

public class NavigateActionsImpl implements NavigateActions {

    @Override
    public void navigateTo(String url) {
        Log.info("Navigating to " + url);
        Driver.getDriver().navigate().to(url);
    }

    @Override
    public void navigateTo(URL url) {
        Log.info("Navigating to " + url);
        Driver.getDriver().navigate().to(url);
    }

    @Override
    public void back() {
        Log.info("Navigating back to page");
        Driver.getDriver().navigate().back();
    }

    @Override
    public void forward() {
        Log.info("Navigating forward to page");
        Driver.getDriver().navigate().forward();
    }

    @Override
    public void refresh() {
        Log.info("Refreshing current page");
        Driver.getDriver().navigate().refresh();
    }
}

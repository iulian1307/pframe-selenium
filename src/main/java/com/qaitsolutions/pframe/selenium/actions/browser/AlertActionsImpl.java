package com.qaitsolutions.pframe.selenium.actions.browser;

import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.driver.Driver;

public final class AlertActionsImpl implements AlertActions {

    @Override
    public void dismiss() {
        Log.debug("Dismissing alert if present");
        Driver.getDriver().switchTo().alert().dismiss();
    }

    @Override
    public void accept() {
        Log.debug("Accepting alert if present");
        Driver.getDriver().switchTo().alert().accept();
    }

    @Override
    public void accept(final String keys) {
        Log.info("Accepting alert after sending [%s] keys", keys);

        var alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(keys);
        alert.accept();
    }

    @Override
    public void getAlertText() {
        Log.debug("Getting text from alert");
        Driver.getDriver().switchTo().alert().getText();
    }

    @Override
    public void sendAlertKeys(String keys) {
        Log.debug("Sending keys [%s] to alert", keys);
        Driver.getDriver().switchTo().alert().sendKeys(keys);
    }
}

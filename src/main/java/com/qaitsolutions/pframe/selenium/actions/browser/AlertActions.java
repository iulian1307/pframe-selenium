package com.qaitsolutions.pframe.selenium.actions.browser;

import org.openqa.selenium.Alert;

public interface AlertActions {

    /**
     * @see Alert#dismiss()
     */
    void dismiss();

    /**
     * @see Alert#accept()
     */
    void accept();

    /**
     * @see Alert#sendKeys(String)
     * @see Alert#accept()
     */
    void accept(String keys);

    /**
     * @see Alert#getText()
     */
    void getAlertText();

    /**
     * @see Alert#sendKeys(String)()
     */
    void sendAlertKeys(String keys);
}

package com.qaitsolutions.pframe.selenium.exceptions;


import com.qaitsolutions.pframe.core.exceptions.FrameworkException;

import static com.qaitsolutions.pframe.selenium.Selenium.browser;

/**
 * Selenium specific exception that take a snapshot when thrown. It will not function outside the Selenium context.
 */
public class SeleniumException extends FrameworkException {

    public SeleniumException(String message) {
        super(message);
        browser().takeScreenshot();
    }

    public SeleniumException(String message, Throwable cause) {
        super(message, cause);
        browser().takeScreenshot();
    }

    public SeleniumException(Throwable cause) {
        super(cause);
        browser().takeScreenshot();
    }
}

package com.qaitsolutions.pframe.selenium;

import com.qaitsolutions.pframe.selenium.actions.browser.BrowserActions;
import com.qaitsolutions.pframe.selenium.actions.browser.BrowserActionsImpl;
import com.qaitsolutions.pframe.selenium.actions.element.ElementActions;
import com.qaitsolutions.pframe.selenium.actions.element.ElementActionsImpl;
import com.qaitsolutions.pframe.selenium.actions.elements.ElementsActions;
import com.qaitsolutions.pframe.selenium.actions.elements.ElementsActionsImpl;
import com.qaitsolutions.pframe.selenium.actions.global.CompositeActions;
import com.qaitsolutions.pframe.selenium.actions.global.CompositeActionsImpl;
import com.qaitsolutions.pframe.selenium.driver.DriverBuilder;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Selenium wrapper entry point
 */
public class Selenium {

    @Getter
    private final CompositeActions compositeActions = new CompositeActionsImpl();

    /**
     * @return {@link DriverBuilder}
     */
    public static DriverBuilder configureDriver() {
        return new DriverBuilder();
    }

    /**
     * @return {@link BrowserActions}
     */
    public static BrowserActions browser() {
        return new BrowserActionsImpl();
    }

    /**
     * @param by element to do an action on
     * @return {@link ElementActions}
     */
    public static ElementActions element(By by) {
        final var actions = new ElementActionsImpl();
        actions.setLocator(by);

        return actions;
    }

    /**
     * @param element Element to do an action on
     * @return {@link ElementActions}
     */
    public static ElementActions element(WebElement element) {
        final var actions = new ElementActionsImpl();

        actions.setElement(element);
        return actions;
    }

    /**
     * @see WebDriver#findElements(By)
     */
    public static ElementsActions elements() {
        return new ElementsActionsImpl();
    }
}
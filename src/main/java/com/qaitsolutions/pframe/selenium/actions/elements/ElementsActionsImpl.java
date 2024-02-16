package com.qaitsolutions.pframe.selenium.actions.elements;

import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.config.Config;
import com.qaitsolutions.pframe.selenium.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class ElementsActionsImpl implements ElementsActions, ElementsWaitActions {

    @Override
    public List<WebElement> findElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    @Override
    public ElementsActions waitUntilInvisibilityOfAllElements(List<WebElement> elements, int seconds) {
        Log.debug("Waiting %s seconds for elements to be invisible", seconds);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.invisibilityOfAllElements(elements));

        return this;
    }

    @Override
    public ElementsActions waitUntilInvisibilityOfAllElements(List<WebElement> elements) {
        return waitUntilInvisibilityOfAllElements(elements, Config.getDefaultWait());
    }

    @Override
    public List<WebElement> waitUntilVisibilityOfAllElements(List<WebElement> elements, int seconds) {
        Log.debug("Waiting %s seconds for elements to be visible", seconds);

        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    @Override
    public List<WebElement> waitUntilVisibilityOfAllElements(List<WebElement> elements) {
        return waitUntilVisibilityOfAllElements(elements, Config.getDefaultWait());
    }

    @Override
    public List<WebElement> waitUntilVisibilityOfAllElementsLocatedBy(By locator, int seconds) {
        Log.debug("Waiting %s seconds for elements to be visible", seconds);

        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    @Override
    public List<WebElement> waitUntilVisibilityOfAllElementsLocatedBy(By locator) {
        return waitUntilVisibilityOfAllElementsLocatedBy(locator, Config.getDefaultWait());
    }

    @Override
    public List<WebElement> waitUntilNumberOfElementsToBe(By locator, int expected, int seconds) {
        Log.debug("Waiting %s seconds for number of elements to be [%s]", seconds, expected);

        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.numberOfElementsToBe(locator, expected));
    }

    @Override
    public List<WebElement> waitUntilNumberOfElementsToBe(By locator, int expected) {
        return waitUntilNumberOfElementsToBe(locator, expected, Config.getDefaultWait());
    }

    @Override
    public List<WebElement> waitUntilNumberOfElementsToBeMoreThan(By locator, int number, int seconds) {
        Log.debug("Waiting %s seconds for number of elements to be more than [%s]", seconds, number);

        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
    }

    @Override
    public List<WebElement> waitUntilNumberOfElementsToBeMoreThan(By locator, int number) {
        return waitUntilNumberOfElementsToBeMoreThan(locator, number, Config.getDefaultWait());
    }

    @Override
    public List<WebElement> waitUntilNumberOfElementsToBeLessThan(By locator, int number, int seconds) {
        Log.debug("Waiting %s seconds for number of elements to be less than [%s]", seconds, number);

        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.numberOfElementsToBeLessThan(locator, number));
    }

    @Override
    public List<WebElement> waitUntilNumberOfElementsToBeLessThan(By locator, int number) {
        return waitUntilNumberOfElementsToBeLessThan(locator, number, Config.getDefaultWait());
    }
}

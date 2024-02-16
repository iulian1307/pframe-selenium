package com.qaitsolutions.pframe.selenium.actions.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ElementsWaitActions {

    ElementsActions waitUntilInvisibilityOfAllElements(List<WebElement> elements, int seconds);

    ElementsActions waitUntilInvisibilityOfAllElements(List<WebElement> elements);

    List<WebElement> waitUntilVisibilityOfAllElements(List<WebElement> elements, int seconds);

    List<WebElement> waitUntilVisibilityOfAllElements(List<WebElement> elements);

    List<WebElement> waitUntilVisibilityOfAllElementsLocatedBy(By locator, int seconds);

    List<WebElement> waitUntilVisibilityOfAllElementsLocatedBy(By locator);

    List<WebElement> waitUntilNumberOfElementsToBe(By locator, int expected, int seconds);

    List<WebElement> waitUntilNumberOfElementsToBe(By locator, int expected);

    List<WebElement> waitUntilNumberOfElementsToBeMoreThan(By locator, int number, int seconds);

    List<WebElement> waitUntilNumberOfElementsToBeMoreThan(By locator, int number);

    List<WebElement> waitUntilNumberOfElementsToBeLessThan(By locator, int number, int seconds);

    List<WebElement> waitUntilNumberOfElementsToBeLessThan(By locator, int number);
}

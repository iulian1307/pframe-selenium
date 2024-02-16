package com.qaitsolutions.pframe.selenium.actions.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ElementsActions {

    List<WebElement> findElements(By locator);
}

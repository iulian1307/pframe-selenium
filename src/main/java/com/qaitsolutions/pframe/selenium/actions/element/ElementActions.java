package com.qaitsolutions.pframe.selenium.actions.element;

import com.qaitsolutions.pframe.selenium.actions.elements.ElementsWaitActions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.SearchContext;

public interface ElementActions extends ElementWaitActions {

    ElementActions click();
    ElementActions contextClick();
    ElementActions doubleClick();
    ElementActions hover();
    ElementActions submit();
    ElementActions sendKeys(CharSequence... keysToSend);
    ElementActions sendKeysHidden(CharSequence... keysToSend);
    ElementActions clear();
    ElementActions clearOneByOne();

    void selectOptionByText(String text);
    void selectOptionByValue(String value);
    void selectOptionByIndex(int index);
    void deselectOptionByText(String text);
    void deselectOptionByValue(String value);
    void deselectOptionByIndex(int index);
    void deselectAllOptionByIndex();

    ElementActions pressEnter();
    ElementActions pressTab();
    ElementActions pressEscape();
    ElementActions takeScreenshot();

    String getInnerText();
    String getInnerHtml();
    String getName();
    String getValue();
    String getTagName();
    String getDomProperty(String name);
    String getDomAttribute(String name);
    String getAttribute(String name);
    String getAriaRole();
    String getAccessibleName();
    String getText();
    String getCssValue(String propertyName);

    boolean isSelected();
    boolean isEnabled();
    boolean isDisplayed();


    SearchContext getShadowRoot();
    Point getLocation();
    Dimension getSize();
    Rectangle getRect();


    JsElementActions js();
}

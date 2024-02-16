package com.qaitsolutions.pframe.selenium.actions.conditions;

import com.qaitsolutions.pframe.selenium.actions.global.JsExecutorImpl;
import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface ElementCondition {

    ElementCondition INVISIBLE = element -> !element.isDisplayed();
    ElementCondition VISIBLE = WebElement::isDisplayed;

    ElementCondition CLICKABLE = element -> ElementCondition.VISIBLE.apply(element) && ElementCondition.ENABLED.apply(element);

    ElementCondition READ_ONLY = element -> element.getAttribute("readonly") != null;

    ElementCondition FOCUSED = element -> {
        var focusedElement = (WebElement) new JsExecutorImpl().execute("return document.activeElement");
        return focusedElement != null && focusedElement.equals(element);
    };

    ElementCondition ENABLED = WebElement::isEnabled;

    ElementCondition DISABLED = element -> !element.isEnabled();

    ElementCondition SELECTED = WebElement::isSelected;

    ElementCondition NOT_SELECTED = element -> !element.isSelected();

    ElementCondition INTERACTABLE = element -> ElementCondition.VISIBLE.apply(element)
            || element.getAttribute("opacity").equals("0");

    ElementCondition EDITABLE = element -> ElementCondition.INTERACTABLE.apply(element) && !ElementCondition.READ_ONLY.apply(element);

    boolean apply(WebElement element);
}

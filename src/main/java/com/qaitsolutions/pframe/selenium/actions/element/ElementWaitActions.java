package com.qaitsolutions.pframe.selenium.actions.element;

import com.qaitsolutions.pframe.selenium.actions.conditions.ElementCondition;
import com.qaitsolutions.pframe.selenium.actions.elements.ElementsActions;

public interface ElementWaitActions {

    boolean is(ElementCondition condition, int seconds);
    boolean is(ElementCondition condition);

    ElementActions waitUntilClickable(int seconds);
    ElementActions waitUntilClickable();

    ElementActions waitUntilVisible(int seconds);
    ElementActions waitUntilVisible();

    ElementActions waitUntilHidden(int seconds);
    ElementActions waitUntilHidden();

    ElementActions waitUntilReadOnly(int seconds);
    ElementActions waitUntilReadOnly();

    ElementActions waitUntilFocused(int seconds);
    ElementActions waitUntilFocused();

    ElementActions waitUntilEnabled(int seconds);
    ElementActions waitUntilEnabled();

    ElementActions waitUntilDisabled(int seconds);
    ElementActions waitUntilDisabled();

    ElementActions waitUntilSelected(int seconds);
    ElementActions waitUntilSelected();

    ElementActions waitUntilInteractable(int seconds);
    ElementActions waitUntilInteractable();

    ElementActions waitUntilEditable(int seconds);
    ElementActions waitUntilEditable();

    ElementActions waitUntilUnselected(int seconds);
    ElementActions waitUntilUnselected();

    ElementActions waitUntil(ElementCondition condition, int seconds);

    ElementActions waitUntilAttributeIs(String attribute, String value, int seconds);
    ElementActions waitUntilAttributeIs(String attribute, String value);

    ElementActions waitUntilAttributeIsNotEmpty(String attribute, int seconds);
    ElementActions waitUntilAttributeIsNotEmpty(String attribute);

    ElementActions waitUntilAttributeContains(String attribute, String value, int seconds);
    ElementActions waitUntilAttributeContains(String attribute, String value);

    ElementActions waitUntilTextIs(String text, int seconds);
    ElementActions waitUntilTextIs(String text);

    ElementActions waitUntilValueIs(String value, int seconds);
    ElementActions waitUntilValueIs(String value);
}

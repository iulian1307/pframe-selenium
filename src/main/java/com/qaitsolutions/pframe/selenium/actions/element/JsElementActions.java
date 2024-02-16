package com.qaitsolutions.pframe.selenium.actions.element;

public interface JsElementActions {
    void click();

    void sendKeys(String keysToSend);

    void sendKeysHidden(String keysToSend);

    void clear();

    void scrollIntoViewCentered();

    void scrollIntoViewAtTop();

    void scrollIntoViewAtBottom();

    void scrollIntoView(String option);

    void hover();
}

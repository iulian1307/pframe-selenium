package com.qaitsolutions.pframe.selenium.actions.element;

import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.actions.global.JsExecutor;
import com.qaitsolutions.pframe.selenium.actions.global.JsExecutorImpl;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
public final class JsElementActionsImpl implements JsElementActions {

    private WebElement element;
    private String elementName;

    private final JsExecutor js = new JsExecutorImpl();

    @Override
    public void click() {
        Log.info("Clicking on [%s] using JS", elementName);
        js.execute("arguments[0].click();", element);
    }

    @Override
    public void sendKeys(String keysToSend) {
        Log.info("Sending keys [%s] to field [%s] using JS", keysToSend, elementName);
        js.execute(String.format("arguments[0].setAttribute('value', '%s')", keysToSend), element);
    }

    @Override
    public void sendKeysHidden(String keysToSend) {
        Log.info("Sending keys [****] to field [%s] using JS", elementName);
        js.execute("arguments[0].setAttribute('value', '" + keysToSend + "')", element);
    }

    @Override
    public void clear() {
        Log.info("Clearing field [%s]", elementName);
        js.execute("arguments[0].value = '';", elementName);
    }

    @Override
    public void scrollIntoViewCentered() {
        String centerOption = "{block: \"center\"}";
        this.scrollIntoView(centerOption);
    }

    @Override
    public void scrollIntoViewAtTop() {
        String startOption = "{block: \"start\"}";
        this.scrollIntoView(startOption);
    }

    @Override
    public void scrollIntoViewAtBottom() {
        String endOption = "{block: \"end\"}";
        this.scrollIntoView(endOption);
    }

    @Override
    public void scrollIntoView(String option) {
        Log.debug("Scrolling to [%s] using JS", elementName);
        js.execute(String.format("arguments[0].scrollIntoView(%s)", option), element);
    }

    @Override
    public void hover() {
        String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');" +
                "evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} " +
                "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";

        Log.info("Hover on [%s] using JS", elementName);
        js.execute(mouseOverScript, element);
    }
}

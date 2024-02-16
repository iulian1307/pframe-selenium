package com.qaitsolutions.pframe.selenium.actions.global;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Wrapper over selenium actions
 */
public interface CompositeActions {

    /**
     * Performs a modifier key press. Does not release the modifier key - subsequent interactions may assume
     * it's kept pressed.
     *
     * @see Actions#keyDown(CharSequence)
     */
    CompositeActions keyDown(CharSequence key);

    /**
     * Performs a modifier key release. Releasing a non-depressed modifier key will yield undefined behaviour.
     *
     * @see Actions#keyUp(CharSequence)
     */
    CompositeActions keyUp(CharSequence key);

    /**
     * Sends keys to the active element. This differs from calling WebElement.sendKeys(CharSequence...) on the
     * active element in two ways:
     * - The modifier keys included in this call are not released.
     * - There is no attempt to re-focus the element - so sendKeys(Keys.TAB) for switching elements should work.
     *
     * @see Actions#sendKeys(CharSequence...)
     */
    CompositeActions sendKeys(CharSequence... key);

    /**
     * Sends keys to the target element
     *
     * @see Actions#sendKeys(WebElement, CharSequence...)
     */
    CompositeActions sendKeys(WebElement target, CharSequence... key);

    /**
     * Clicks (without releasing) in the middle of the given element
     *
     * @see Actions#clickAndHold(WebElement)
     */
    CompositeActions clickAndHold(WebElement target);

    /**
     * Clicks (without releasing) at the current mouse location.
     *
     * @see Actions#clickAndHold()
     */
    CompositeActions clickAndHold();

    /**
     * Releases the depressed left mouse button, in the middle of the given element
     *
     * @see Actions#release(WebElement)
     */
    CompositeActions release(WebElement target);

    /**
     * Releases the depressed left mouse button at the current mouse location.
     *
     * @see Actions#release()
     */
    CompositeActions release();

    /**
     * If the element is outside the viewport, scrolls the bottom of the element to the bottom of the viewport.
     *
     * @see Actions#scrollToElement(WebElement)
     */
    CompositeActions scrollToElement(WebElement target);

    /**
     * Clicks in the middle of the given element
     *
     * @see Actions#click(WebElement)
     */
    CompositeActions click(WebElement target);

    /**
     * Clicks at the current mouse location
     *
     * @see Actions#click()
     */
    CompositeActions click();

    /**
     * Performs a double-click at middle of the given element
     *
     * @see Actions#doubleClick(WebElement)
     */
    CompositeActions doubleClick(WebElement target);

    /**
     * Performs a double-click at the current mouse location.
     *
     * @see Actions#doubleClick()
     */
    CompositeActions doubleClick();

    /**
     * Moves the mouse to the middle of the element. The element is scrolled into view and its location is
     * calculated using getClientRects.
     *
     * @see Actions#moveToElement(WebElement)
     */
    CompositeActions moveToElement(WebElement target);

    /**
     * Performs a context-click at middle of the given element. First performs a mouseMove to the location
     * of the element.
     *
     * @see Actions#contextClick(WebElement)
     */
    CompositeActions contextClick(WebElement target);

    /**
     * Performs a context-click at the current mouse location.
     *
     * @see Actions#contextClick()
     */
    CompositeActions contextClick();

    /**
     * A convenience method that performs click-and-hold at the location of the source element, moves to the
     * location of the target element, then releases the mouse.
     *
     * @see Actions#dragAndDrop(WebElement, WebElement)
     */
    CompositeActions dragAndDrop(WebElement source, WebElement target);

    /**
     * A convenience method that performs click-and-hold at the location of the source element, moves by a
     * given offset, then releases the mouse.
     *
     * @see Actions#dragAndDropBy(WebElement, int, int)
     */
    CompositeActions dragAndDropBy(WebElement source, int xOffset, int yOffset);

    /**
     * Executes the action/s
     *
     * @see Actions#perform()
     */
    CompositeActions perform();
}

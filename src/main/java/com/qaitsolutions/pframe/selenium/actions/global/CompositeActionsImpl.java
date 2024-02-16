package com.qaitsolutions.pframe.selenium.actions.global;

import com.qaitsolutions.pframe.selenium.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public final class CompositeActionsImpl implements CompositeActions {

    private final Actions actions = new Actions(Driver.getDriver());

    @Override
    public CompositeActions keyDown(CharSequence key) {
        actions.keyDown(key);
        return this;
    }

    @Override
    public CompositeActions keyUp(CharSequence key) {
        actions.keyUp(key);
        return this;
    }

    @Override
    public CompositeActions sendKeys(CharSequence... key) {
        actions.sendKeys(key);
        return this;
    }

    @Override
    public CompositeActions sendKeys(WebElement target, CharSequence... key) {
        actions.sendKeys(target, key);
        return this;
    }

    @Override
    public CompositeActions clickAndHold(WebElement target) {
        actions.clickAndHold(target);
        return this;
    }

    @Override
    public CompositeActions clickAndHold() {
        actions.clickAndHold();
        return this;
    }

    @Override
    public CompositeActions release(WebElement target) {
        actions.release(target);
        return this;
    }

    @Override
    public CompositeActions release() {
        actions.release();
        return this;
    }

    @Override
    public CompositeActions scrollToElement(WebElement target) {
        actions.scrollToElement(target);
        return this;
    }

    @Override
    public CompositeActions click(WebElement target) {
        actions.click(target);
        return this;
    }

    @Override
    public CompositeActions click() {
        actions.click();
        return this;
    }

    @Override
    public CompositeActions doubleClick(WebElement target) {
        actions.doubleClick(target);
        return this;
    }

    @Override
    public CompositeActions doubleClick() {
        actions.doubleClick();
        return this;
    }

    @Override
    public CompositeActions moveToElement(WebElement target) {
        actions.moveToElement(target);
        return this;
    }

    @Override
    public CompositeActions contextClick(WebElement target) {
        actions.contextClick(target);
        return this;
    }

    @Override
    public CompositeActions contextClick() {
        actions.contextClick();
        return this;
    }

    @Override
    public CompositeActions dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target);
        return this;
    }

    @Override
    public CompositeActions dragAndDropBy(WebElement source, int xOffset, int yOffset) {
        actions.dragAndDropBy(source, xOffset, yOffset);
        return this;
    }

    @Override
    public CompositeActions perform() {
        actions.perform();
        return this;
    }
}

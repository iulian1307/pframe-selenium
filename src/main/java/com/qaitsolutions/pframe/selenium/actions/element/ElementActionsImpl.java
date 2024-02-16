package com.qaitsolutions.pframe.selenium.actions.element;

import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.actions.conditions.ElementCondition;
import com.qaitsolutions.pframe.selenium.config.Config;
import com.qaitsolutions.pframe.selenium.driver.Driver;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public final class ElementActionsImpl implements ElementActions, ElementWaitActions {

    @Setter
    private WebElement element;
    private By locator;

    private String elementName = "[PLACEHOLDER]";

    //TODO @Override List<WebElement> findElements(By by);
    //TODO @Override WebElement findElement(By by);

    @Override
    public ElementActions click() {
        Log.info("Clicking on [%s]", elementName);
        lazyInitElement().click();

        return this;
    }

    @Override
    public ElementActions contextClick() {
        Log.info("Context (right) clicking on [%s]", elementName);
        new Actions(Driver.getDriver()).contextClick(lazyInitElement()).perform();

        return this;
    }

    @Override
    public ElementActions doubleClick() {
        Log.info("Double clicking on [%s]", elementName);
        new Actions(Driver.getDriver()).doubleClick(lazyInitElement()).perform();

        return this;
    }

    @Override
    public ElementActions hover() {
        Log.info("Hovering over [%s]", elementName);
        new Actions(Driver.getDriver()).moveToElement(lazyInitElement()).perform();

        return this;
    }

    @Override
    public ElementActions submit() {
        Log.info("Submitting element [%s]", elementName);
        lazyInitElement().submit();

        return this;
    }

    @Override
    public ElementActions sendKeys(CharSequence... keysToSend) {
        Log.info("Sending keys [%s] to field [%s]", keysToSend, elementName);
        lazyInitElement().sendKeys(keysToSend);

        return this;
    }

    @Override
    public ElementActions sendKeysHidden(CharSequence... keysToSend) {
        Log.info("Sending keys [****] to field [%s]", elementName);
        lazyInitElement().sendKeys(keysToSend);

        return this;
    }

    @Override
    public ElementActions clear() {
        Log.info("Clearing field [%s]", elementName);
        lazyInitElement().clear();

        return this;
    }

    @Override
    public ElementActions clearOneByOne() {
        Log.info("Clearing field [%s] one letter at a time", elementName);

        String fieldValue = this.getValue();

        this.lazyInitElement();

        for (int i = 0; i < Objects.requireNonNull(fieldValue).length(); i++)
            element.sendKeys(Keys.BACK_SPACE);

        return this;
    }

    @Override
    public void selectOptionByText(String text) {
        Log.info("Selecting option from dropdown by text on [%s]", elementName);
        new Select(lazyInitElement()).selectByVisibleText(text);
    }

    @Override
    public void selectOptionByValue(String value) {
        Log.info("Selecting option from dropdown by value on [%s]", elementName);
        new Select(lazyInitElement()).selectByValue(value);
    }

    @Override
    public void selectOptionByIndex(int index) {
        Log.info("Selecting option from dropdown by value on [%s]", elementName);
        new Select(lazyInitElement()).selectByIndex(index);
    }

    @Override
    public void deselectOptionByText(String text) {
        Log.info("Deselecting option from dropdown by text on [%s]", elementName);
        new Select(lazyInitElement()).deselectByVisibleText(text);
    }

    @Override
    public void deselectOptionByValue(String value) {
        Log.info("Deselecting option from dropdown by value on [%s]", elementName);
        new Select(lazyInitElement()).deselectByValue(value);
    }

    @Override
    public void deselectOptionByIndex(int index) {
        Log.info("Deselecting option from dropdown by value on [%s]", elementName);
        new Select(lazyInitElement()).deselectByIndex(index);
    }

    @Override
    public void deselectAllOptionByIndex() {
        Log.info("Deselecting all from dropdown on [%s]", elementName);
        new Select(lazyInitElement()).deselectAll();
    }

    @Override
    public ElementActions pressEnter() {
        Log.info("Pressing Enter on [%s]", elementName);
        lazyInitElement().sendKeys(Keys.ENTER);

        return this;
    }

    @Override
    public ElementActions pressTab() {
        Log.info("Pressing Tab on [%s]", elementName);
        lazyInitElement().sendKeys(Keys.TAB);

        return this;
    }

    @Override
    public ElementActions pressEscape() {
        Log.info("Pressing Escape on [%s]", elementName);
        lazyInitElement().sendKeys(Keys.ESCAPE);

        return this;
    }

    @Override
    public ElementActions takeScreenshot() {
        Log.debug("Capturing element [%s] screenshot", elementName);

        var base64Screenshot = lazyInitElement().getScreenshotAs(OutputType.BASE64);
        Log.infoWithScreenshotByBase64String("Element screenshot attached", base64Screenshot);

        return this;
    }

    @Override
    public String getInnerText() {
        Log.debug("Retrieving inner text from [%s]", elementName);
        return lazyInitElement().getAttribute("textContent");
    }

    @Override
    public String getInnerHtml() {
        Log.debug("Retrieving inner html from [%s]", elementName);
        return lazyInitElement().getAttribute("innerHTML");
    }

    @Override
    public String getName() {
        Log.debug("Retrieving name from [%s]", elementName);
        return lazyInitElement().getAttribute("name");
    }

    @Override
    public String getValue() {
        Log.debug("Retrieving value from [%s]", elementName);
        return lazyInitElement().getAttribute("value");
    }

    @Override
    public String getTagName() {
        Log.info("Retrieving Tag Name of field [%s]", elementName);
        return lazyInitElement().getTagName();
    }

    @Override
    public String getDomProperty(String name) {
        Log.info("Retrieving Dom Property of field [%s]", elementName);
        return lazyInitElement().getDomProperty(name);
    }

    @Override
    public String getDomAttribute(String name) {
        Log.info("Retrieving Dom Attribute of field [%s]", elementName);
        return lazyInitElement().getDomAttribute(name);
    }

    @Override
    public String getAttribute(String name) {
        Log.info("Retrieving Attribute of field [%s]", elementName);
        return lazyInitElement().getAttribute(name);
    }

    @Override
    public String getAriaRole() {
        Log.info("Retrieving Aria Role of field [%s]", elementName);
        return lazyInitElement().getAriaRole();
    }

    @Override
    public String getAccessibleName() {
        Log.info("Retrieving Accessible Name of field [%s]", elementName);
        return lazyInitElement().getAccessibleName();
    }

    @Override
    public String getText() {
        Log.info("Retrieving Text of field [%s]", elementName);
        return lazyInitElement().getText();
    }

    @Override
    public String getCssValue(String propertyName) {
        Log.info("Retrieving CSS Value of field [%s]", elementName);
        return lazyInitElement().getCssValue(propertyName);
    }

    @Override
    public boolean isSelected() {
        Log.info("Checking if field [%s] is Selected", elementName);
        return lazyInitElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        Log.info("Checking if field [%s] is Enabled", elementName);
        return lazyInitElement().isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        Log.info("Checking if field [%s] is Displayed", elementName);
        return lazyInitElement().isDisplayed();
    }

    @Override
    public SearchContext getShadowRoot() {
        Log.info("Retrieving SearchContext of field [%s]", elementName);
        return lazyInitElement().getShadowRoot();
    }

    @Override
    public Point getLocation() {
        Log.info("Retrieving Location of field [%s]", elementName);
        return lazyInitElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        Log.info("Retrieving Dimension of field [%s]", elementName);
        return lazyInitElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        Log.info("Retrieving Rectangle of field [%s]", elementName);
        return lazyInitElement().getRect();
    }

    @Override
    public JsElementActions js() {
        return new JsElementActionsImpl(lazyInitElement(), elementName);
    }

    @Override
    public boolean is(ElementCondition condition, int seconds) {
        Log.debug("Checking custom condition for [%s]", elementName);

        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.VISIBLE.apply(lazyInitElement()));
    }

    @Override
    public boolean is(ElementCondition condition) {
        return this.is(condition, Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilClickable(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be clickable", seconds, elementName);

        this.lazyInitElement();

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds)).
                until(d -> ElementCondition.CLICKABLE.apply(element) && ElementCondition.FOCUSED.apply(element));

        return this;
    }

    @Override
    public ElementActions waitUntilClickable() {
        return this.waitUntilClickable(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilVisible(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be visible", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.VISIBLE.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilVisible() {
        return waitUntilVisible(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilHidden(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be hidden", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.INVISIBLE.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilHidden() {
        return waitUntilHidden(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilReadOnly(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be read only", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.READ_ONLY.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilReadOnly() {
        return waitUntilReadOnly(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilFocused(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be focused", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.FOCUSED.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilFocused() {
        return waitUntilFocused(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilEnabled(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be enabled", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.ENABLED.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilEnabled() {
        return waitUntilEnabled(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilDisabled(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be disabled", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.DISABLED.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilDisabled() {
        return waitUntilDisabled(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilSelected(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be selected", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.SELECTED.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilSelected() {
        return waitUntilSelected(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilInteractable(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be interactable", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.INTERACTABLE.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilInteractable() {
        return waitUntilInteractable(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilEditable(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be editable", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.EDITABLE.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilEditable() {
        return waitUntilEditable(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilUnselected(int seconds) {
        Log.debug("Waiting %s seconds for [%s] to be selected", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> ElementCondition.NOT_SELECTED.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilUnselected() {
        return waitUntilUnselected(Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntil(ElementCondition condition, int seconds) {
        Log.debug("Waiting %s seconds for [%s] to meet custom condition", seconds, elementName);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(d -> condition.apply(lazyInitElement()));

        return this;
    }

    @Override
    public ElementActions waitUntilAttributeIs(String attribute, String value, int seconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.attributeToBe(lazyInitElement(), attribute, value));

        return this;
    }

    @Override
    public ElementActions waitUntilAttributeIs(String attribute, String value) {
        return waitUntilAttributeIs(attribute, value, Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilAttributeIsNotEmpty(String attribute, int seconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.attributeToBeNotEmpty(lazyInitElement(), attribute));

        return this;
    }

    @Override
    public ElementActions waitUntilAttributeIsNotEmpty(String attribute) {
        return waitUntilAttributeIsNotEmpty(attribute, Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilAttributeContains(String attribute, String value, int seconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.attributeContains(lazyInitElement(), attribute, value));

        return this;
    }

    @Override
    public ElementActions waitUntilAttributeContains(String attribute, String value) {
        return waitUntilAttributeContains(attribute, value, Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilTextIs(String text, int seconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.textToBePresentInElement(lazyInitElement(), text));

        return this;
    }

    @Override
    public ElementActions waitUntilTextIs(String text) {
        return waitUntilTextIs(text, Config.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilValueIs(String value, int seconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.textToBePresentInElementValue(lazyInitElement(), value));

        return this;
    }

    @Override
    public ElementActions waitUntilValueIs(String value) {
        return waitUntilTextIs(value, Config.getDefaultWait());
    }

    private WebElement lazyInitElement(int seconds) {
        return element == null
                ? element = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator))
                : element;
    }

    private WebElement lazyInitElement() {
        return lazyInitElement(Config.getDefaultWait());
    }

    public void setLocator(By locator) {
        this.locator = locator;
        this.elementName = locator.toString().replaceFirst("By.*:", "").trim();
    }
}

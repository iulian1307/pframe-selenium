package com.qaitsolutions.pframe.selenium.actions.browser;

import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.config.Config;
import com.qaitsolutions.pframe.selenium.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GlobalWaitActionsImpl implements GlobalWaitActions {

    @Override
    public GlobalWaitActions alertIsPresent(int seconds) {
        Log.debug("Waiting %s seconds for alert to be present", seconds);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.alertIsPresent());

        return this;
    }

    @Override
    public GlobalWaitActions alertIsPresent() {
        return alertIsPresent(Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions titleIs(String title, int seconds) {
        Log.debug("Waiting %s seconds for title to be [%s]", seconds, title);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.titleIs(title));

        return this;
    }

    @Override
    public GlobalWaitActions titleIs(String title) {
        return titleIs(title, Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions titleContains(String fraction, int seconds) {
        Log.debug("Waiting %s seconds for title contains [%s]", seconds, fraction);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.titleContains(fraction));

        return this;
    }

    @Override
    public GlobalWaitActions titleContains(String fraction) {
        return titleContains(fraction, Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions urlIs(String url, int seconds) {
        Log.debug("Waiting %s seconds for url to be [%s]", seconds, url);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.urlToBe(url));

        return this;
    }

    @Override
    public GlobalWaitActions urlIs(String url) {
        return urlIs(url, Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions urlContains(String fraction, int seconds) {
        Log.debug("Waiting %s seconds for url contains [%s]", seconds, fraction);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.urlContains(fraction));

        return this;
    }

    @Override
    public GlobalWaitActions urlContains(String fraction) {
        return urlContains(fraction, Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions urlMatches(String regex, int seconds) {
        Log.debug("Waiting %s seconds for url to match [%s]", seconds, regex);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.urlMatches(regex));

        return this;
    }

    @Override
    public GlobalWaitActions urlMatches(String regex) {
        return urlMatches(regex, Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions frameIsAvailableAndSwitchToIt(int frameLocator, int seconds) {
        Log.debug("Waiting %s seconds for frame [%s] to be available and switch to it", seconds, frameLocator);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

        return this;
    }

    @Override
    public GlobalWaitActions frameIsAvailableAndSwitchToIt(int frameLocator) {
        return frameIsAvailableAndSwitchToIt(frameLocator, Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions frameIsAvailableAndSwitchToIt(String frameLocator, int seconds) {
        Log.debug("Waiting %s seconds for frame [%s] to be available and switch to it", seconds, frameLocator);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

        return this;
    }

    @Override
    public GlobalWaitActions frameIsAvailableAndSwitchToIt(String frameLocator) {
        return frameIsAvailableAndSwitchToIt(frameLocator, Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions frameIsAvailableAndSwitchToIt(By locator, int seconds) {
        Log.debug("Waiting %s seconds for frame to be available and switch to it", seconds);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));

        return this;
    }

    @Override
    public GlobalWaitActions frameIsAvailableAndSwitchToIt(By locator) {
        return frameIsAvailableAndSwitchToIt(locator, Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions frameIsAvailableAndSwitchToIt(WebElement locator, int seconds) {
        Log.debug("Waiting %s seconds for frame to be available and switch to it", seconds);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));

        return this;
    }

    @Override
    public GlobalWaitActions frameIsAvailableAndSwitchToIt(WebElement locator) {
        return frameIsAvailableAndSwitchToIt(locator, Config.getDefaultWait());
    }

    @Override
    public GlobalWaitActions numberOfWindowsToBe(int expected, int seconds) {
        Log.debug("Waiting %s seconds for number of windows to be [%s]", seconds, expected);

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.numberOfWindowsToBe(expected));

        return this;
    }

    @Override
    public GlobalWaitActions numberOfWindowsToBe(int expected) {
        return numberOfWindowsToBe(expected, Config.getDefaultWait());
    }
}

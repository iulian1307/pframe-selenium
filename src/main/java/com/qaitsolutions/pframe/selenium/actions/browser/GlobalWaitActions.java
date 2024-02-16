package com.qaitsolutions.pframe.selenium.actions.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public interface GlobalWaitActions {

    GlobalWaitActions alertIsPresent(int seconds);

    GlobalWaitActions alertIsPresent();

    GlobalWaitActions titleIs(String title, int seconds);

    GlobalWaitActions titleIs(String title);

    GlobalWaitActions titleContains(String fraction, int seconds);

    GlobalWaitActions titleContains(String fraction);

    GlobalWaitActions urlIs(String url, int seconds);

    GlobalWaitActions urlIs(String url);

    GlobalWaitActions urlContains(String fraction, int seconds);

    GlobalWaitActions urlContains(String fraction);

    GlobalWaitActions urlMatches(String regex, int seconds);

    GlobalWaitActions urlMatches(String regex);

    GlobalWaitActions frameIsAvailableAndSwitchToIt(int frameLocator, int seconds);

    GlobalWaitActions frameIsAvailableAndSwitchToIt(int frameLocator);

    GlobalWaitActions frameIsAvailableAndSwitchToIt(String frameLocator, int seconds);

    GlobalWaitActions frameIsAvailableAndSwitchToIt(String frameLocator);

    GlobalWaitActions frameIsAvailableAndSwitchToIt(By locator, int seconds);

    GlobalWaitActions frameIsAvailableAndSwitchToIt(By locator);

    GlobalWaitActions frameIsAvailableAndSwitchToIt(WebElement locator, int seconds);

    GlobalWaitActions frameIsAvailableAndSwitchToIt(WebElement locator);

    GlobalWaitActions numberOfWindowsToBe(int expected, int seconds);

    GlobalWaitActions numberOfWindowsToBe(int expected);
}

package com.qaitsolutions.pframe.selenium.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;

public class ChromeBuilder implements BrowserBuilder {
    private final ChromeOptions options = new ChromeOptions();

    @Override
    public BrowserBuilder windowSize(int width, int height) {
        options.addArguments(String.format("--window-size=%s,%s", width, height));
        return this;
    }

    @Override
    public BrowserBuilder windowMaximized() {
        options.addArguments("start-maximized");
        return this;
    }

    @Override
    public BrowserBuilder headless(boolean flag) {
        if (flag) options.addArguments("--headless");
        return this;
    }

    @Override
    public BrowserBuilder pageLoadTimeout(Duration duration) {
        if (duration != null) options.setPageLoadTimeout(duration);
        return this;
    }

    @Override
    public BrowserBuilder downloadDirectory(String directory) {
        if (directory != null) {
            var preferences = new HashMap<String, Object>();
            preferences.put("download.default_directory", directory);
            options.setExperimentalOption("prefs", preferences);
        }

        return this;
    }

    @Override
    public BrowserBuilder acceptInsecureCerts(boolean flag) {
        options.setAcceptInsecureCerts(flag);
        return this;
    }

    @Override
    public BrowserBuilder driverPath(String path) {
        if (path != null) System.setProperty("webdriver.chrome.driver", path);
        return this;
    }

    @Override
    public BrowserBuilder addArguments(final String... args) {
        options.addArguments(args);
        return this;
    }

    @Override
    public void build() {
        Driver.setDriver(new ChromeDriver(options));
    }
}

/*
TODO check if arguments exist for other than chrome

options.addArguments("--enable-automation");
options.addArguments("--disable-notifications");
options.addArguments("--disable-infobars");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--no-sandbox");
options.addArguments("--enable-features=NetworkService,NetworkServiceInProcess");
options.addArguments("--remote-allow-origins=*");

if (Configuration.BROWSER.equals(HEADLESS_CHROME)) {
options.addArguments("--headless=new");
}

 Enable this option if you need to check chrome devtools while running tests
 TODO implement this as optional parameter at run time
// options.addArguments("--auto-open-devtools-for-tabs");
 */

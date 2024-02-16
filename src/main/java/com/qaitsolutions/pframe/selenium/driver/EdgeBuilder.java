package com.qaitsolutions.pframe.selenium.driver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.HashMap;

public class EdgeBuilder implements BrowserBuilder {

    private final EdgeOptions options = new EdgeOptions();

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
        options.addArguments("--headless");
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
        if (path != null) System.setProperty("webdriver.edge.driver", path);
        return this;
    }

    @Override
    public BrowserBuilder addArguments(final String... args) {
        options.addArguments(args);
        return this;
    }

    @Override
    public void build() {
        Driver.setDriver(new EdgeDriver(options));
    }
}

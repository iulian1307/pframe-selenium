package com.qaitsolutions.pframe.selenium.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;

public class FirefoxBuilder implements BrowserBuilder {

    private FirefoxProfile profile;

    private final FirefoxOptions options = new FirefoxOptions();
    private boolean isMaximized = false;

    @Override
    public BrowserBuilder windowSize(int width, int height) {
        this.options.addArguments("--width=" + width);
        this.options.addArguments("--height=" + height);

        return this;
    }

    @Override
    public BrowserBuilder windowMaximized() {
        this.isMaximized = true;
        return this;
    }

    @Override
    public BrowserBuilder headless(boolean flag) {
        this.options.addArguments("--headless");
        return this;
    }

    @Override
    public BrowserBuilder pageLoadTimeout(Duration duration) {
        if (duration != null) this.options.setPageLoadTimeout(duration);
        return this;
    }

    @Override
    public BrowserBuilder downloadDirectory(String directory) {
        if (directory != null) {
            this.profile = new FirefoxProfile();
            profile.setPreference("browser.download.folderList", 2);
            profile.setPreference("browser.download.dir", directory);
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", CommonMediaType.getAllWithSeparator(";"));
        }

        return this;
    }

    @Override
    public BrowserBuilder acceptInsecureCerts(boolean flag) {
        this.options.setAcceptInsecureCerts(flag);
        return this;
    }

    @Override
    public BrowserBuilder driverPath(String path) {
        System.setProperty("webdriver.gecko.driver", path);
        return this;
    }

    @Override
    public BrowserBuilder addArguments(final String... args) {
        options.addArguments(args);
        return this;
    }

    @Override
    public void build() {

        if (profile != null) options.setProfile(profile);
        var driver = new FirefoxDriver(options);

        if (isMaximized)
            driver.manage().window().maximize();

        Driver.setDriver(driver);
    }
}

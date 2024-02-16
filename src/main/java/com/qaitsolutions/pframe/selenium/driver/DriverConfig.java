package com.qaitsolutions.pframe.selenium.driver;

import com.qaitsolutions.pframe.selenium.config.Config;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Setter @Getter
public class DriverConfig {
    private Browser browser;
    private String windowSize;
    private boolean headless;
    private Duration pageLoadTimeout;
    private String downloadDirectory;
    private boolean acceptInsecureCerts;
    private String driverPath;

    public DriverConfig fromFile() {
        browser = Config.getBrowserType();
        windowSize = Config.getBrowserSize();
        headless = Config.isHeadless();
        downloadDirectory = Config.getDownloadPath();

        return this;
    }
}

package com.qaitsolutions.pframe.selenium.driver;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public class Driver {

    @Getter @Setter
    private static WebDriver driver;

    public static void quit() {
        if (driver != null) driver.quit();
    }
}

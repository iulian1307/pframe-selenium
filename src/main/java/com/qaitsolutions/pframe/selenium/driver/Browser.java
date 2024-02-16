package com.qaitsolutions.pframe.selenium.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Contains all supported browsers
 */
@AllArgsConstructor @Getter
public enum Browser {
    CHROME("chrome"),
    EDGE("edge"),
    FIREFOX("firefox");

    private final String identifier;
}

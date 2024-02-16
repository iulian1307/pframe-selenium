package com.qaitsolutions.pframe.selenium.actions.global;

import org.openqa.selenium.ScriptKey;

import java.util.List;

public interface JsExecutor {
    Object execute(String script, Object... args);

    Object execute(ScriptKey key, Object... args);

    ScriptKey pin(String script);

    void unpin(ScriptKey key);

    List<ScriptKey> getPinnedScripts();
}

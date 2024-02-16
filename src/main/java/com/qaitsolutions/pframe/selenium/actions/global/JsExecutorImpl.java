package com.qaitsolutions.pframe.selenium.actions.global;

import com.qaitsolutions.pframe.core.testng.Log;
import com.qaitsolutions.pframe.selenium.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;

import java.util.ArrayList;
import java.util.List;

public final class JsExecutorImpl implements JsExecutor {

    private final JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Override
    public Object execute(String script, Object... args) {
        Log.debug("Executing JS script [%s]", script);
        return js.executeScript(script, args);
    }

    @Override
    public Object execute(ScriptKey key, Object... args) {
        Log.debug("Executing JS script with key [%s]", key.getIdentifier());
        return js.executeScript(key, args);
    }

    @Override
    public ScriptKey pin(String script) {
        Log.debug("Pining JS script [%s]", script);

        var key = js.pin(script);
        Log.debug("Script pinned with key [%s]", key.getIdentifier());

        return js.pin(script);
    }

    @Override
    public void unpin(ScriptKey key) {
        Log.debug("Unpinning JS script [%s]", key.getIdentifier());
        js.unpin(key);
    }

    @Override
    public List<ScriptKey> getPinnedScripts() {
        Log.debug("Retrieving pinned scripts");
        return new ArrayList<>(js.getPinnedScripts());
    }
}

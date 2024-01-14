package dev.vmillet.brozone;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

/**
 * Custom logger based on libgdx app but with a specific string format and colors
 */
public final class GdxLogger {
    private final String className;

    GdxLogger(String className) {
        this.className = className;
    }


    public static void setDebugLevelMode() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }

    public void setInfoLevelMode() {
        Gdx.app.setLogLevel(Application.LOG_INFO);
    }

    public void setErrorLevelMode() {
        Gdx.app.setLogLevel(Application.LOG_ERROR);
    }

    public void disableLogging() {
        Gdx.app.setLogLevel(Application.LOG_NONE);
    }

    public void debug(String message) {
        Gdx.app.debug("\u001B[34mDEBUG\u001B[0m", className + " : \u001B[34m" + message + "\u001B[0m");
    }

    public void debug(String message, Throwable e) {
        Gdx.app.debug("\u001B[34mDEBUG\u001B[0m",  className + " : \u001B[34m" + message + "\u001B[0m", e);
    }

    public void info(String message) {
        Gdx.app.log("\u001B[32mINFO\u001B[0m", " " + className + " : \u001B[32m" + message + "\u001B[0m");
    }

    public void info(String message, Throwable e) {
        Gdx.app.log("\u001B[32mINFO\u001B[0m", " " + className + " : \u001B[32m" + message + "\u001B[0m", e);
    }

    public void error(String message) {
        Gdx.app.error("\u001B[31mERROR\u001B[0m", className + " : \u001B[31m" + message + "\u001B[0m");
    }

    public void error(String message, Throwable e) {
        Gdx.app.error("\u001B[31mERROR\u001B[0m", className + " : \u001B[31m" + message + "\u001B[0m", e);
    }
}

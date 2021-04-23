package io.metalloid.factory;

import io.metalloid.Constants;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BlogFirefoxOptions {
    public  FirefoxOptions get() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", Constants.TMP_DIRECTORY);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");
        options.addPreference("browser.helperApps.alwaysAsk.force", false);
        options.addPreference("browser.download.manager.showWhenStarting",false);
        options.addPreference("general.useragent.override", "Coinfirm Tests/1.0");

        options.setHeadless(Constants.HEADLESS_MODE);
        options.addArguments("--start-fullscreen");

        options.setCapability("name", "myTestName");
        options.setCapability("build", "myTestBuild");
        options.setCapability("idleTimeout", 150);
        options.setCapability("recordVideo", false);

        return options;
    }
}

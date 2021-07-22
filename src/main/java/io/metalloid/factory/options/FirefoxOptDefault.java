package io.metalloid.factory.options;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;

public class FirefoxOptDefault implements ParameterizedBrowserOptions<FirefoxOptions> {
    @Value("${datasource.tmp_directory}")
    private String tmpDirectory;

    @Value("${datasource.headless_mode}")
    private boolean headlessMode;

    @Override
    public FirefoxOptions get() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", tmpDirectory);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");
        options.addPreference("browser.helperApps.alwaysAsk.force", false);
        options.addPreference("browser.download.manager.showWhenStarting",false);
        options.addPreference("general.useragent.override", "Coinfirm Tests/1.0");

        options.setHeadless(headlessMode);
        options.addArguments("--start-fullscreen");

        options.setCapability("name", "myTestName");
        options.setCapability("build", "myTestBuild");
        options.setCapability("idleTimeout", 150);
        options.setCapability("recordVideo", false);

        return options;
    }
}

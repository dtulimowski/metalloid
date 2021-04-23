package io.metalloid.factory;

import io.metalloid.Constants;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BlogChromeOptions {
    public ChromeOptions get() {
        Map<String, Object>preferences = new HashMap<>();
        preferences.put("profile.default_content_settings.popups", 0);
        preferences.put("download.default_directory", Constants.TMP_DIRECTORY);
        preferences.put("download.directory_upgrade", true);
        preferences.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);
        options.addArguments("--window-size=1920x1080");
        options.setHeadless(Constants.HEADLESS_MODE);
        return options;
    }
}

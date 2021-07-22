package io.metalloid.factory.options;

import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChromeOptDefault implements ParameterizedBrowserOptions<ChromeOptions> {
    @Value("${datasource.tmp_directory}")
    private String tmpDirectory;

    @Value("${datasource.headless_mode}")
    private boolean headlessMode;

    @Override
    public ChromeOptions get() {
        Map<String, Object> preferences = new HashMap<>();
        preferences.put("profile.default_content_settings.popups", 0);
        preferences.put("download.default_directory", tmpDirectory);
        preferences.put("download.directory_upgrade", true);
        preferences.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);
        options.addArguments("--window-size=1920x1080");
        options.setHeadless(headlessMode);
        return options;

    }
}

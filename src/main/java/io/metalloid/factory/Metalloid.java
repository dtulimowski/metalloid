package io.metalloid.factory;

import io.metalloid.configuration.WebDriverAgent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("metalloid")
public class Metalloid {
    @Autowired
    private BrowserFactory browserFactory;

    @Autowired
    private WebDriverAgent webDriverAgent;

    @Value("${datasource.browser.type}")
    private String browserType;

    @Value("${datasource.browser.name}")
    private String browserName;

    @Value("${datasource.grid}")
    private String grid;

    @Bean
    @Scope("prototype")
    public WebDriver run() {
        WebDriver driver;
        switch (browserType) {
            case "local":
                driver = browserName.equals("chrome") ? browserFactory.createChromeDriver() : browserFactory.createFirefoxDriver();
                break;
            case "remote":
                driver = browserName.equals("chrome") ? browserFactory.createRemoteChromeDriver() : browserFactory.createRemoteFirefoxDriver();
                break;
            default: throw new WebDriverException("Browser is not implemented");
        }
        webDriverAgent.setDriverPath();
        return driver;
    }
}

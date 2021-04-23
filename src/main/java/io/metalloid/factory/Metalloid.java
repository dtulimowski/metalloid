package io.metalloid.factory;

import io.metalloid.Constants;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component("metalloid")
public class Metalloid {
    private WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

    @SneakyThrows
    private RemoteWebDriver createRemoteFirefoxDriver() {
        return new RemoteWebDriver(new URL(Constants.REMOTE_GRID), new BlogChromeOptions().get());
    }

    @SneakyThrows
    private RemoteWebDriver createRemoteChromeDriver() {
        return new RemoteWebDriver(new URL(Constants.REMOTE_GRID), new BlogChromeOptions().get());
    }

    public WebDriver run() {
        WebDriver driver;
        switch (Constants.BROWSER_TYPE) {
            case "LOCAL":
                driver = Constants.BROWSER_NAME.equals("CHROME") ? createChromeDriver() : createFirefoxDriver();
                break;
            case "REMOTE":
                driver = Constants.BROWSER_NAME.equals("CHROME") ? createRemoteChromeDriver() : createRemoteFirefoxDriver();
                break;
            default: throw new WebDriverException("Browser not implemented");
        }
        return driver;
    }
}

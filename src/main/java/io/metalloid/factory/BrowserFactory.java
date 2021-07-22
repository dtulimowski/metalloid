package io.metalloid.factory;

import io.metalloid.factory.options.ParameterizedBrowserOptions;
import io.metalloid.factory.options.ParametrizedChromeOptions;
import io.metalloid.factory.options.ParametrizedFirefoxOptions;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.URL;

@Configuration
public class BrowserFactory {

    private ParameterizedBrowserOptions<ChromeOptions> chromeOpt;

    @Value("${datasource.grid}")
    private String grid;

    @Bean
    @Scope("prototype")
    public WebDriver createFirefoxDriver() {
        return new FirefoxDriver(new ParametrizedFirefoxOptions().get());
    }

    @Bean
    @Scope("prototype")
    public WebDriver createChromeDriver() {
        //return new ChromeDriver(new ParametrizedChromeOptions().get());
        return new ChromeDriver(chromeOpt.get());
    }

    @Bean
    @Scope("prototype")
    @SneakyThrows
    public RemoteWebDriver createRemoteFirefoxDriver() {
        return new RemoteWebDriver(new URL(grid), new ParametrizedFirefoxOptions().get());
    }

    @Bean
    @Scope("prototype")
    @SneakyThrows
    public RemoteWebDriver createRemoteChromeDriver() {
        return new RemoteWebDriver(new URL(grid), new ParametrizedChromeOptions().get());
    }

}

package io.metalloid.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverAgent {

    @Value("${datasource.browser.name}")
    private String browserName;

    @Bean
    public void setDriverPath() {
        WebDriverManager.getInstance(DriverManagerType.valueOfDisplayName(browserName)).setup();
    }
}

package io.metalloid.api;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PlaceHolderClientImpl {

    @Bean
    @Scope("prototype")
    public PlaceHolderClient execute() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(PlaceHolderClient.class))
                .logLevel(Logger.Level.FULL)
                .target(PlaceHolderClient.class, "https://jsonplaceholder.typicode.com/posts");
    }
}

package com.myapp.springreactiveexample2.config;

import com.myapp.springreactiveexample2.handler.ProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RoutesConfig {

    private final ProductHandler productHandler;

    @Bean
    public RouterFunction<ServerResponse> router() {
        return route().GET("/all", productHandler::getAll).build();
    }

}

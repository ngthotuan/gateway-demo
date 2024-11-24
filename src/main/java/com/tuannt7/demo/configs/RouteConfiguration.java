package com.tuannt7.demo.configs;

/**
 * Created by tuannt7 on 24/11/2024
 */

import com.tuannt7.demo.filters.MyCustomFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
@RequiredArgsConstructor
class RouteConfiguration {
    private final MyCustomFilter myCustomFilter;

    @Bean
    public RouterFunction<ServerResponse> gatewayRouterFunctionsBefore() {
        return route("r3")
                .GET("/test3", http("https://example.org"))
                .filter(myCustomFilter)
                .build();
    }
}

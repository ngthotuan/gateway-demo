package com.tuannt7.demo.filters;

import org.springframework.cloud.gateway.server.mvc.common.Shortcut;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.UUID;

/**
 * Created by tuannt7 on 22/11/2024
 */

public class SampleHandlerFilterFunctions {
    @Shortcut
    public static HandlerFilterFunction<ServerResponse, ServerResponse> instrument(String requestHeader, String responseHeader) {
        return (request, next) -> {
            ServerRequest modified = ServerRequest.from(request).header(requestHeader, generateId()).build();
            ServerResponse response = next.handle(modified);
            response.headers().add(responseHeader, generateId());
            return response;
        };
    }

    private static String generateId() {
        return UUID.randomUUID().toString();
    }
}

package com.tuannt7.demo.filters;

import com.tuannt7.demo.services.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * Created by tuannt7 on 24/11/2024
 */

@Component
@RequiredArgsConstructor
public class MyCustomFilter implements HandlerFilterFunction<ServerResponse, ServerResponse> {
    private final MyService myService;

    @Override
    public ServerResponse filter(ServerRequest request, HandlerFunction<ServerResponse> next) throws Exception {
        String requestId = myService.generateRequestId();
        ServerRequest modified = ServerRequest.from(request).header("X-Request-Id", requestId).build();
        ServerResponse response = next.handle(modified);
        response.headers().add("X-Response-Id", requestId);
        return response;
    }

}

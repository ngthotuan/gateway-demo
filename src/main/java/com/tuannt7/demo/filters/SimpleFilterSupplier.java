package com.tuannt7.demo.filters;

import org.springframework.cloud.gateway.server.mvc.filter.FilterSupplier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

/**
 * Created by tuannt7 on 22/11/2024
 */

@Component
public class SimpleFilterSupplier implements FilterSupplier {
    public Collection<Method> get() {
        return List.of(SampleHandlerFilterFunctions.class.getMethods());
    }
}

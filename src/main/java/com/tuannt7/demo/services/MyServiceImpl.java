package com.tuannt7.demo.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by tuannt7 on 24/11/2024
 */
@Service
public class MyServiceImpl implements MyService {
    @Override
    public String generateRequestId() {
        return UUID.randomUUID().toString();
    }
}

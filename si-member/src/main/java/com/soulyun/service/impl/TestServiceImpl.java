package com.soulyun.service.impl;

import com.soulyun.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    @Override
    public void error() {
        int i = 10 / 0;
    }
}

package com.accenture.ws.entity;

import org.springframework.stereotype.Component;

@Component
public class CafeClerk {
    private String name;

    public CafeClerk() {
        this.name = "John Doe";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

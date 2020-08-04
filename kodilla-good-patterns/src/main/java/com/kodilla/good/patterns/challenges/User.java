package com.kodilla.good.patterns.challenges;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.xml.bind.SchemaOutputResolver;

public class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

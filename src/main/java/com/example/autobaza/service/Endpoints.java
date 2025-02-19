package com.example.autobaza.service;

import java.util.ArrayList;
import java.util.List;

public enum Endpoints {
    HOME("/"),
    MAIN("/main"),
    LOGIN("/login"),
    REGISTER("/register"),
    LOGOUT("/logout"),

    CAR("/cars/get"),
    CAR_CREATE("/car/create");

    private String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    static public List<Endpoints> getEndpointForAllUsers() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(HOME);
        endpoints.add(LOGIN);
        endpoints.add(REGISTER);
        endpoints.add(LOGOUT);
        return endpoints;
    }

    static public List<Endpoints> getEndpointsForAdmin(){
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(CAR);
        endpoints.add(CAR_CREATE);

        return endpoints;
    }

    static public List<Endpoints> getEndpointsForDriver(){
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(MAIN);

        return endpoints;
    }

}

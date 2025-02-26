package com.example.autobaza.service;

import java.util.ArrayList;
import java.util.List;

public enum Endpoints {
    HOME("/"),
    MAIN("/userInfo"),
    LOGIN("/login"),
    REGISTER("/register"),
    LOGOUT("/logout"),

    CAR("/cars/get"),
    CAR_CREATE("/car/create"),
    DRIVERS("/drivers/get"),
    REQUEST("/requests/get"),
    REQUEST_CREATE("/request/create"),
    TRIP("/trips/get"),
    TRIP_CANCEL("/trip/cancel"),
    TRIP_CREATE("/trip/create"),
    REPAIR_REQUEST_COMPLETE("/repairRequest/complete/{id}");

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
        endpoints.add(DRIVERS);
        endpoints.add(REQUEST);
        endpoints.add(REQUEST_CREATE);
        endpoints.add(TRIP_CREATE);
        endpoints.add(TRIP_CANCEL);
        endpoints.add(REPAIR_REQUEST_COMPLETE);


        return endpoints;
    }
}

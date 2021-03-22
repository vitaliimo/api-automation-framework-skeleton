package com.api.services;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//this class describes endpoints preparation handling
public class ApiService {
    protected RequestSpecification setup() {
        return RestAssured
                .given().contentType(ContentType.JSON)
                .filters(getFilter());
    }

    private List<Filter> getFilter() {
        boolean isEnabled = Boolean.parseBoolean(System.getProperty("logging", "true"));
        if (isEnabled) {
            return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
        return Collections.emptyList();
    }
}
package com.api.assertions;

import com.api.conditions.Condition;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssertableResponse {

    private final Response response;

    // This simple class just gets the response and calls conditions
    // And every condition is implemented in separate class
    // In order to make possible chain calls I return AssertableResponse
    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }

    public Headers headers(){
        return response.headers();
    }
}

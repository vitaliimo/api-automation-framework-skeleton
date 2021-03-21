package com.socks.api.assertions;

import com.socks.api.conditions.Condition;
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
}

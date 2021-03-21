package com.api.services;

import com.api.assertions.AssertableResponse;
import com.api.payloads.UserPayload;

public class UserApiService extends ApiService {

    public AssertableResponse createUser(UserPayload userPayload) {
        return new AssertableResponse(setup()
                .body(userPayload)
                .when()
                .post());
    }
}
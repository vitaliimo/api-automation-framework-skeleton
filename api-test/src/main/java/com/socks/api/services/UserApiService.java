package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.payloads.UserPayload;

public class UserApiService extends ApiService {

    public AssertableResponse createUser(UserPayload userPayload) {
        return new AssertableResponse(setup()
                .body(userPayload)
                .when()
                .post());
    }
}
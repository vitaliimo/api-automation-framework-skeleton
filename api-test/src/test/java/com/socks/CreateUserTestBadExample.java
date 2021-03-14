package com.socks;

import com.socks.api.payloads.UserPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CreateUserTestBadExample {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/api/users";
    }

    //Code is not readable
    //Pieces of code will repeat over and over again
    //Payload is just random characters
    //Logging handling inside the test
    @Test
    public void userCanReturnListUsers() {
        UserPayload user = new UserPayload()
                .name(RandomStringUtils.randomAlphanumeric(6))
                .job(RandomStringUtils.randomAlphanumeric(6));

        RestAssured.given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post()
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .body("id", not(emptyString()));
    }
}

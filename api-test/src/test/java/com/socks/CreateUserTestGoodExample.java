package com.socks;

import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;

import io.restassured.RestAssured;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.socks.api.conditions.Conditions.bodyField;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.*;


public class CreateUserTestGoodExample {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/api/users";
	}

	private final UserApiService userApiService = new UserApiService();

	//Any user even without technical background can understand what is going on in this test
	//Code is reusable now using userApiService
	@Test
	public void userCanReturnListUsers() {
		UserPayload user = new UserPayload()
				.name(RandomStringUtils.randomAlphanumeric(6))
				.job(RandomStringUtils.randomAlphanumeric(6));

		userApiService.createUser(user)
				.shouldHave(statusCode(201))
				.shouldHave(bodyField("name", not(emptyOrNullString())))
				.shouldHave(bodyField("job", not(emptyOrNullString())));
	}
}

package com.socks;

import com.github.javafaker.Faker;
import com.api.payloads.UserPayload;
import com.api.responses.CreateUserResponse;
import com.api.services.UserApiService;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.api.conditions.Conditions.bodyField;
import static com.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;


public class CreateUserTestGoodExample {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/api/users";
	}

	private final UserApiService userApiService = new UserApiService();
	private final Faker faker = new Faker(new Locale("ru"));

	//Any user even without technical background can understand what is going on in this test
	//Code is reusable now using userApiService
	//Test data now is valid and we can perform localization easily
	@Test
	public void userCanReturnListUsers() {
		UserPayload user = new UserPayload()
				.name(faker.name().firstName())
				.job(faker.job().position());

		CreateUserResponse createUserResponse =	userApiService.createUser(user)
				.shouldHave(statusCode(201))
				.shouldHave(bodyField("name", not(emptyOrNullString())))
				.shouldHave(bodyField("job", not(emptyOrNullString())))
				.asPojo(CreateUserResponse.class);
	}
}

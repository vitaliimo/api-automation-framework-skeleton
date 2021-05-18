package com;

import com.api.ProjectConfiguration;
import com.github.javafaker.Faker;
import com.api.payloads.UserPayload;
import com.api.responses.CreateUserResponse;
import com.api.services.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.api.conditions.Conditions.bodyField;
import static com.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;


public class CreateUserTestGoodExample {

	private final UserApiService userApiService = new UserApiService();
	private Faker faker;

	@BeforeClass
	public void setUp() {
		ProjectConfiguration projectConfiguration = ConfigFactory.create(ProjectConfiguration.class);
		RestAssured.baseURI = projectConfiguration.baseUrl();
		faker = new Faker(new Locale(projectConfiguration.locale()));
	}

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

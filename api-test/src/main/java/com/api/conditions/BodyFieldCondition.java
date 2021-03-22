package com.api.conditions;

import lombok.ToString;
import org.hamcrest.Matcher;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@ToString
@RequiredArgsConstructor
public class BodyFieldCondition implements Condition {

	private final String jsonPath;
	private final Matcher matcher;

	@Override
	public void check(Response response) {
		response.then().assertThat().body(jsonPath, matcher);
	}
}

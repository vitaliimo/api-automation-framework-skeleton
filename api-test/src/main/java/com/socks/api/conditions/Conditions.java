package com.socks.api.conditions;

import org.hamcrest.Matcher;

import lombok.experimental.UtilityClass;

//namespace for functions
@UtilityClass
public class Conditions {
	public StatusCodeCondition statusCode(int code) {
		return new StatusCodeCondition(code);
	}

	public BodyFieldCondition bodyField(String jsonPath, Matcher matcher) {
		return new BodyFieldCondition(jsonPath, matcher);
	}
}
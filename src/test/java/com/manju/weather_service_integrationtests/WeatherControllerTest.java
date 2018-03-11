package com.manju.weather_service_integrationtests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import io.restassured.http.ContentType;


public class WeatherControllerTest {

	@Test
	public void testGetWeatherReportWith_ValidCityName() {
		when()
			.get("http://localhost:8080/Weather/sunnyvale")
		.then()	
			.log()
			.body()
			.statusCode(200)
			.contentType(ContentType.JSON);
	}
	
	@Test
	public void testGetWeatherReportWith_InValidCityName() {
		when()
			.get("http://localhost:8080/Weather/jsnsjsn")
		.then()	
			.log()
			.body()
			.statusCode(400)
			.body("message", equalTo("Please provide valid city name or zipcode"));
	}
	
	@Test
	public void testGetWeatherReportWith_InValidInput() {
		when()
			.get("http://localhost:8080/Weather/sunny239va")
		.then()	
			.log()
			.body()
			.statusCode(400)
			.body("message", equalTo("Please provide valid city name or zipcode"));
	}
	
	@Test
	public void testGetWeatherReportWith_ValidZipcode() {
		when()
			.get("http://localhost:8080/Weather/94043")
		.then()	
			.log()
			.body()
			.statusCode(200)
			.contentType(ContentType.JSON);
	}
	
	@Test
	public void testGetWeatherReportWith_InValidZipcode() {
		when()
			.get("http://localhost:8080/Weather/090909")
		.then()	
			.log()
			.body()
			.statusCode(400)
			.body("message", equalTo("Please provide valid city name or zipcode"));
	}
}

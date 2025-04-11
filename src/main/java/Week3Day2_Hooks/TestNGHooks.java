package Week3Day2_Hooks;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class TestNGHooks {

	
	protected String SysId;
	
	
	@BeforeTest
	public void setUp() {

		baseURI = "https://dev242069.service-now.com";
		basePath = "/api/now/table";
		authentication = basic("admin", "OnZewSi0!5Z*");

	}

	public ResponseSpecification createResponseSpec() {
		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(201);
		expect.statusLine(Matchers.containsString("Created"));
		expect.contentType(ContentType.JSON);
		expect.time(Matchers.lessThan(5000L));
		return expect;
	}

	public ResponseSpecification getResponseSpec() {
		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(200);
		expect.statusLine(Matchers.containsString("OK"));
		expect.contentType(ContentType.JSON);
		expect.time(Matchers.lessThan(5000L));
		return expect;
	}

	public ResponseSpecification putResponseSpec() {
		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(200);
		expect.statusLine(Matchers.containsString("OK"));
		expect.contentType(ContentType.JSON);
		expect.time(Matchers.lessThan(5000L));
		return expect;
	}

	public ResponseSpecification deleteResponseSpec() {
		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(204);
		expect.statusLine(Matchers.containsString("No Content"));
		return expect;
	}

	public ResponseSpecification notFoundResponseSpec() {
		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(404);
		expect.statusLine(Matchers.containsString("Not Found"));
		expect.contentType(ContentType.JSON);
		expect.time(Matchers.lessThan(5000L));
		return expect;
	}

}

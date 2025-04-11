package Week3_Assignments;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class BaseClassPreCondititions_Jira {

	@BeforeTest
	public void intialSetUp() {

		baseURI = "https://senthilkumar104096.atlassian.net";
		basePath = "/rest/api/3";

	}

	public ResponseSpecification cretaeIssue() {

		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(201);
		expect.statusLine(Matchers.containsString("Created"));
		expect.contentType(ContentType.JSON);
		expect.time(Matchers.lessThan(5000L));
		return expect;
	}

	public ResponseSpecification updateIssue() {

		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(200);
		expect.statusLine(Matchers.containsString("OK"));
		expect.contentType(ContentType.JSON);
		expect.time(Matchers.lessThan(5000L));
		return expect;
	}

	public ResponseSpecification deleteIssue() {

		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(204);
		expect.statusLine(Matchers.containsString("No Content"));
		expect.time(Matchers.lessThan(5000L));
		return expect;
	}

	public ResponseSpecification getIssue() {
		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(200);
		expect.statusLine(Matchers.containsString("OK"));
		expect.contentType(ContentType.JSON);
		expect.time(Matchers.lessThan(5000L));
		return expect;

	}

}

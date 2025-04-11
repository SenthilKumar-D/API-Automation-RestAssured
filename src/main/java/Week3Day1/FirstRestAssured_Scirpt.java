package Week3Day1;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class FirstRestAssured_Scirpt {

	public static void main(String[] args) {
		
		/*
		 * Pre-Condition for the ServiceNow API Service:-
		 * Given()
		 * 
		 * URL = "https://dev242069.service-now.com/api/now/table/{tableName}"
		 * HTTP Method = GET
		 * Basic-Auth = username/password
		 * Set Path Parameter value as "incident"
		 * 
		 * Action:-
		 * When()
		 * 
		 * Send the GET request
		 * 
		 * Assertion:
		 * Then()
		 * 
		 * In RestAssured we used Hamcrest Library for Assertion
		 * 
		 *  1. Status Code
		 *  2. Status Line
		 *  3. Content Type
		 *  4. Response Time
		 * 
		 */
		
		RestAssured.given()
		           .auth()
		           .basic("admin","OnZewSi0!5Z*")
		           .pathParam("tableName", "incident")
		           .log().all()
		           .when()
		           .get("https://dev242069.service-now.com/api/now/table/{tableName}")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200)
		           .and()
		           .statusLine(Matchers.containsString("OK"))
		           .and()
		           .contentType(ContentType.JSON)
		           .and()
		           .time(Matchers.lessThan(5000L));	
		
	}

}

package Week3_Assignments;
import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CreateRequestWithRequestBodyAsFileTest {

	@Test
	public void CreateRequestWithRequestBodyAsFile() {
		
		baseURI = "https://dev242069.service-now.com";
		authentication = basic("admin", "OnZewSi0!5Z*");
			
		Response response = given()
		 .pathParam("tableName", "incident")
		 .header("Content-Type", "application/json")
		 .log().all()
		.when()
		 .body(new File("src\\main\\java\\Week3_Assignments\\PayloadbyFile.Json"))
		 .post("/api/now/table/{tableName}");
		/*.then()
		 .statusCode(201);
		 .and()
		 .contentType(ContentType.JSON)
		 .and()
		 .statusLine(Matchers.containsString("Created"))
		 .and()
		 .time(Matchers.lessThan(5000L));*/
		 
		System.out.println("Create Change Request Response: ");
		response.prettyPrint();

		
		

	}

}

package Week3_Assignments;
import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class CreateRequestWithRequestBodyAsString {

	public static void main(String[] args) {
		
		baseURI = "https://dev242069.service-now.com";
		authentication = basic("admin", "OnZewSi0!5Z*");
		
		String payload = """   
				{
				"description": "RESTOCT2024 as String",
			    "short_description": "Create a new incident using POST as String"
				
				}	
	                     """;	
		
		Response response = given()
		 .pathParam("tableName", "incident")
		 .header("Content-Type", "application/json")
		 .log().all()
		.when()
		 .body(payload)
		 .post("/api/now/table/{tableName}");
		/*.then()
		 .log().all()
		 .statusCode(201)
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

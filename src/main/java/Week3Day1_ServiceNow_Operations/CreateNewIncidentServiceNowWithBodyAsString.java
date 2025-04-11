package Week3Day1_ServiceNow_Operations;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateNewIncidentServiceNowWithBodyAsString {
	
	/*
	 * In Rest-Assures We can Pass the Request Body in 3 ways
	 * 
	 * 1. Pass request-body as a String
	 * 2. Pass request-body as a File
	 * 3. Pass request-body as a Object (POJO - Serialisation)
	 * 
	 */

	public static void main(String[] args) {
		
		String url = "https://dev242069.service-now.com/api/now/table/{tableName}";
		
		String userBody = """ 
				
			    {
				    "description": "RESTOCT2024 as String",
				    "short_description": "Create a new incident using POST as String"
				}
				
				""";
		
		
		given()
		    .auth()
		    .basic("admin","OnZewSi0!5Z*")
	        .pathParam("tableName", "incident")
	        .header("Content-Type","application/json")
	        .log().all()
	   .when()
	        .body(userBody)
	        .post(url)
	   .then()
	        .log().all()
	        .assertThat()
		    .statusCode(201)
	        .and()
	        .statusLine(containsString("Created"))
	        .and()
	        .contentType(ContentType.JSON)
	        .and()
	        .time(lessThan(5000L));	
	       
		// "sys_id": "a9cb9a0ac3b112106dc37addd401313d"	
		

	}

}

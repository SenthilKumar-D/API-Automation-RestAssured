package Week3_Assignments;
import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ManagingIncidentsinServiceNow {
	
	@BeforeTest
	public void setUp() {
		
		baseURI = "https://dev242069.service-now.com";
		basePath = "/api/now/table";
		authentication = basic("admin", "OnZewSi0!5Z*");
		
	}
	
	
	@Test (priority = 1)
	public void getAllIncidents() {
		
		Map <String, String> queryParam = new HashMap<String, String>();
		queryParam.put("sysparm_fields","sys_id,short_description");
		queryParam.put("sysparm_limit","3");
		
	Response response = given()
		 .pathParam("tableName", "incident")
		 .queryParams(queryParam)
		 .log().all()
	    .when()
	     .get("/{tableName}")
	     .then()
	     .assertThat()
	     .statusCode(200)
	     .extract()
	     .response();
	 
	//Print the response to the console
	System.out.println("Response for the getAllIncidents: ");
	response.prettyPrint();
	
	/*Print the status code of the response to the console.
	  Verify the status code to ensure it is 200 (OK).*/
	
	 int statuscode = response.getStatusCode();
	 System.out.println("Status code of the response: " + statuscode);
	
	 Assert.assertEquals(statuscode, 200,"incorrect status code returned");
		
	}
	
	
	@Test (priority = 2)
   public void updatingtheIncident() {
		
		
		Response response = given()
				 .pathParam("tableName", "incident")
				 .pathParam("sysId", "46b66a40a9fe198101f243dfbc79033d")
				 .header("Content-Type", "application/json")
				 .log().all()
			    .when()
			     .body(new File("src\\\\main\\\\java\\\\Week3_Assignments\\\\PayloadbyFile.Json"))
			     .put("/{tableName}/{sysId}")
		        .then()
		        .assertThat()
		        .statusCode(200)
		        .extract()
		        .response();
		
		 /*Print the status code of the response to the console.
		  Verify the status code to ensure it is 200 (OK).*/
		
		  int statuscode = response.getStatusCode();
		  System.out.println("Status code of the response: " + statuscode);
		
		  Assert.assertEquals(statuscode, 200,"incorrect status code returned");
		
		
	
		
	}	
	
	
	
	@Test (priority = 3)
	public void deletingtheIncident() {
		
		 Response response = given()
				 .pathParam("tableName", "incident")
				 .pathParam("sysId", "46b66a40a9fe198101f243dfbc79033d")
				 .log().all()
			    .when()
			     .delete("/{tableName}/{sysId}")
		        .then()
		        .assertThat()
		        .statusCode(204)
		        .extract()
		        .response();
		 
		 /*Print the status code of the response to the console.
		  Verify the status code to ensure it is 200 (OK).*/
		 
		  int statuscode = response.getStatusCode();
		  System.out.println("Status code of the response: " + statuscode);
		
		  Assert.assertEquals(statuscode, 204,"incorrect status code returned");
		
		
		
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

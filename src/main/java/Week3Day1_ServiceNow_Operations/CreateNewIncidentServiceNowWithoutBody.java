package Week3Day1_ServiceNow_Operations;

import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

//For Post method - always we need give header details in precondition

public class CreateNewIncidentServiceNowWithoutBody {

	public static void main(String[] args) {
		
		String url = "https://dev242069.service-now.com/api/now/table/{tableName}";
		
		given()
		    .auth()
		    .basic("admin","OnZewSi0!5Z*")
		    .pathParam("tableName", "incident")
		    .header("Content-Type","application/json")
		    .log().all()
	    .when()
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

		// "sys_id": "f769d2c6c3b112106dc37addd40131f8",
		
		
		
		
		
		
		

	}

}

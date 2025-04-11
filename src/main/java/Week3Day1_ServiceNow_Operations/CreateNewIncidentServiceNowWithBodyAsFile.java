package Week3Day1_ServiceNow_Operations;
import static org.hamcrest.Matchers.*;

import java.io.File;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateNewIncidentServiceNowWithBodyAsFile {

	public static void main(String[] args) {
		
		
    String url = "https://dev242069.service-now.com/api/now/table/{tableName}";
		

		
		given()
		    .auth()
		    .basic("admin","OnZewSi0!5Z*")
	        .pathParam("tableName", "incident")
	        .header("Content-Type","application/json")
	        .log().all()
	   .when()
	        .body(new File("src\\main\\resources\\request-body\\new_incident.json"))
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
		
		
	//"sys_id": "74e0e202c3f112106dc37addd40131df"
		
		
		
	}

}

package Week3Day1_ServiceNow_Operations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.http.ContentType;

public class CreateNewIncidentServiceNowWithBodyAsPojoObject {

	public static void main(String[] args) {
		
      String url = "https://dev242069.service-now.com/api/now/table/{tableName}";
		
      CreateIncidentPojo obj = new CreateIncidentPojo();
      obj.setDescription("RESTOCT2024 as POJO Obj");
      obj.setShort_description("Create a new incident using POST as POJO Obj");
		
		
		given()
		    .auth()
		    .basic("admin","OnZewSi0!5Z*")
	        .pathParam("tableName", "incident")
	        .header("Content-Type","application/json")
	        .log().all()
	   .when()
	        .body(obj)
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
	       
   //"sys_id": "e1722a82c3f112106dc37addd401312a"
		
		
		
		
	}

}

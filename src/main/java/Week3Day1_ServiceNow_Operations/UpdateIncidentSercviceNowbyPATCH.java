package Week3Day1_ServiceNow_Operations;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateIncidentSercviceNowbyPATCH {

	public static void main(String[] args) {
		
        String url = "https://dev242069.service-now.com/api/now/table/{tableName}/{sysId}";
        
        String requestBody = """        		
        		 {
        		   "short_description": "RESTAPIOCT2024 - Update PATCH",
        		   "description": "Hitting PATCH method with request body / request payload"
                 }        		
        		""";
        
        given()
           .auth()
           .basic("admin","OnZewSi0!5Z*")
           .pathParam("tableName", "incident")
           .pathParam("sysId", "1c741bd70b2322007518478d83673af3")
	       .header("Content-Type","application/json")
	       .log().all()
	   .when()
	       .body(requestBody)
	       .patch(url)
	   .then()
	       .log().all()
	       .assertThat()
	       .statusCode(200)
           .and()
           .statusLine(containsString("OK"))
           .and()
           .contentType(ContentType.JSON)
           .and()
           .time(lessThan(5000L));	
	    
	}

}

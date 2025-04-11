package Week3Day1_ServiceNow_Operations;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class DeleteIncidentSercviceNow {

	public static void main(String[] args) {
		
        String url = "https://dev242069.service-now.com/api/now/table/{tableName}/{sysId}";
        
        
        given()
           .auth()
           .basic("admin","OnZewSi0!5Z*")
           .pathParam("tableName", "incident")
           .pathParam("sysId", "a9cb9a0ac3b112106dc37addd401313d")
	       .header("Content-Type","application/json")
	       .log().all()
	   .when()
	       .delete(url)
	   .then()
	       .log().all()
	       .assertThat()
	       .statusCode(204)
           .and()
           .statusLine(containsString("No Content"))
           .and()
           .time(lessThan(5000L));	
	    
	}

}

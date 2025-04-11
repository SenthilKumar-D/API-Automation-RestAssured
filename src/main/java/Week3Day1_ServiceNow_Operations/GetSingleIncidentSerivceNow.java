package Week3Day1_ServiceNow_Operations;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleIncidentSerivceNow {

	public static void main(String[] args) {
		
		String url = "https://dev242069.service-now.com/api/now/table/{tableName}/{sysId}";
		
		given()
		     .auth()
		     .basic("admin","OnZewSi0!5Z*")
		     .pathParam("tableName", "incident")
		     .pathParam("sysId", "f769d2c6c3b112106dc37addd40131f8")
		     .log().all()
		.when()
		     .get(url)
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

package Week3Day2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class ServiceNowIncidentTableTest {
	
	@BeforeMethod
	public void setUp() {
		
		baseURI = "https://dev242069.service-now.com";
		basePath = "/api/now/table";
		authentication = basic("admin", "OnZewSi0!5Z*");
		
	}
		
	
	@Test
	public void shouldUserAbleToFetchAllIncidentRecords() {
		
		 given()
		   .pathParam("tableName", "incident")
		   .log().all()
		.when()
		   .get("/{tableName}")
	    .then()
	       .log().all()
	       .assertThat()
	       .statusCode(200);
		
	}
	
 @Test
	public void shouldUserAbleToFetchASingleIncidentRecord() {
		
		 given()
		   .pathParam("tableName", "incident")
		   .pathParam("sysId", "f769d2c6c3b112106dc37addd40131f8")
		   .log().all()
		.when()
		   .get("/{tableName}/{sysId}")
	    .then()
	       .log().all()
	       .assertThat()
	       .statusCode(200);
		
	}
		
	

}

package Week3Day2_Hooks;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class ServiceNowPostMethodXmlResponse extends TestNGHooks {

	@Test
	public void shouldUserAbleToCreateNewIncidentRecord() {
		
		  given()
		    .header("Content-Type", "application/json")
		    .header("Accept", "application/xml")
		    .pathParam("tableName", "incident")
		    .log().all()
		  .when()		  
		     .post("/{tableName}")
		  .then()
		      .log().all()
		      .assertThat()
		       .statusCode(201)
		       .and()
		       .contentType(ContentType.XML);
		
	}
	
}

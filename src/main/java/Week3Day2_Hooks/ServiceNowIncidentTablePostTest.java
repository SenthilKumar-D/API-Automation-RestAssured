package Week3Day2_Hooks;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class ServiceNowIncidentTablePostTest extends TestNGHooks {

	@Test
	public void shouldUserAbleToCreateNewIncidentRecord() {
		
		given()
		   .header("Content-Type", "application/json")
		   .pathParam("tableName", "incident")
		   .log().all()
		.when()
		 .post("/{tableName}")
		.then()
		  .log().all()
		  .assertThat()
		  .statusCode(201);
		
	// "sys_id": "ed635836c33912106dc37addd401312f"	
		
	}
		
}

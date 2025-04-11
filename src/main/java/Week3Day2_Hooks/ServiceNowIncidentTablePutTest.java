package Week3Day2_Hooks;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class ServiceNowIncidentTablePutTest extends TestNGHooks {

	@Test
	public void shouldUserAbleToCreateNewIncidentRecord() {
		
		given()
		   .header("Content-Type", "application/json")
		   .pathParam("tableName", "incident")
		   .pathParam("sysId", "ed635836c33912106dc37addd401312f")
		   .log().all()
		.when()
		 .put("/{tableName}/{sysId}")
		.then()
		  .log().all()
		  .assertThat()
		  .statusCode(200);
		
	// "sys_id": "ed635836c33912106dc37addd401312f"	
		
	}
		
}

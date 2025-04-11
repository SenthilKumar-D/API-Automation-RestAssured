package Week3Day2_Hooks;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ServiceNowPostMethodSysIdExtraction extends TestNGHooks{
	
	@Test
	public void shouldUserAbleToCreateNewIncidentRecord() {
	String sys_id =	given()
		               .header("Content-Type", "application/json")
		               .header("Accept", "application/json")
		               .pathParam("tableName", "incident") 
		               .log().all()
		            .when()
		               .post("/{tableName}")
		            .then()
		               .log().all()
		               .assertThat()
		               .statusCode(201)
		               .extract()
		               .jsonPath()
		               .getString("result.sys_id");
		
	System.out.println("sys_id: " + sys_id);
	
	}
	
	
	
	

}

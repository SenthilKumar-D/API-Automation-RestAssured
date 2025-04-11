package Week3Day2_Hooks;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

public class ServiceNowIncidentTableE2ETest extends TestNGHooks {

	private String tableName = "incident";

	@Test(priority = 0)
	public void userShouldAbleToCreateANewIncidentRecord() {

		SysId = given().header("Content-Type", "application/json").pathParam("tableName", tableName).when()
				.body(new File("src\\main\\resources\\request-body\\new_incident.json")).post("/{tableName}").then()
				.spec(createResponseSpec()).extract().jsonPath().getString("result.sys_id");

		System.out.println("SysId for the new incident: " + SysId);

	}

	@Test(priority = 1)
	public void userShouldAbleToGetASingleIncidentRecord() {

		given().pathParam("tableName", tableName).pathParam("sysId", SysId).when().get("/{tableName}/{sysId}").then()
				.spec(getResponseSpec());

	}

	@Test(priority = 2)
	public void userShouldAbleToUpdateAIncidentRecord() {

		given().pathParam("tableName", tableName).pathParam("sysId", SysId).when().put("/{tableName}/{sysId}").then()
				.spec(putResponseSpec());

	}

	@Test(priority = 3)
	public void userShouldAbleToDeleteExicistingIncidentRecord() {

		given().pathParam("tableName", tableName).pathParam("sysId", SysId).when().delete("/{tableName}/{sysId}").then()
				.spec(deleteResponseSpec());

	}

	@Test(priority = 4)
	public void userShouldAbleToSeeDeletedRecord() {

		given().pathParam("tableName", tableName).pathParam("sysId", SysId).when().delete("/{tableName}/{sysId}").then()
				.spec(notFoundResponseSpec());

	}

}

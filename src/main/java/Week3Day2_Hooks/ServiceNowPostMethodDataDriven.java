package Week3Day2_Hooks;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Week3Day1_ServiceNow_Operations.CreateIncidentPojo;

public class ServiceNowPostMethodDataDriven extends TestNGHooks{
	
	@DataProvider
	public Object[][] dataPayLoad(){
		return new Object[][] 
		{
			{"Description 1", "Short Description 1"},
			{"Description 2", "Short Description 2"}			
		};	
	}
	
		
	
	@Test(dataProvider = "dataPayLoad")
	public void shouldUserAbleToCreateNewIncidentRecord(String description, String shortDescription ) {
		
		CreateIncidentPojo obj1 = new CreateIncidentPojo();
		obj1.setDescription(description);
		obj1.setShort_description(shortDescription);
		
		
		
		given()
		   .header("Content-Type", "application/json")
		   .pathParam("tableName", "incident")
		   .log().all()
		.when()
		 .body(obj1)
		 .post("/{tableName}")
		.then()
		  .log().all()
		  .assertThat()
		  .statusCode(201);
	
	
	
	}	
	
	
	

}

package stepDefinitions;

import Week3Day1_ServiceNow_Operations.CreateIncidentPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateIncidentStepDefinition {

	Response post;
	CreateIncidentPojo obj = new CreateIncidentPojo();

	@Given("Set the baserURI and BasePath for ServiceNow Api")
	public void set_the_baser_uri_and_base_path_for_service_now_api() {

		RestAssured.baseURI = "https://dev242069.service-now.com";
		RestAssured.basePath = "/api/now/table";

	}

	@Given("Set the Authentication for the host")
	public void set_the_authentication_for_the_host() {

	RestAssured.authentication = RestAssured.basic("admin", "OnZewSi0!5Z*");

	}

	@When("Create the new incident without body")
	public void create_the_new_incident_without_body() {

		post = RestAssured.given()
				             .header("Content-Type", "application/json")
				             .pathParam("tableName", "incident")
				           .when()
				             .post("/{tableName}");
	}

	@Then("Print the Response body in the console")
	public void validate_the_response_body() {
		System.out.println("Response body of the Create incident: ");
		System.out.println(post.prettyPrint());

	}

	@Then("Validate the Status code for the response")
	public void validate_the_status_code_for_the_response() {

		post.then().assertThat().statusCode(201);
	}

	@When("/^Send the post request with the description (.*) in the payload$/")
	public void send_the_post_request_with_the_description_description_in_the_payload(String arg) {
		obj.setDescription(arg);
	}
	@When("/^Send the post request with the short description (.*) in the payload$/")
	public void send_the_post_request_with_the_short_description_short_description_in_the_payload(String arg) {
		obj.setShort_description(arg);
		
		post = RestAssured
				.given()
				 .log().all()
	             .header("Content-Type", "application/json")
	             .pathParam("tableName", "incident")
	           .when()
	             .body(obj)
	             .post("/{tableName}");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

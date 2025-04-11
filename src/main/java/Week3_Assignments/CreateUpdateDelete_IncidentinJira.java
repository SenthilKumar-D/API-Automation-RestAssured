  package Week3_Assignments;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CreateUpdateDelete_IncidentinJira extends BaseClassPreCondititions_Jira {

	public String id, issueKey;

	@BeforeTest
	public void setUp() {

		baseURI = "https://senthilkumar104096.atlassian.net";
		basePath = "/rest/api/3";

	}

    @Test(priority = 0)
	public void CreateanIncidentinJira() {

		File file = new File("src\\main\\resources\\request-body\\PayloadforJira_CreateIncident.Json");

		Response post = given()
				.auth()
				.preemptive()
				.basic("senthilkumar104096@gmail.com",
				"ATATT3xFfGF0Iv121z2NSraZClY3Gl8lnNX1o6vV71wp-gPOYoTd7WzM8GS0_kTGP3pMHN1hEkCAixQ273yO7CPHHzwE2J9BnRgqR6Lge9odX5AJc8NPTpf9_CSDq5lVD7bbOgnS7r64SkAX58-4QXRVB5vokFkj_Docj7oZiVpmIbVvefJkR_E=766B5471")
				.header("Content-Type", "application/json")
				.log().all()
				.when()
				.body(file)
				.post("/issue");
		
		//Print the response body and status code to the console.
		
		System.out.println("Respose body of the Create incident: ");
		System.out.println(post.asPrettyString());
		int statuscode = post.getStatusCode();
		System.out.println("Status code of the response: " + statuscode);
		
		//Extract the id and key from the response and save them as variables
		issueKey = post.jsonPath().getString("key");
		id = post.jsonPath().getString("id");
		post.then().assertThat().spec(cretaeIssue());

		System.out.println("IssueKey for the new story: " +issueKey);
		System.out.println("Id for the new story: " +id);

	}

	
	@Test(priority = 1)
	public void runGetCreatedIssue() {


		  Response get = given()
				.auth()
				.preemptive()
				.basic("senthilkumar104096@gmail.com",
				"ATATT3xFfGF0Iv121z2NSraZClY3Gl8lnNX1o6vV71wp-gPOYoTd7WzM8GS0_kTGP3pMHN1hEkCAixQ273yO7CPHHzwE2J9BnRgqR6Lge9odX5AJc8NPTpf9_CSDq5lVD7bbOgnS7r64SkAX58-4QXRVB5vokFkj_Docj7oZiVpmIbVvefJkR_E=766B5471")
				.pathParam("issueKey",issueKey )
				.log().all()
				.when()
				.get("/issue/{issueKey}");
		        
		        System.out.println("Respose body of the Create incident: ");
				System.out.println(get.asPrettyString());
		
				get.then().assertThat().spec(updateIssue());

	}

	
	
	@Test(priority = 2)
	public void runUpdateIssue() {

		File file = new File("src\\main\\resources\\request-body\\PayloadforJira_UpdateIncident.json");

		Response put = given()
				  .auth()
				  .preemptive()
				  .basic("senthilkumar104096@gmail.com",
				  "ATATT3xFfGF0Iv121z2NSraZClY3Gl8lnNX1o6vV71wp-gPOYoTd7WzM8GS0_kTGP3pMHN1hEkCAixQ273yO7CPHHzwE2J9BnRgqR6Lge9odX5AJc8NPTpf9_CSDq5lVD7bbOgnS7r64SkAX58-4QXRVB5vokFkj_Docj7oZiVpmIbVvefJkR_E=766B5471")
				  .header("Content-Type", "application/json")
				  .pathParam("issueKey",issueKey)
				  .queryParam("returnIssue", true)
				  .log().all()
				.when()
				  .body(file)
				  .put("/issue/{issueKey}");
		
		//Print the response body and status code to the console.
		
		System.out.println("Respose body of the Update incident: ");
		System.out.println(put.asPrettyString());
		
		int statuscode = put.getStatusCode();
		System.out.println("Status code of the response: " + statuscode);
		
		put.then().assertThat().spec(updateIssue());

	}

	
	
	@Test(priority=3)
	public void runDelete() {
		
	Response delete = given()
		    .auth()
		    .preemptive()
		    .basic("senthilkumar104096@gmail.com",
					"ATATT3xFfGF0Iv121z2NSraZClY3Gl8lnNX1o6vV71wp-gPOYoTd7WzM8GS0_kTGP3pMHN1hEkCAixQ273yO7CPHHzwE2J9BnRgqR6Lge9odX5AJc8NPTpf9_CSDq5lVD7bbOgnS7r64SkAX58-4QXRVB5vokFkj_Docj7oZiVpmIbVvefJkR_E=766B5471")
            .pathParam("issueKey",issueKey)
            .log().all()
           .when()
            .delete("/issue/{issueKey}");
           
	        delete.then().assertThat().spec(deleteIssue());	
		
		    int statuscode = delete.getStatusCode();
			System.out.println("Status code of the response: " + statuscode);
		
	}
	

	
}

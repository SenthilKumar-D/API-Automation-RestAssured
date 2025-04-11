package Week6Day2_WireMocker;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class PostMockinginTestng {
	
	WireMockServer mockServer;
	
	@BeforeMethod
	public void setUp() {
		
		mockServer = new WireMockServer(8188);
		mockServer.start();

		mockServer.stubFor(
    	WireMock.post("/creating")
    	        .withHeader("Content-Type", WireMock.equalTo("application/json"))
    	        .withRequestBody(WireMock.equalToJson("{\"Name\": \"SenthilKumar\"}"))
				.willReturn(
					WireMock.aResponse()
					 .withStatus(201)
					 .withHeader("Content-Type", "application/json")
					 .withBody("{\"code\":\"201\",\"message\":\"CREATED\"}")
				           )
		);
				
	}
	
	@AfterMethod	
	public void tearDown() {
		
	   mockServer.stop();		
		
		
	}
	
	@Test
	public void GetCallandTestMock() {
		
		RestAssured.given()
		.header("Content-Type","application/json")
		.log().all()
		.when()
		.body("{\"Name\": \"SenthilKumar\"}")
		.post("http://localhost:8188/creating")
		.then()
		.log().all()
		.assertThat()
		 .statusCode(201);
		
	}

}

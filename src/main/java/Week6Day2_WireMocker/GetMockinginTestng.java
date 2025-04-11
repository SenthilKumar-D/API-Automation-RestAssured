package Week6Day2_WireMocker;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class GetMockinginTestng {
	
	WireMockServer mockServer;
	
	@BeforeMethod
	public void setUp() {
		
		mockServer = new WireMockServer(8188);
		mockServer.start();

		mockServer.stubFor(
    	WireMock.get("/calling1")
				.willReturn(
					WireMock.aResponse()
					 .withStatus(200)
					 .withHeader("Content-Type", "application/json")
					 .withBody("{\"code\":\"200\",\"message\":\"OK\"}")
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
		.when()
		.get("http://localhost:8188/calling1")
		.then()
		.log().all();	
		
	}

}

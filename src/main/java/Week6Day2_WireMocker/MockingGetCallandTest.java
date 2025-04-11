package Week6Day2_WireMocker;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class MockingGetCallandTest {

	public static void main(String[] args) {

		WireMockServer mockServer = new WireMockServer(8183);
		mockServer.start();

		mockServer.stubFor(
    	WireMock.get("/Test1")
				.willReturn(
					WireMock.aResponse()
					 .withStatus(200)
					 .withBody("Test 1 Mock by Senthil")
				           )
		);

		RestAssured.given()
		.when()
		.get("/Test1")
		.then()
		.log().all();
		
		//mockServer.stop();


	}

}

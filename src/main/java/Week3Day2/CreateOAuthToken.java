package Week3Day2;
import static io.restassured.RestAssured.*;
public class CreateOAuthToken {

	public static void main(String[] args) {
		
	String accessToken =	given()
		  .headers("Content-Typr","application/x-www-form-urlencoded")
		.when()
		  .formParam("grant_type", "password")
		  .formParam("client_id", "6bc476f087954aaea6296080b9136217")
		  .formParam("client_secret", "PHRSg14[D)")
		  .formParam("username", "admin")
		  .formParam("password", "OnZewSi0!5Z*")
		  .post("https://dev242069.service-now.com/oauth_token.do")
		.then()
		  .log().all()
		  .extract()
		  .jsonPath()
		  .getString("access_token");
	
	System.out.println("The Access Token of Oauth is: " + accessToken);
		
		
	}

}

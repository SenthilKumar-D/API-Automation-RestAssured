package Week3Day2;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

public class GetMethodWithQueryParam {

	public static void main(String[] args) {
		
		String url = "https://dev242069.service-now.com/api/now/table/{tableName}";
		
		given()
		    .auth()
		    .basic("admin", "OnZewSi0!5Z*")
		    .pathParam("tableName", "incident")
		    .queryParam("sysparm_limit", "50")
		    .queryParam("sysparm_fields", "number,description")
		    .log().all()
		.when()
		    .get(url)
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.and()
		.time(Matchers.lessThan(5000L));

	}

}

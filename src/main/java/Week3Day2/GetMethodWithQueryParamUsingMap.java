package Week3Day2;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;

public class GetMethodWithQueryParamUsingMap {

	public static void main(String[] args) {
		
		String url = "https://dev242069.service-now.com/api/now/table/{tableName}";
		
		Map <String,String> queryparam = new HashMap <String,String>();
		queryparam.put("sysparm_limit", "5");
		queryparam.put("sysparm_fields", "number,description");
		
		given()
		    .auth()
		    .basic("admin", "OnZewSi0!5Z*")
		    .pathParam("tableName", "incident")
		    .queryParams(queryparam)
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

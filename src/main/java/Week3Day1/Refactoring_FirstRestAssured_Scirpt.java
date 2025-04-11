package Week3Day1;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;


public class Refactoring_FirstRestAssured_Scirpt {

	public static void main(String[] args) {
		
		String url = "https://dev242069.service-now.com/api/now/table/{tableName}";
		
		given()
        .auth()
        .basic("admin","OnZewSi0!5Z*")
        .pathParam("tableName", "incident")
        .log().all()
        .when()
        .get(url)
        .then()
        .log().all()
        .assertThat()
        .statusCode(200)
        .and()
        .statusLine(containsString("OK"))
        .and()
        .contentType(ContentType.JSON)
        .and()
        .time(lessThan(5000L));	

	}

}

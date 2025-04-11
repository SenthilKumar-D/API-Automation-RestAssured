package Week3Day1_ServiceNow_Operations;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleIncidentSerivceNowTest {

	@Test
	public void shouldUserAbleToFetchSignleIncidentRecord() {

		String url = "https://dev262949.service-now.com/api/now/table/{tableName}/{sysId}";
		
		given()
		  .auth()
		  .basic("admin", "vW0eDfd+A0V-")
		  .pathParam("tableName", "incident")
		  .pathParam("sysId", "f769d2c6c3b112106dc37addd40131f8")
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
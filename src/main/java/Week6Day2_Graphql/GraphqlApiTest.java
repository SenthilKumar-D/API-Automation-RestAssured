package Week6Day2_Graphql;

import org.apache.commons.lang3.compare.ObjectToStringComparator;
import org.json.JSONObject;

import io.restassured.RestAssured;

public class GraphqlApiTest {

	static String inputQuery = """

							query {
			  viewer {
			    login
			    url
			    repositories {
			      totalCount
			        }
			    followers {
			      totalCount
			        }
			    url
			    avatarUrl
			    location
			    company
			    }
			}

							""";
	
	
public static void main(String[] args) {

		RestAssured.given()
		           .log().all()
		           .header("Authorization","Bearer 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")
		           .when()
		           .body(ConvertQueryintoJson(inputQuery))
		           .post("https://api.github.com/graphql")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200);			

	}


public static String ConvertQueryintoJson(String value) {
	
	JSONObject inputObject = new JSONObject();
	inputObject.put("query", value);
	return inputObject.toString();
	
}




















}

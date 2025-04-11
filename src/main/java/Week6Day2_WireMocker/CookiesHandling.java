package Week6Day2_WireMocker;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CookiesHandling {

	public static void main(String[] args) {
		
		String url = "https://dev250082.service-now.com/api/now/table/{tableName}";
		String Sys_id = "/1c741bd70b2322007518478d83673af3";
		
		
		Response response = RestAssured.given()
		           .auth()
		           .basic("admin", "G6zc8aXQj*-O")
		           .pathParam("tableName", "incident")
		           .log().all()
		           .when()
		           .get(url);
		
		
		Map<String, String> cookies = response.getCookies();
		for (Entry<String, String> map : cookies.entrySet()) {
			System.out.println(map.getKey() +"="+ map.getValue());
		}
		
		//To get the JsessionId
		String JSESSIONID = response.getCookie("JSESSIONID");
        System.out.println("JSESSIONID: " + JSESSIONID);
        
        RestAssured.given()
                    .pathParam("tableName", "incident")
                    .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                    .log().all()
                    .when()
                    .get(url + Sys_id)
                    .then()
                    .assertThat()
                    .statusCode(200);
               
        
        RestAssured.given()
        .pathParam("tableName", "incident")
        .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
        .header("Content-Type", "application/json")
        .log().all()
        .when()
        .post(url)
        .then()
        .log().all();
        
        
        
          
        
        
        
	}
	
	
	
}

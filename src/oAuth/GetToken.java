package oAuth;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetToken {
	
	
	public String getAccessTokenFromOAuth2() throws JSONException {
	    Response response =
	            RestAssured.given()
	                    .baseUri("http://localhost:8088/")
	                    .auth().preemptive().basic("rest-assured", "password")
	                    .contentType("application/x-www-form-urlencoded")
	                    .formParam("grant_type", "password")
	                    .formParam("username", "onlyfullstack")
	                    .formParam("password", "secret")
	                    .when()
	                    .post("/oauth/token");
	    System.out.println("OAuth Response - " + response.getBody().asString());
	    JSONObject jsonObject = new JSONObject(response.getBody().asString());
	    String accessToken = jsonObject.get("access_token").toString();
	    String tokenType = jsonObject.get("token_type").toString();
	    System.out.println("Oauth Token with type " + tokenType + "   " + accessToken);
	    return accessToken;
	}
	
	
    public void callOAuth2ProtectedApi() throws JSONException {
        String accessToken = getAccessTokenFromOAuth2();
       
        Response response = RestAssured.given()
                .auth()
                .oauth2(accessToken)
                .baseUri("http://localhost:8088")
                .body("/students")
                .when()
                .get("/students");
        
        System.out.println("Student api Response - " + response.then().extract().asString());
       
    }
    
    @Test
    public void callOAuth2ProtectedApi1() throws JSONException {
        String accessToken = getAccessTokenFromOAuth2();
       
        Response response = RestAssured.given()
        		.contentType(ContentType.JSON)
                .auth()
                .oauth2("7acf0f6228c9d936fa73bfc7ea8e57d8739662f7")
                .baseUri("https://api.github.com/user")
                .body("{\r\n"
                		+ "    \"name\": \"Postman3\",\r\n"
                		+ "    \"desription\": \"Test Repo\",\r\n"
                		+ "    \"homepage\": \"https://github.com/\",\r\n"
                		+ "    \"private\": false,\r\n"
                		+ "    \"has_issues\": true,\r\n"
                		+ "    \"has_projects\": true,\r\n"
                		+ "    \"has_wiki\": true\r\n"
                		+ "\r\n"
                		+ "}")
                .when()
                .post("/repos");
        
        System.out.println("GitHub api Response - " + response.then().extract().asString());
       
    }
}

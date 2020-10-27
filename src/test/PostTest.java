package test;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostTest {
	
	final static String url = "http://localhost:3000/employees";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Response response = given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\"name\": \"Lisa\",\"salary\": \"2000\"}")
				.when()
				.post(url + "/create");
		System.out.println("POST Response\n" + response.asString());
		// tests
		response.then().body("id", Matchers.any(Integer.class));
		response.then().body("name", Matchers.is("Lisa"));

	}

}

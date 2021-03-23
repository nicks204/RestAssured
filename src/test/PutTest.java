package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

public class PutTest {

	final static String url = "http://localhost:3000/employees";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\"name\": \"Lisa Tamaki\",\"salary\": \"20000\"}")
				.when()
				.put(url+ "/update/3");
		System.out.println("PUT Response\n" + response.asString());
		// tests
		response.then().body("id", Matchers.is(3));
		response.then().body("name", Matchers.is("Lisa Tamaki"));
		response.then().body("salary", Matchers.is("20000"));

	}

}

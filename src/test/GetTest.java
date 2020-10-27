package test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;


public class GetTest {

	final static String url = "http://localhost:3000/employees";
	
	public static void main(String[] args) {
	
		
		given().
		when().
			get(url).
		then().
		log().
		all();

	}

}

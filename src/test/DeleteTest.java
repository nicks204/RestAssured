package test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;

import org.hamcrest.Matchers;

public class DeleteTest {

	final static String url = "http://localhost:3000/employees";
	
	public static void main(String[] args) {
		
		
		Response response = delete(url + "/delete/3");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		// check if id=3 is deleted
		response = get(url + "/list");
		System.out.println(response.asString());
		response.then().body("id", Matchers.not(3));

	}

}

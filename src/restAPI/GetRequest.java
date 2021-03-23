package restAPI;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://chercher.tech/sample/api/books.xml";
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		
		String responseBody = response.xmlPath().getString("bookstore.book.title[1]");
		System.out.println("Response Body is =>  " + responseBody);

	}

}

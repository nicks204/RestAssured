package test;

import static io.restassured.RestAssured.given;

public class GetTestWithParam {

	final static String url = "http://localhost:3000/employees";
	
	public static void main(String[] args) {
	
		
		given().
			queryParam("id","1").
		when().
			get(url).
		then().
		log().
		body();
		

	}
}

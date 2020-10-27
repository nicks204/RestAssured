package test;

import static io.restassured.RestAssured.given;

public class ResponseTest {
	
	final static String url = "http://localhost:3000/employees";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int statusCode= given().queryParam("id","1")
		           .when().get("http://localhost:3000/employees").getStatusCode();
		
		System.out.println("The response status is "+statusCode);
		
		given().
		when().
			get(url).
		then().
		assertThat().
		statusCode(200);

	}

}

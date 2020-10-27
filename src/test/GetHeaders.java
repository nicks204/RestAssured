package test;
import static io.restassured.RestAssured.*;

public class GetHeaders {
	final static String url = "http://localhost:3000/employees";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		System.out.println("The headers in the response "+
                 get(url).then().extract()
         .headers());

	}

}

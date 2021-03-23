package test;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class XMLResponse {
	
	String URL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Response response = given().
				contentType(ContentType.XML)
				.accept(ContentType.XML)
				.body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
						+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
						+ "  <soap:Body>\r\n"
						+ "    <CapitalCity xmlns=\"http://www.oorsprong.org/websamples.countryinfo\">\r\n"
						+ "      <sCountryISOCode>AUS</sCountryISOCode>\r\n"
						+ "    </CapitalCity>\r\n"
						+ "  </soap:Body>\r\n"
						+ "</soap:Envelope>")
				.when()
				.post();
		
	}

}

package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployee {
	
	public Logger logger;
	RequestSpecification request;
	Response response;
	
	@Before
	public void setup() {
		
		logger =Logger.getLogger("EmployeesRestAPI");
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		logger.info("********statrt of GetAllEmployees class**********");
		request = RestAssured.given();
		request.baseUri("http://localhost:8088");
		response = request.get("/employees");
	}
	
	@Test
	public void checkResponseBody() {
		logger.info("*******Inside checkResponseBody*******");
		String responseBody=response.getBody().asString();
		logger.info("Response Body ==> "+responseBody);
		Assert.assertTrue(responseBody!=null);
	}

	
	@Test
	public void checkStatusCode() {
		logger.info("****Inside checkStatusCode*******");
		int statusCode=response.getStatusCode();
		logger.info("StatusCode ==>"+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void checkContentType() {
		logger.info("********Inside checkContentType*********");
		String contentType=response.header("Content-Type");
		logger.info("Content type is ==>"+contentType);
		Assert.assertEquals(contentType, "application/json;charset=UTF-8");
	}



}

package xmlresponse;



import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;


public class XMLValuesExtraction {
	
	@Test
	public void test1() {

		String book = RestAssured.given().when()
				.get("https://chercher.tech/sample/api/books.xml")
				.then().extract().xmlPath().getString("bookstore.book.title");
		
		System.out.println(book);
	}
	
	
	@Test
	public void test2() {
		NodeChildrenImpl books = RestAssured.given().when()
		.get("https://chercher.tech/sample/api/books.xml")
		.then().extract().path("bookstore.book.title");

		System.out.println("just single string: "+ books);
		System.out.println("spcific index : "+ books.get(0));
		System.out.println("is empty : "+ books.isEmpty());
		System.out.println("size : "+ books.size());
		System.out.println("list : "+ books.list());
	}
	
	
	@Test
	public void test3() {
		NodeChildrenImpl books = RestAssured.given().when()
		.get("https://chercher.tech/sample/api/books.xml")
		.then().extract().path("bookstore.book");

		System.out.println("name : "+ books.get(0).name());
		System.out.println("attributes : "+ books.get(0).attributes());
		System.out.println("getAttribute : "+ books.get(0).getAttribute("category"));
		System.out.println("get : "+ books.get(0).get("year"));
		System.out.println("children : "+ books.get(0).children());
		System.out.println("children : "+ books.get(0).children().get("price"));
		System.out.println("getNode : "+ books.get(0).getNode("price").children().get(0));
	}
	
	

}

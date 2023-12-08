package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class EcommerceAPITest {

	public static void main(String[] args) {
		
		
		new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		

	}

}

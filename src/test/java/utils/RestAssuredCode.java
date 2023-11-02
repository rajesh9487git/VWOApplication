package utils;


import org.apache.xmlbeans.impl.xb.xsdschema.All;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class RestAssuredCode {
	
	
	public static void main(String[] args) {
		
		createEmailId();
		
	}
	
	public static void createEmailId() {
		
		Response response = (Response) RestAssured
				.given()
				.header("Content-Type", "application/ld+json")
				.body("{\r\n"
						+ "  \"address\": \"rajesh23341212112111@hexv.com\",\r\n"
						+ "  \"password\": \"password\"\r\n"
						+ "}")
				.when()
				.post("https://api.mail.gw/accounts").then().log().all().assertThat().statusCode(201);
		       
				
	}

}

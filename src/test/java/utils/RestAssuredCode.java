package utils;

import org.apache.xmlbeans.impl.xb.xsdschema.All;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class RestAssuredCode {

	public static void main(String[] args) {

		createEmailId();

	}

	public static String createEmailId() {

		String response = RestAssured.given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "  \"address\": \"rajesh2334761111232211232322@hexv.com\",\r\n"
						+ "  \"password\": \"password\"\r\n" + "}")
				.when().post("https://api.mail.gw/accounts").then().log().all().assertThat().statusCode(201).extract()
				.response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);

		String address = js.getString("address");

		System.out.println("The address is " + address);

		return address;

	}

}

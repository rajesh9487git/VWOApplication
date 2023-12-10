package utils;

import io.restassured.builder.RequestSpecBuilder;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class EcommerceAPITest {

	public static void main(String[] args) {

		// Login

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		RequestSpecification reqLogin = given().relaxedHTTPSValidation().log().all().spec(req).body(payload.login());

		String loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response()
				.asString();

		System.out.println(loginResponse);

		JsonPath js = new JsonPath(loginResponse);
		String userId = js.getString("userId");
		String token = js.getString("token");

		System.out.println("The user id is " + userId);

		// Add Product

		RequestSpecification req1 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).build();

		RequestSpecification addProduct = given().log().all().spec(req1).param("productName", "Laptop")
				.param("productAddedBy", userId).param("productCategory", "fashion")
				.param("productSubCategory", "shirts").param("productPrice", "11500")
				.param("productDescription", "Lenova").param("productFor", "men")
				.multiPart("productImage", new File("D:\\Image\\LaptopImage.jpeg"));

		String addProductResponse = addProduct.when().post("/api/ecom/product/add-product").then().log().all().extract()
				.response().asString();

		JsonPath js1 = new JsonPath(addProductResponse);
		String productId = js1.get("productId");

		// Create Order

		RequestSpecification req2 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();

		RequestSpecification createOrderReq = given().log().all().spec(req2).body(payload.createOrder(productId));

		String createOrderResponse = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all()
				.extract().response().asString();

		System.out.println(createOrderResponse);
		
		// Delete order
		
		RequestSpecification req3=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization", token).
		setContentType(ContentType.JSON).build();
		

		
		RequestSpecification deleteProdReq =given().log().all().spec(req3).pathParam("productId",productId);

		String deleteProductResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().
		extract().response().asString();

		
		JsonPath js3= new JsonPath(deleteProductResponse);
		
		System.out.println("======================================================================");
		
		System.out.println(deleteProductResponse);
		
		Assert.assertEquals("Product Deleted Successfully", js3.getString("message"));
		
		

	}

}

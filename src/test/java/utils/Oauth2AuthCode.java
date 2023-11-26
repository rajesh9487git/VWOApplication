package utils;
import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class Oauth2AuthCode {

	public static void main(String[] args) {
		
		
	
		// need to run the below url manually and replace the URL value for each run
		
		// "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php"
		
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXn6CYbxnFIEuEHpRlALfxMAvNDjXsxtURklXqCthPhiX4TjpyH7pYaStBRVc3iKKQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialCode= url.split("code=")[1];
		
		String code= partialCode.split("&scope")[0];
		
	System.out.println(code);
	
	
	String response= given().log().all()
	.urlEncodingEnabled(false)
	.queryParams("code", code)
	.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	.queryParams("grant_type", "authorization_code")

    .queryParams("state", "verifyfjdss")

    .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
    .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
    .when()
     .log().all()
     .post("https://www.googleapis.com/oauth2/v4/token").asString();
	
	System.out.println("====================================================");
		
		
		System.out.println("the Response is ===================="+ response);
		
		System.out.println("====================================================");
		
		JsonPath js = new JsonPath(response);
		
		
		
		String accessToken= js.getString("access_token");
		
		System.out.println("the access token is =================="+accessToken);
		
		
		String r2= given().contentType("application/json")
		.queryParams("access_token",accessToken )
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php")
		.asString();
		
		System.out.println(r2);

	}

}

package utils;

public class payload {
	
	public static String coursePrice() {
		
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}";
	}
	
	public static String login() {
		
		
				
				
				String Login= "{\r\n"
				+ "    \"userEmail\": \"rajesh9487@gmail.com\",\r\n"
				+ "    \"userPassword\": \"Money4money@\"\r\n"
				+ "}";
				
				return Login;
		
		
	}
	
	
	public static String createOrder(String productID) {
		
		String createOrder= "{\r\n"
				+ "  \"orders\": [\r\n"
				+ "    {\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"productOrderedId\": \""+productID+"\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		return createOrder;
	}

}

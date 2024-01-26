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
	
	
	public static String guru99JsonData() {
		
		String data = "{\"result\":{\"statements\":[{\"TRANSACTION_ID\":\"12\",\"ACCOUNT_NO\":\"1\",\"DATE_OF_TRANSACTION\":\"2013-11-16\",\"AMOUNT\":\"500\",\"TRANSACTION_TYPE\":\"D\",\"DESCRIPTION\":\"Initial Deposit\"},{\"TRANSACTION_ID\":\"23\",\"ACCOUNT_NO\":\"1\",\"DATE_OF_TRANSACTION\":\"2013-11-17\",\"AMOUNT\":\"14\",\"TRANSACTION_TYPE\":\"t\",\"DESCRIPTION\":\"yi Tansfer From 14\"},{\"TRANSACTION_ID\":\"25\",\"ACCOUNT_NO\":\"1\",\"DATE_OF_TRANSACTION\":\"2013-11-18\",\"AMOUNT\":\"1\",\"TRANSACTION_TYPE\":\"t\",\"DESCRIPTION\":\"hgg Tansfer From 15\"},{\"TRANSACTION_ID\":\"49745\",\"ACCOUNT_NO\":\"1\",\"DATE_OF_TRANSACTION\":\"2017-04-13\",\"AMOUNT\":\"0\",\"TRANSACTION_TYPE\":\"t\",\"DESCRIPTION\":\"0 Tansfer From 1\"},{\"TRANSACTION_ID\":\"94867\",\"ACCOUNT_NO\":\"1\",\"DATE_OF_TRANSACTION\":\"2018-11-21\",\"AMOUNT\":\"500\",\"TRANSACTION_TYPE\":\"t\",\"DESCRIPTION\":\"cash Tansfer From 14\"}]},\"message\":{\"ErrorCode:\":0,\"ErrorMsg:\":\"Success\"}}";
		
		return data;
		
		
		// below is the url to hit in the browser to get the payload
		//https://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1
	}

	
}

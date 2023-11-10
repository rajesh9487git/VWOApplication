package utils;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class APIAutomationPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(payload.coursePrice());

		// 1. Print No of courses returned by API

		int courseSize = js.getInt("courses.size()");

		System.out.println(courseSize);

		// 2.Print Purchase Amount

		int totalAmount = js.getInt("dashboard.purchaseAmount");

		System.out.println(totalAmount);

		String titleFirstCourse = js.getString("courses[0].title");

		System.out.println(titleFirstCourse);

		// Print All course titles and their respective Prices

		for (int i = 0; i < courseSize; i++) {

			String courseTitles = js.get("courses[" + i + "].title");
			int coursePrices = js.get("courses[" + i + "].price");
			System.out.println(courseTitles + "=" + coursePrices);
		}

		// 5. Print no of copies sold by RPA Course

		for (int i = 0; i < courseSize; i++) {
			String courseTitles = js.get("courses[" + i + "].title");

			if (courseTitles.equalsIgnoreCase("Cypress")) {

				int rpaPrice = js.getInt("courses[" + i + "].copies");
				System.out.println("The no of copies sold are " + rpaPrice);
				break;

			}

		}

		// 6. Verify if Sum of all Course prices matches with Purchase Amount
		int expectedPurchaseAmount=js.getInt("dashboard.purchaseAmount");
		
		int actualPurchaseAmount = 0;

		for (int i = 0; i < courseSize; i++) {

			int price = js.getInt("courses[" + i + "].price");
			int copies = js.getInt("courses[" + i + "].copies");

			int individualCopyPrice = price * copies;

			actualPurchaseAmount = actualPurchaseAmount + individualCopyPrice;

		}

		System.out.println("The actual purchase amount is " + actualPurchaseAmount);
		Assert.assertEquals(actualPurchaseAmount, expectedPurchaseAmount);

	}

}

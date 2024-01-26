package apiPractice;

import java.io.File;
import java.util.ArrayList;

import io.restassured.path.json.JsonPath;
import utils.payload;

public class JsonPathPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		JsonPath j = new JsonPath(payload.guru99JsonData());
//
//		int statementsSize = j.getInt("result.statements.size()");
//
//		System.out.println(statementsSize);
//
//		int totalAmount = 0;
//
//		for (int i = 0; i < statementsSize; i++) {
//
//			int amount = j.getInt("result.statements[" + i + "].AMOUNT");
//
//			totalAmount = totalAmount + amount;
//
//		}
//		System.out.println(totalAmount);

		JsonPath j = new JsonPath(payload.guru99JsonData());

		int statementsSize = j.get("result.statements.size()");

		for (int i = 0; i < statementsSize; i++) {

			int transactionId = j.getInt("result.statements[" + i + "].TRANSACTION_ID");
			System.out.println(transactionId);

		}
		
		for (int i = 0; i < statementsSize; i++) {

			String descripton = j.get("result.statements[" + i + "].DESCRIPTION");
			System.out.println(descripton);

		}
		
		

	}

}

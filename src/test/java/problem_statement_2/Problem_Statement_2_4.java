package problem_statement_2;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Problem_Statement_2_4 {

	public static void main(String[] args) {
		RestAssured.baseURI="https://bookstore.demoqa.com/";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/BookStore/v1/Books");
		
		int statusCode = response.getStatusCode();
		long responseTime = response.getTime();
		System.out.println("Response Time: "+responseTime+" miliseconds");

		if(statusCode==200)
		{
			System.out.println("The application is up");
		}
		else
		{
			System.out.println("The application is down");
		}
				
	}

}

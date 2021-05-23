package tests;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class Practice01 extends HerokuappBaseUrl {

     /*
        When
		     I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
		 Then
		     HTTP Status Code should be 200
		 And
		     Content Type should be JSON
		 And
		     Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get03(){
        //1. Set the url
        String url = "https://restful-booker.herokuapp.com/booking/3";
        //2. Set the expected data

        //3. Set the automation send the Get request
        Response response = given().when().get(url);
        response.prettyPrint();
        //4. Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");

        System.out.println("status code: " +response.getStatusCode());
        System.out.println("status line: "+response.getStatusLine());
        System.out.println("content type: "+response.getContentType());

    }
    /*
    When
		 I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/1001
	Then
		HTTP Status code should be 404
	And
		Status Line should be HTTP/1.1 404 Not Found
		And
	     Response body contains “Not Found”
	  And
	     Response body does not contain “TechProEd”
	  And
	      Server is "Cowboy"
     */
    @Test
    public void get04(){
    //1. set url
        spec.pathParams("first","booking",
                        "second",1001);
        //2. set the expected data

        //3. Send the request
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Assertion
        response.
                then().
                assertThat().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");
                assertTrue(response.asString().contains("Not Found"));
                assertFalse(response.asString().contains("TechProEd"));
                assertEquals(response.getHeader("Server"), "Cowboy");

        System.out.println("status code: "+response.getStatusCode());
        System.out.println("status line: "+response.getStatusLine());


    }






}

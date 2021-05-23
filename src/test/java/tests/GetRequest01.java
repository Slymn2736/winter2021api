package tests;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
public class GetRequest01 {
    /*
        ==Gherkin Language==
        "Given" :It declares prerequisites
        "When"  : It defines action which user will perform
        "Then"  : Talk about outputs
        "And"   : In any part of multiple things we can use And
     */

    /*
       When
           I send a GET Request to the URL https://api-techproed-test.herokuapp.com/courses
       Then
           HTTP Status Code should be 200
       And
           Content Type should be JSON
       And
           Status Line should be HTTP/1.1 200 OK
   */

    @Test
    public void get01(){
        //Follow these 4 steps in every API Testing:
        //1. Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses";

        //2. Set the expected data (we will learn it later)

        //3. Send the request (like click on send button in Postman)
        Response response = given().
                                accept("application/json").
                            when().
                                get(url);
        //If you use "application/json", it means you want to see response body in json format
        //It is not must use, but som APIs might create problem if you don't use it.

        //to print response body use prettyPrint()
        response.prettyPrint();


        //4. Assert the things which are given in the test case
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");

            /*
            Note: If execution stops first error, it is called "hard assertion"
                If execution does not stop for any error it is called "soft assertion"
                In soft assertion you can get seperate reports for each error.
                assertThat() is hard assertion
             */
        // How to print content-type, status code, status line...
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());
        System.out.println(response.getHeaders());

    }



}

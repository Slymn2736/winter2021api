package get_method;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static org.junit.Assert.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest06 {
    /*
  When
            I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5
    Then
        HTTP Status Code should be 200
        And response content type is “application/JSON”
        And response body should be like;
        { “firstname”: “Sally”,
          “lastname”: “Ericsson”,
          “totalprice”: 111,
          “depositpaid”: false,
          “bookingdates”: { “checkin”: “2017-05-23",
                            “checkout”:“2019-07-02" }
        }
   */
    @Test
    public void get01(){
        //1. set the url
        String url = "https://restful-booker.herokuapp.com/booking/5";
//        spec.pathParams("first", "booking",
//                         "second",5);
        //2. Set the expected data

        //3. Send the request
        Response response = given().when().get(url);
        response.prettyPrint();

        //4. Assert the output
        //1. Way
//        response.
//                then().
//                assertThat().
//                statusCode(200).
//                contentType(ContentType.JSON).
//                body("firstname", equalTo("Mark"),
//                        "lastname", equalTo("Jones"),
//                        "totalprice", equalTo(576),
//                        "depositpaid", equalTo(false),
//                        "bookingdates.checkin", equalTo("2020-12-21"),
//                        "bookingdates.checkout", equalTo("2021-01-27"));

        //JsonPath is used to navigate inside Json Data
        JsonPath json = response.jsonPath();

        //2. Way
//        assertEquals("Status code is not matching",200,response.getStatusCode());
//        assertEquals("Content type is not json","application/json; charset=utf-8",response.getContentType());
//        assertEquals("Firstname is not matching","Sally",json.getString("firstname"));
//        assertTrue("Lastname is not matching", json.getString("lastname").equals("Jackson"));
//        assertTrue("Total price is not matching", json.getInt("totalprice")==126);
//        assertTrue("Deposite paid is not matching",json.getBoolean("depositpaid")==true);
//        assertEquals("Checking date is not matching","2020-04-09" ,json.getString("bookingdates.checkin"));
        //assertEquals("Checkout date is not matching", json.getString("bookingdates.checkout").equals("2020-09-28"));

        //3. Way
        /*
            SoftAssertion(Verification):Execution is not stopped in failure
            To use Soft assertion we have 3 steps:
            1)Create an object from SoftAssert Class
            2)By using the object, use assertEquals(), assertTrue(), and assertFalse()
            3)DO NOT FORGET to type "assertAll()" method at the end
         */
        //1)Create an object from SoftAssert Class
        SoftAssert softAssert = new SoftAssert();

        //2)By using the object, use assertEquals(), assertTrue(), and assertFalse()
        //softAssert.assertEquals(json.getString("firstname"),"Sally","Firstname is not matching");
       // softAssert.assertEquals(json.getString("lastname"),"Jones","Lastname is not matching");
        // softAssert.assertEquals(json.getInt("totalprice"),666,"Total price is not matching");
        softAssert.assertEquals(json.getBoolean("depositpaid"),true,"depositpaid is not matching");
        //softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-09-20","Booking checkin is not matching");
        //softAssert.assertEquals(json.getString("bookingdates.checkout"),"2021-01-22","Booking checkout is not matching");

        //3)DO NOT FORGET to type "assertAll()" method at the end
       softAssert.assertAll();

    }
}

package get_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuappTestData;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class GetRequest10dt extends HerokuappBaseUrl {
    /*
     When
        I send GET Request to "https://restful-booker.herokuapp.com/booking/1"
     Then
        Response body should be like that;
        {
  {
    "firstname": "Susan",
    "lastname": "Wilson",
    "totalprice": 457,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2016-05-10",
        "checkout": "2019-06-03"
    },
    "additionalneeds": "Breakfast"
}
     */
    @Test
    public void get01(){
        spec.pathParams("bookingName","booking",
                        "id", 1);
        HerokuappTestData expectedDataObj = new HerokuappTestData();
        Map<String, Object> expectedDataMap = expectedDataObj.setUpData();

        Response response = given().spec(spec).when().get("/{bookingName}/{id}");

        response.prettyPrint();

        //Use De-Serialization:
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));
        assertEquals(expectedDataMap.get("additionalneeds"),actualDataMap.get("additionalneeds"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"),((Map)actualDataMap.get("bookingdates")).get("checkout"));






    }




}

package get_method;

import base_urls.JsonPlaceHolderBaseUrl;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class GetRequest09dt extends JsonPlaceHolderBaseUrl {

    /*
        De-Serialization=> Converting Json data to Java Object
        Serialization => Converting Java object to Json data

        1)Using GSON
        2)Using Object Mapper
     */
    /*
        When
            I send GET Request to https://jsonplaceholder.typicode.com/todos/2
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
     */
    @Test
    public void get01(){
        //1. Set the URL
        spec.pathParams("first","todos","second",2);

        //2. Set the expected data
//        JsonPlaceHolderTestData expectedDataObj = new JsonPlaceHolderTestData();
//        Map<String, Object> expectedDataMap =  expectedDataObj.setUpData();
//
//        //3. Send the request
//        Response response = given().spec(spec).when().get("/{first}/{second}");
//        response.prettyPrint();
//
//        //4. Assertion
//        Map<String, Object>actualDataMap = response.as(HashMap.class);
//        System.out.println(actualDataMap);
//
//        assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());
//        assertEquals(expectedDataMap.get("Completed"),actualDataMap.get("Completed"));
//        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
//        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
//        assertEquals(expectedDataMap.get("Via"),response.getHeader("Via"));
//        assertEquals(expectedDataMap.get("Server"),response.getHeader("Server"));


    }






}

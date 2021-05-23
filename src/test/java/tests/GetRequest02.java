package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest02 {
    /*
        When I send a GET request to REST API URL
        "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367"
        And Accept type is “application/JSON”
        Then
        HTTP Status Code should be 200
        And Response format should be "application/JSON"
           for the course whose id is "608bb976c9e4a800151ab367"
        And "code" should be "WP100"
        And "image" should be "wordpress.jpg"
        And English "title" should be "Wordpress"
        And Turkish "shortDescription"  should be "Wordpress in nasıl kullanılacağını öğreneceğiz"
   */

    @Test
    public void get01(){
        //1. Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2. Set the expected data(we will learn later)

        //3. Send the request
        Response response = given().
                                accept("application/json").
                            when().
                                get(url);
        response.prettyPrint();

        //4. Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("code", equalTo("WP100")).
                body("image",equalTo("wordpress.jpg")).
                body("title.en",equalTo("Wordpress")).
                body("shortDescription.tr", equalTo("Wordpress in nasıl kullanılacağını öğreneceğiz"));
             /*
        If you use body methods more than one, it will work like hard assertion
         */


    }

    @Test
    public void get02(){
        //1. Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2. Set the expected data(we will learn later)

        //3. Send the request
        Response response = given().
                                accept("application/json").
                             when().
                                get(url);

        //4. Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).body("code",equalTo("WP100"),
                "image",equalTo("wordpress.jpg"),
                "title.en",equalTo("Wordpress"),
                "shortDescription.tr",equalTo("Wordpress in nasıl kullanılacağını öğreneceğiz"));


    }
    //2nd Way: Use assert methods
    //Hard Assertion: We have three methods a)assertEquals(expected, actual)
    //                                      b)assertTrue(boolean) ==> pass if condition is true
    //                                      c)assertFalse(boolean)==> pass if condition is false

    @Test
    public void get03(){
        //1. Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2. Set the expected data(we will learn later)

        //3. Send the request
        Response response = given().
                                accept(ContentType.JSON).
                            when().
                                get(url);
        response.prettyPrint();

        //4. Step: Assertion:
        assertEquals(200,response.getStatusCode());
        assertEquals("application/json; charset=utf-8",response.contentType());
        assertTrue(response.asString().contains("WP100"));
        assertTrue(response.asString().contains("wordpress.jpg"));
        assertTrue(response.asString().contains("Wordpress in nasıl kullanılacağını öğreneceğiz"));

    }

    //3rd Way: Use Soft Assertion:
    //         There are three steps in soft assertion
    //          1.Create SoftAssert class object (SoftAssert softAssert = new SoftAssert())
    //          2.Type assertions: assertEquals(actual,expected), assertTrue(boolean), assertFalse(boolean)
    //       !!!3.Use assertAll() ==>If you don't use assertAll() your test will pass but it will not be meaningful
    @Test
    public void get04(){

        //1. Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2. Set the expected data(we will learn later)

        //3. Send the request
        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);
        response.prettyPrint();

        //4. Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),200,"status code is wrong");//you can add some messages in order to see when your test has wrong
        softAssert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
        softAssert.assertTrue(response.asString().contains("WP100"),"No Match");
        softAssert.assertTrue(response.asString().contains("wordpress.jpg"),"No Match");
        softAssert.assertTrue(response.asString().contains("Wordpress in nasıl kullanılacağını öğreneceğiz"));

        softAssert.assertAll();

    }


}

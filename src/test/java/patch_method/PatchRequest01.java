package patch_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import test_data01.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends JsonPlaceHolderBaseUrl {
    /*
        When
	 		I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "title": "Tidy your room",
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 10,
									    "title": "Tidy your room",
									    "completed": true,
									    "id": 198
									  }
     */

    @Test
    public void patch01(){
        //Set the url
        spec.pathParams("first","todos","second", 199);

        //2. Set the expected data
        JsonPlaceHolderTestData expected = new JsonPlaceHolderTestData();

        //3. Send the PATCH Request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expected.expectedPatchDataSetUp()).when().put("/{first}/{second}");
        response.prettyPrint();

        //4. Assertion
        response.then().assertThat().statusCode(200);
//                body("title", Matchers.equalTo( expected.expectedDataSetUp().get("Tidy your room")),
//                        "userId", Matchers.equalTo(10),
//                        "completed", Matchers.equalTo(true));



    }

}

package delete_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

public class DeleteRequest01 extends JsonPlaceHolderBaseUrl {
    /*
        When
	 		I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 	Then
		 	Status code is 200
		 	And Response body is {}
     */
    @Test
    public void delete01(){
        //1. Set the url
        spec.pathParams("first","todos", "second",199);

        //2. Set the expected data
        Map<String, Object> expected = new HashMap<>();

        //3. Send the DELETE Request
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actual = response.as(HashMap.class);
        //4. Assert the outputs
        //1.Way: body()
        response.then().assertThat().statusCode(200);
        assertEquals(expected,actual);
        assertEquals(expected.size(),actual.size());

    }

}

package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    //Create RequestSpecification object
    protected RequestSpecification spec;

    // If you use @Before annotation before a method,
    // it means the method will be executed before every test method
    @Before
    public void steUp(){
        spec = new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").build();
    }


}

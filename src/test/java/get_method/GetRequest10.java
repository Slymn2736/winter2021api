package get_method;

import base_urls.OpenWeatherBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data01.OpenWeatherMapTestData;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetRequest10 extends OpenWeatherBaseUrl {

    /*
        When
	 		I send GET Request to the Url https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0
	 	Then
	 		Status code is 200
	 		And Response body is like {
										    "coord": {
										        "lon": -0.13,
										        "lat": 51.51
										    },
										    "weather": [
										        {
										            "id": 801,
										            "main": "Clouds",
										            "description": "few clouds",
										            "icon": "02n"
										        }
										    ],
										    "base": "stations",
										    "main": {
										        "temp": 284.57,
										        "feels_like": 280.6,
										        "temp_min": 283.71,
										        "temp_max": 285.37,
										        "pressure": 1007,
										        "humidity": 81
										    },
										    "visibility": 10000,
										    "wind": {
										        "speed": 5.1,
										        "deg": 160
										    },
										    "clouds": {
										        "all": 20
										    },
										    "dt": 1608329611,
										    "sys": {
										        "type": 1,
										        "id": 1414,
										        "country": "GB",
										        "sunrise": 1608278540,
										        "sunset": 1608306738
										    },
										    "timezone": 0,
										    "id": 2643743,
										    "name": "London",
										    "cod": 200
										}
     */

    @Test
    public void get01(){
        //1) Set the Url
        //https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0
        spec.pathParams("first","data",
                "second", 2.5,"third","weather").
             queryParams("q","London",
                 "appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");

        //2) Set the expected data
        OpenWeatherMapTestData expectedData = new OpenWeatherMapTestData();

        //3) Send the request
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();

        //4)Assert the outputs
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.coordSetUp().get("lat"), (Float)json.getFloat("coord.lat"));
        assertEquals(expectedData.weatherSetUp().get("main"), json.getString("weather[0].main"));
        assertEquals(expectedData.expectedDataSetUp().get("base"),json.getString("base"));
        assertEquals(expectedData.mainSetUp().get("humidity"), (Float)json.getFloat("main.humidity"));
        assertEquals(expectedData.expectedDataSetUp().get("visibility"), json.getInt("visibility"));


    }




}

package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuappTestData {
    Map<String, Object> bookingDatesMap = new HashMap<>();
    Map<String, Object> bookingDetailsMap = new HashMap<>();

    public Map<String, Object> setUpData(){
        bookingDatesMap.put("checkin", "2016-05-19");
        bookingDatesMap.put("checkout", "2021-03-29");
        bookingDetailsMap.put("firstname", "Jim");
        bookingDetailsMap.put("lastname", "Jackson");
        bookingDetailsMap.put("totalprice", 560);
        bookingDetailsMap.put("depositpaid", false);
        bookingDetailsMap.put("bookingdates", bookingDatesMap);
        bookingDetailsMap.put("additionalneeds", "Breakfast");


        return bookingDetailsMap;
    }

}

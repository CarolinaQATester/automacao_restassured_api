package br.com.restassuredapitesting.utils;

import org.json.simple.JSONObject;

public class Utils {

public static JSONObject verificaPayload(String firstname, String lastname, int totalprice, boolean depositpaid, String additionalneeds){
    JSONObject payload = new JSONObject();
    JSONObject bookingdates = new JSONObject();
    bookingdates.put("checkin", "2021-09-29");
    bookingdates.put("checkout", "2021-09-30");
    payload.put("firstname", firstname);
    payload.put("lastname", lastname);
    payload.put("totalprice", totalprice);
    payload.put("depositpaid", depositpaid);
    payload.put("bookingdates", bookingdates);
    payload.put("additionalneeds", "Breakfast");


    return  payload;
}
    public static  String getContractsBasePath(String pack, String contract) {
        return System.getProperty("user.dir")
                + "/src/test/java/br/com/restassuredapitesting/tests/"
                + pack
                + "/contracts/"
                + contract
                + ".json";
    }
}

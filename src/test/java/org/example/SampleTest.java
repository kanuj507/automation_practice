package org.example;


import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.commons.Endpoints;
import org.example.utils.RestUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class SampleTest extends BaseClass {

    RestUtils restUtils;

    @BeforeClass
    public void setup() {
       this.restUtils = new RestUtils();
    }

    @Test
    public void VerifyGetApi() throws SQLException {

        Reporter.log("");
        Response response = this.restUtils.getByUrl(basrUrl + Endpoints.API_USERS);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        response.then().assertThat().body("total", equalTo(12));

    }

    @Test
    public void VerifyPostApi() throws SQLException {

        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("name", "anu");
        requestMap.put("job","abc");

        JSONObject json = new JSONObject();
        json.put("name","anu");
        json.put("job","abc");


        Response response = this.restUtils.postByUrl(basrUrl + Endpoints.API_USERS, requestMap,json);
        JSONObject JSONResponseBody = new JSONObject(response.body().asString());
        Assert.assertEquals(JSONResponseBody.getString("name"),"anu");
        response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
        response.then().assertThat().body("name", equalTo("anu"));
        response.then().assertThat().body("job", equalTo("abc"));
        response.then().assertThat().body(containsString("id"));
    }
}

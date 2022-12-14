package via.sep3.persistencetier;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.springframework.util.ResourceUtils;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;
import static io.restassured.config.SSLConfig.sslConfig;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;


public class RestSellerTests {

    @Before
    public static void main(String[] args) throws Exception {
        RestAssured.useRelaxedHTTPSValidation();
        getCustomerByEmailResponseStatusREST();
        getCustomerByEmailREST();
    }

    @Test
    public static void getCustomerByEmailREST(){
        given().relaxedHTTPSValidation()
              //  .queryParam("id","1")
                .when().get("https://localhost:7133/FoodPack/1").then().log().body();
    }


    @Test
    public static void getCustomerByEmailResponseStatusREST()
    {
        int statusCode = given().relaxedHTTPSValidation()
              //  .queryParam("id", "1")
                .when().get("https://localhost:7133/FoodPack/1").getStatusCode();
        System.out.println("The response status: " + statusCode);

        given().when().get("https://localhost:7133/FoodPack/1").then().assertThat().statusCode(200);

    }
}

package day01;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RestAssuredMethodChaining {


    @DisplayName("First Attempt for Chaining")
    @Test

    public void chainingMethodsTest1() {

        ////http://54.174.216.245:8000/api/hello

        when().
                get("http://54.174.216.245:8000/api/hello").

                then().statusCode(200).

                header("Content-Length", "17");
    }


    @DisplayName("Using Hamcrest matcher for assertion")
    @Test
    public void testingWithMatcher() {

        when().
                get("http://54.174.216.245:8000/api/hello").

                prettyPeek().

                then().statusCode(200).

                header("Content-Length", equalTo("17")).
                body(is("Hello from Sparta"));


    }

    @DisplayName("Testing Get/api/Spartans endpoint")
    @Test
    public void testAllSpartans() {

        given().

                header("Accept", "application/xml").

        when().
                get("http://54.174.216.245:8000/api/spartans").

                prettyPeek().

                then().statusCode(200);


    }

}



package day2;


import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpartanTest_Parameters {

    @BeforeAll

    public static void setUp() {

        RestAssured.baseURI = "http://54.174.216.245:8000";
        RestAssured.basePath = "/api";

    }

    @DisplayName("Testing /spartans/{id}")
    @Test
    public void testSingleSpartan() {


        given()

                .log().all()
                .pathParam("id", 971).

                when()

                .get("spartans/{id}").

        then()

                .statusCode(is(200));
    }


    @DisplayName("Testing /spartans/{id}")
    @Test
    public void testSingleSpartan1() {


        given()

                .log().all()
                .pathParam("id", 971).

                when()

                .get("spartans/{id}").

                then()

                .statusCode(is(200));
    }

    @DisplayName("Testing2 /spartans/{id}")
    @Test
    public void testSingleSpartan2() {

        given()

                .log().all().

                when()

                .get("spartans/{id}", 971).

                then()

                .statusCode(is(200));

    }

    @DisplayName("Testing/spartans/{id} Body")

    @Test



    public void testSingleSpartanBody(){

        given()

                .log().all()

              .pathParam("id", 971).

                when()

                .get("spartans/{id}", 971).

                then()

                .log().all()
                .statusCode(is(200))
                //.body("JSON Path", is ("The Value"))

        .body("id", is(971))
                .body("name", is("Test"))
                .body("gender", is ("Male"))
        .body("phone", is (3216549870L ));


    }





    }

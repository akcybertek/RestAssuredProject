package day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class OpenMovieDB_Test {

    public static void init(){

        RestAssured.baseURI= "http://www.omdbapi.com";
    }



    @Test
    @DisplayName("TestMovie API")

    public void testMovies(){

        given()
                .queryParam("apikey", "26aa5b74")
                .queryParam("t", "Boss Baby")
                 .queryParam("plot", "full").

                when()

                .get().
                then()

                .log().all()
                .statusCode(200)

                // checking title contains Boss Baby
                .body("Title", containsString("Boss Baby"))

                .body("Rating[0].Value", is("6.3/10"))
                .body("Ratings[-1].Value", is("50/100"));





    }
}


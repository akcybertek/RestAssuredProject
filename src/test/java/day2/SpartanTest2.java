package day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

public class SpartanTest2 {

    @DisplayName("Get All Spartan")
    @Test
    public void testAllSpartans(){

        //String spartanURL = "http://54.174.216.245:8000/api/spartans" ;
        // how to set base URL , port , base path so I can reuse them
        RestAssured.baseURI = "http://54.174.216.245:8000" ;
        RestAssured.basePath = "/api" ;

        // it will create the request URL as is
        // baseURI + basePath + what is after get( "This Part" )

        // i want to explicitly specify I want JSON response from this result
        given()
                .header("Accept","application/json").
                when()
                .get("/spartans").
                then()
                .statusCode( is(200) ) ;

    }


    @DisplayName("Get All Spartan 2 ")
    @Test
    public void testAllSpartans2(){


        // send the same request specifiying the accept header is application/json
        // use baseuri basepath , check status code 200 , contentType header is json

        given()
                .baseUri("http://54.174.216.245:8000")  // alternative way of doing it
                .basePath("/api")
//                .accept("application/json").
                .accept(ContentType.JSON).
                when()
                .get("/spartans").
                then()
                .statusCode( is(200) )
                //.contentType("application/json;charset=UTF-8")
                //.contentType( is("application/json;charset=UTF-8")  )
                // easiest way for contentType is using ContentType enum
                .contentType( ContentType.JSON )  ;


    }

    @DisplayName("Testing/Hello again")
    @Test
    public void testHello(){

        given()
                .accept(ContentType.TEXT).

                when()
                .get ("/hello").

                then()
                .statusCode( is(200) )
                //.contentType("application/json;charset=UTF-8")
                //.contentType( is("application/json;charset=UTF-8")  )
                .contentType( ContentType.JSON )  ;
    }


    @DisplayName("Get 1 Spartan Test")

    @Test

    public void testSinglespartan(){

        given()
                .log().all().

        when()
                .get("/spartans/971")
                .prettyPeek().


                then()

                .statusCode(is(200));





    }





}
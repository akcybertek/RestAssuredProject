package day03;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;



public class SpartanSearchExtractData {

    @BeforeAll
    // in JUnit 5 @BeforeAll @AfterAll is static method
    // if we do not make it static it does not work because that's how it's defined in the doc
    public static void init() {
        // example of setting the port separately from baseURI
        RestAssured.baseURI = "http://54.174.216.245";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }

    @DisplayName("simple test")
    @Test
    public void test1() {

       Response response = given()
                .log().all()
                .queryParam("gender", "Female").
                when()
                .get("/spartans/search")
                .prettyPeek();


        JsonPath jp= response.jsonPath();
        // get the value of numberOfElements from the response body
        int numOfFemaleSpartans  =  jp.getInt("numberOfElements");
        System.out.println("numOfFemaleSpartans = " + numOfFemaleSpartans);

        // if you wanted to get single Spartan , for example the first one id
        // you would use jsonPath of  content[0].id
        // if you want to get al the ids , You can use getList method and remove the index
        //  content.id  for the id , content.name

        // storing all ids into list of integer
        List<Integer> numList = jp.getList("content.id");
        System.out.println("numList = " + numList);
        List<String> nameList = jp.getList("content.name");
        System.out.println("nameList = " + nameList);


    }






}

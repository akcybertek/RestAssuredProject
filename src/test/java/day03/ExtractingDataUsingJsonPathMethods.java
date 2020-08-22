package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ExtractingDataUsingJsonPathMethods {

    @DisplayName("Getting Movie info")
    @Test
    public void test1() {

        Response response =
                given()
                        .log().all()
                        //.baseUri("http://www.omdbapi.com")
                        .queryParam("apikey", "26aa5b74")
                        .queryParam("t", "Boss Baby").
                        when()
                        .get("http://www.omdbapi.com");

        // the JsonPath is a class that have a lot of methods

        JsonPath jp = response.jsonPath();
        // get the title as String

        String title= jp.getString("title");
        // get the year as int
        int year= jp.getInt("Year");

        System.out.println("Title= " +title);
        System.out.println("Year= " +year);


        String director= jp.getString("Director");
        System.out.println("Director= " + director);



        //String actors= jp.getString("actors");
       // System.out.println("actors= " + actors);

        String rating1Src= jp.getString("Ratings[0].Source");
        //System.out.println("rating1Src= " + rating1Src);

        // Store the entire response

        Map<String,Object> responseMap= jp.getMap("");
       // System.out.println("responseMap= " + responseMap);

        //System.out.println("Awards are " + responseMap.get("Awards"));

       Map<String, Object> firstRatingMap= jp.getMap("Ratings [0]");

        System.out.println("firstRatingMap= " +firstRatingMap );


        // I want to store all the source of rating

        List<String> sourceList = jp.getList("Ratings.Source");

        System.out.println("sourceList= " + sourceList);


    }

}

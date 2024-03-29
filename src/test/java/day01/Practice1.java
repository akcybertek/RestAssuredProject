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

public class Practice1 {
    // you may use your own IP
    // we are using spartan app that does not require password
    //http://54.174.216.245:8000/api/hello
    @Test
    public void test1(){
        // MAKE SURE YOUR REQUEST WORKS IN POSTMAN
        // IF ANYTHING DOES NOT WORK MANNUALY IT WILL NOT WORK IN HERE EITHER
        //RestAssured.get("URL HERE")
        // SINCE WE DID THE STATIC IMPORT
        // we can directly call the get method
        // after we send the request
        // we can save the result in to a type called Response
        // need this  import io.restassured.response.Response;
        Response response = get("http://54.174.216.245:8000/api/hello") ;
        // response object store all the information about the response we got
        // like status  , statusline , body , headers and so on
        //System.out.println("status code of this response : " + response.statusCode()  );
        // this is another way of getting status code starts with HTTP/1.1
        //System.out.println("getting status line of this response " + response.statusLine() );
        // in restAssured there are usually 2 methods that does same action
        // one directly with the name like response.statusCode()
        // another stating with getXXX  like response.getStatusCode()
        //System.out.println("status code of this response : " + response.getStatusCode()  );
        // getting the header out of the response
        // we can use       response.header("the header name goes here )
        // or we can use    response.getHeader("the header name goes here )
        //System.out.println("Getting the value of date header " + response.header("Date") ) ;
        //System.out.println("Getting the value of date header " + response.getHeader("Date") ) ;
        // try to get Content-Type header value and Content-Length header value
        //System.out.println("Content-Type header " + response.header("Content-Type") );
        //System.out.println("Content-Length header " + response.header("Content-Length") );
        // content-type is so common in pretty much all requests so there is a built support for this header
        // by directly calling a method
        //System.out.println( response.contentType() );
        //System.out.println( response.getContentType() );
    }
    @DisplayName("Testing /hello endpoint")
    @Test
    public void testHello(){
        Response response = get("http://54.174.216.245:8000/api/hello") ;
        // testing the status code returned correctly
        assertEquals(200, response.statusCode() );
        // testing the Content-Type header value is : text/plain;charset=UTF-8
        assertEquals("text/plain;charset=UTF-8" , response.header("Content-Type"));
        // alternatively use getHeader
        assertEquals("text/plain;charset=UTF-8" , response.getHeader("Content-Type"));
        // alternatively use response.contentType() or response.getContentType()
        assertEquals("text/plain;charset=UTF-8" , response.contentType() ) ;
        // testing the Content-length header value is : 17
        // response.header("Content-length") give us a string result so we need to do string comparision
        assertEquals("17" , response.header("Content-length") );
    }

    @DisplayName("Testing/hello endpoint body")

    @Test
    public void testingHelloResponseBody(){

        // get the body

        Response response = get("http://54.174.216.245:8000/api/hello") ;

        //System.out.println(response.asString());

        //System.out.println(response.body().asString());

        //assert the body is Hello from Sparta, length is 17

        String helloBody = response.asString();

        //assertEquals("Hello from Sparta",helloBody );

        //assertEquals(17, helloBody.length());


    }


    @DisplayName("Printing the response body using method")

    @Test

    public void printingBody(){

        Response response = get("http://54.174.216.245:8000/api/hello") ;

        //response.prettyPrint();

        System.out.println("===================================");

        // another way to see te body quick is prettyPeek
        // it print out the entire response

        int statusCode= response.prettyPeek().statusCode();

        System.out.println("Printing Only status Code " + statusCode);


    }
}
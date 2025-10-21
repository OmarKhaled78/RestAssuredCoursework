package Practical;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.LoginPojo;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class LoginTest {


    @Test
    public void Login(){

        //login with example email and password
        /* note that the credentials (or the endpoint itself) provided in the course to test login api are not valid
          anymore
         */
        //method 1: (NOT RECOMMENDED) sending request body as a string
       /* String body = "{\n" +
                "\"email\": \"hatem@example.com\",\n" +
                "\"password\": \"123456\"\n" +
                "}"; */
        //method 2: sending request body as a file (stored in resources folder as a json file)
      //  File body = new File("src/test/resources/login.json");
        //method 3: sending request body as a hashmap
        /*HashMap<String ,String> body  = new HashMap<>();
        body.put("email" , "hatem@example.com");
        body.put("password" , "123456"); */
// note: when using hashmaps to send as body -> have to do serialization
        //method 4: sending request body as POJO class
        LoginPojo body = new LoginPojo("hatem@example.com" , "123456");


        given().baseUri("https://todo.qacart.com")
        //.headers("Content-Type" , "application/json")
        .contentType(ContentType.JSON) // instead of setting a header can just use .contentType
        .body(body)
        .log().all()
        .when()
        .post("/api/v1/students/login")
        .then()
        .log().all()
        .assertThat().statusCode(200);


    }
}

package Practical;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class infoTest {
   /*
   Note: as a good practice: we should use request specification to reduce code redundancy
    the implementation is as follows:
   RequestSpecification request;
   @BeforeClass
   public void setupRequestSpecification(){
      request = given().baseUri("https://todo.qacart.com")
              .log().all();
   }
   after setting up our request specification, we replace the part after given() in our test cases with .spec(request)
   */
   @Test
    public void getCourseInfo(){ // GET request with headers

       /* Can use Header (or Headers) class to send
       request headers instead of manually passing them into the method every time
        */

       Header type = new Header("type" , "WEB");
       Header language = new Header("language" , "JAVA");
       Headers infoHeaders = new Headers(type , language);
       /* HashMap<String , String> infoHeaders = new HashMap<>();
       infoHeaders.put("type" , "WEB");
       infoHeaders.put("language" , "JAVA"); */ // we can also use Hashmaps to store headers

       given().baseUri("https://todo.qacart.com") // base URL for QACart APIS
       .headers(infoHeaders) // multiple headers can be added by using .headers instead of header or by chaining .header methods
       //.header("type" , "MANUAL") multiple headers can be added by chaining the .header method
       .log().all()
       .when().get("/api/v1/info/courses") // Get course info endpoint
       .then().log().all().assertThat().statusCode(200).body("count" , equalTo(1));
   }

   @Test
   public void getLectures(){ //GET request with query parameters

      HashMap<String , String> queryParams = new HashMap<>();
      queryParams.put("type" , "PAID");
      queryParams.put("mode", "VIDEO");
      given().baseUri("https://todo.qacart.com")
      //.queryParams("type" , "PAID" , "mode" , "VIDEO")  can pass query params directly as strings into .queryParams
      .queryParams(queryParams) // or can use hash maps the same way as we can use them in headers
      .log().all()
      .when().get("/api/v1/info/lectures")
      .then()
      .log().all()
      .assertThat().statusCode(200);


   }

}

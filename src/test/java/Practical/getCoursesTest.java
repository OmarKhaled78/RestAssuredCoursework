package Practical;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getCoursesTest {
/*Test case is blocked because it requires authorization,
   credentials provided in the course for this test api are not valid anymore */
    @Test
    public void getCourseDetails(){

        given()
        .baseUri("https://todo.qacart.com")
      //  .auth().oauth2("") cannot generate a bearer token, blocked by login test case
        .when().
        get("/api/v1/courses/6319b5655ce1f40db1b73738")
        .then().log().all()
        .assertThat().statusCode(200);
    }
}

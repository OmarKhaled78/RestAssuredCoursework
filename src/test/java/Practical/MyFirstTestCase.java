package Practical;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.*;



public class MyFirstTestCase {

    @Test
    public void test(){

        Response res = given().baseUri("https://68ecf98beff9ad3b14040f8d.mockapi.io/api/v1").log().all()
                .when().get("users")
                .then().log().all().assertThat().statusCode(200)
                .assertThat().body("[0].name"  , equalTo("Michael MacGyver") /* assertion on a name of a specific entry */,
                        "name" , hasItems("Tina Watsica" , "Cody Buckridge")/* asserting that specific names appear in response */,
                        "name" , not(hasItem("FirstName LastName")) /* asserting that a specific name does not appear */ ,
                        "name" , not(empty())/* asserting that the name field is not empty */,
                        "name" , hasSize(24)/* asserting size of name field (first way) */,
                        "name.size()" , equalTo(24) /* asserting size of name field (second way) */,
                        "createdAt" , everyItem(startsWith("2025")) /* asserting that creation date starts with 2025 for all items */,
                        "[0]" , hasKey("avatar")/* asserting that the first entry has a key named avatar */,
                        "[0]" , hasValue("Congo")/* asserting that the first entry has a value "Congo" */,
                        "[0]" , hasEntry("name" , "Michael MacGyver")).extract().response(); /* asserting that the first element has an entry with specific key value pair + extracting the entire response */
        String name = res.path("[0].name"); /* extracting a specific value from entire response in this case the value of the name key of the first entry */
        String name2 = JsonPath.from(res.asString()).getString("[0].name"); /* same functionlity as previous line different method */
        System.out.println(res.asString()); /* printing the entire response as a string */
        System.out.println(name);
        System.out.println(name2);

    }
}

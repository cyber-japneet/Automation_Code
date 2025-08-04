package api.actions;

import api.pojo.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RegisterApi
{
    public static Response registerNewUserApi(UserPojo userPojo)
    {
        return given()
                .contentType(ContentType.JSON)
                .baseUri("https://api.practicesoftwaretesting.com")
                .body(userPojo)
                .when()
                .post("/users/register")
                .then()
                .extract().response();

    }


}

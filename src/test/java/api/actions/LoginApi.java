package api.actions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;

public class LoginApi {

    public static String bearerToken;

    public static Response loginUserApi(String emailID, String password)
    {
        Map<String, String> payload = new HashMap<>();
        payload.put("email", emailID);
        payload.put("password", password);
        System.out.println(payload);

        Response response = given()
                .contentType(ContentType.JSON)
                .baseUri("https://api.practicesoftwaretesting.com")
                .body(payload)
                .when()
                .post("/users/login")
                .then().extract().response();
        bearerToken = response.body().path("access_token");
        System.out.println(bearerToken);
        try{
            Files.write(Paths.get("bearerToken.json"), response.body().asString().getBytes());
            System.out.println("Saved Bearer Token Successfully");
        }
        catch (IOException e)
        {
            System.err.println("Error in writing to file: "+e.getMessage());
        }

        return response;
    }
}

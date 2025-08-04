package api.actions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static api.actions.LoginApi.bearerToken;
import static io.restassured.RestAssured.given;

public class MessagesApi
{
    public static Response sendMsgApi(String name, String token)
    {
        Map<String, String> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("subject", "customer-service");
        payload.put("message", "Hello my name is preston-123. I am looking to work and get a job in any domain. Let me know if you have opportunities. Have attached my updated resume. Thanks! "+ LocalDateTime.now());
        Response response = given().
         contentType(ContentType.JSON)
        .header("Authorization", token)
                            .body(payload)
                            .baseUri("https://api.practicesoftwaretesting.com")
                            .when()
                            .post("/messages")
                            .then().extract().response();
        return response;
    }

    public static Response sendReplyApi(String id, String token)
    {
        Map<String, String> payload = new HashMap<>();
        payload.put("message", "Thanks for your message. We will keep you updated shortly "+LocalDateTime.now());
        Response response = given()
                .baseUri("https://api.practicesoftwaretesting.com")
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(payload)
                .when()
                .post("/messages/"+id+"/reply")
                .then()
                .extract()
                .response();
        return response;
    }
}

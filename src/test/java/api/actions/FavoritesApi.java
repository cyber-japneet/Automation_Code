package api.actions;

import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utils.RetrieveJsonData.getAuthToken;

public class FavoritesApi
{
    static String product_id = "01K0V4R7KZ5HH98N815DY0FVXH";
    public static int addProductToFavorites(String token)
    {
        Map<String, String> payload = new HashMap<>();
        payload.put("product_id", product_id);
        return given()
                .baseUri("https://api.practicesoftwaretesting.com")
                .header("Authorization", "Bearer "+token)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/favorites")
                .then()
                .extract()
                        .statusCode();
        //System.out.println(response.asPrettyString());
    }

    public static int getFavoriteItem()
    {
        return given()
                .baseUri("https://api.practicesoftwaretesting.com")
                .header("Authorization", "Bearer "+getAuthToken())
                .contentType(ContentType.JSON)
                .when()
                .get("/favorites")
                .then()
                .log()
                .all()
                .extract()
                .statusCode();
        //System.out.println(response.asPrettyString());
    }
}

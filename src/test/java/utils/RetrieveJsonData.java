package utils;

import io.restassured.path.json.JsonPath;

import java.io.File;

public class RetrieveJsonData
{
    static String jsonFilePath = "response.json";
    static String authFilePath = "bearerToken.json";

    public static String getFirstAndLastName()
    {
        // Path to your stored JSON file
        JsonPath storedData = new JsonPath(new File(jsonFilePath));
        String firstName = storedData.getString("first_name");
        String lastName = storedData.getString("last_name");

        return firstName+" "+lastName;
    }

    public static String getEmailId()
    {
        JsonPath storedData = new JsonPath(new File(jsonFilePath));
        return storedData.getString("email");
    }

    public static String getAuthToken()
    {
        JsonPath storedData = new JsonPath(new File(authFilePath));
        return storedData.getString("access_token");
    }
}

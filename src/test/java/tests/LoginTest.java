package tests;

import api.pojo.UserPojo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static api.actions.LoginApi.loginUserApi;
import static api.actions.RegisterApi.registerNewUserApi;

public class LoginTest
{
    @Test
    public void validateNewUserLogin()
    {
        UserPojo userPojo = UserPojo.generateFakeUser();
        Response registerUserApiResponse = registerNewUserApi(userPojo);
        // 📝 Write the String to a .json file
        try {
            Files.write(Paths.get("response.json"), registerUserApiResponse.getBody().asString().getBytes());
            System.out.println("Successfully stored API response in response.json ✅");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
        Assert.assertEquals(registerUserApiResponse.getStatusCode(), 201);

        //retrieve email and password
        Response loginUserApiResponse = loginUserApi(userPojo.getEmail(),userPojo.getPassword());
        //System.out.println(loginUserApiResponse.asPrettyString());
        Assert.assertEquals(loginUserApiResponse.getStatusCode(), 200);


    }
}

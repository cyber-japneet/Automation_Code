package tests;

import api.pojo.UserPojo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api.actions.LoginApi.loginUserApi;
import static api.actions.MessagesApi.sendMsgApi;
import static api.actions.MessagesApi.sendReplyApi;
import static utils.RetrieveJsonData.getFirstAndLastName;
import static utils.RetrieveJsonData.getEmailId;

public class MessageTest {

    private String bearerToken=null;

    @Test
    public void sendMessageTest()
    {
        String name = getFirstAndLastName();
        //System.out.println(name);
        Response loginResponse = loginUserApi(getEmailId(), "Qwe#31cv@w");
        bearerToken = loginResponse.body().path("access_token");
        Response msgResponse = sendMsgApi(name, "Bearer "+bearerToken);
        Assert.assertEquals(msgResponse.getStatusCode(), 200);
        Assert.assertNotNull(msgResponse.body().path("id"));
    }

    @Test()
    public void sendReplyMsgTest()
    {
        //independent test (we can introduce dependency if required)
        Response loginResponse = loginUserApi(getEmailId(), "Qwe#31cv@w");
        bearerToken = loginResponse.body().path("access_token");
        Response msgResponse = sendMsgApi(getFirstAndLastName(), "Bearer"+bearerToken);
        String id = msgResponse.body().path("id");
        Response replyResponse = sendReplyApi(id, "Bearer "+bearerToken);
        Assert.assertEquals(replyResponse.getStatusCode(), 201);
        Assert.assertNotNull(replyResponse.body().path("id"));
    }
}

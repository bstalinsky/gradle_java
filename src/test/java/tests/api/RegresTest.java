package tests.api;

import api.model.UserData;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.util.List;

public class RegresTest {
    private final static String url = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest(){
        List<UserData> users = given()
                .contentType(ContentType.JSON).when()
                .get(url + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(x-> Assert.assertTrue(x.getEmail().contains(x.getEmail())));
    }
}

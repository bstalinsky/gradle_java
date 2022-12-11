package tests.api;

import api.Specification.Specification;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;


public class RegresNoPojoTest {
    protected final static String url = "https://reqres.in/";

    @Test
    public void checkAvatarsNoPojoTest(){
        Specification.installSpecification(Specification.requestSpec(url), Specification.responseSpecOK200());
        Response response = given()
                .when().get("api/users?page=3")
                .then().log().all()
                .body("page" , equalTo(3))
                .body("data.id", notNullValue())
                .body("data.email", notNullValue())
                .body("data.first_name", notNullValue())
                .body("data.last_name", notNullValue())
                .body("data.avatar", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> emails = jsonPath.get("data.email");
        List<Integer> ids = jsonPath.get("data.id");
        List<String> avatars = jsonPath.get("data.avatars");

        for(int i = 0; i<avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()), "WRONG AVATARS");
        }
        Assert.assertTrue(emails.stream().allMatch(x->x.endsWith("@regres.in")));

    }


    @Test
    public void unSuccessResourceFound(){
        Specification.installSpecification(Specification.requestSpec(url), Specification.responseSpecUnique(404));
        Response response = given().when().get("/api/unknown/23")
                .then().log().all()
                .extract().response();}
}

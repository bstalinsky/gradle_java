package tests.api;

import api.Specification.Specification;
import api.model.*;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

public class RegresPojoTest {
    protected final static String url = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest() {
        Specification.installSpecification(Specification.requestSpec(url), Specification.responseSpecOK200());
        List<UserData> users = given()
                .get("api/users?page=3")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(x -> Assert.assertTrue(x.getEmail().contains(x.toString())));
        Assert.assertTrue(users.stream().allMatch((x -> x.getEmail().endsWith("@regres.in"))));
    }

    @Test
    @Description("Success register POST")
    public void successRegTest() {
        Specification.installSpecification(Specification.requestSpec(url), Specification.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SucessReg sucessReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SucessReg.class);

        Assert.assertNotNull(sucessReg.getId());
        Assert.assertNotNull(sucessReg.getToken());

        Assert.assertEquals(id, sucessReg.getId());
        Assert.assertEquals(token, sucessReg.getToken());
    }

    @Test
    public void unSuccessRegTest() {
        Specification.installSpecification(Specification.requestSpec(url), Specification.responseSpec400error());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("sydney@fife", "");

        UnSucessReg unSucessReg = given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(UnSucessReg.class);
        Assert.assertEquals("Missing password", unSucessReg.getError());
    }

    @Test
    public void sortedYearsTest(){
        Specification.installSpecification(Specification.requestSpec(url), Specification.responseSpecOK200());
        List<ColorsData> colors= given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data" , ColorsData.class);

        List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedYears, years);
    }

    @Test
    public void deleteUserTest(){
        Specification.installSpecification(Specification.requestSpec(url), Specification.responseSpecUnique(204));
        given().when()
                .delete("/api/users/2")
                .then().log().all();

    }


    @Test
    public  void timeTest(){
        Specification.installSpecification(Specification.requestSpec(url), Specification.responseSpecOK200());
        UserTime user = new UserTime("morpheus", "zion president");
        UserTimeResponse response = given()
                .body(user)
                .when().put("/api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);
        String regex = "(.{5})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex, "");
        Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex, ""));

    }
}

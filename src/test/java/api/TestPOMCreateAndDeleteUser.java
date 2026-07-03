package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestPOMCreateAndDeleteUser {
    private String email;
    private String password;
    private String name;
    private UserDTO obj;

    public TestPOMCreateAndDeleteUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }


    public TestPOMCreateAndDeleteUser() {
    }

    @Step("Удаление пользователя")
    public static void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .spec(SetUpAPI.requestSpec)
                .when()
                .delete(Endpoints.DELETE_USER);
    }
    @Step("Создание пользователя")
    public Response createUser(UserDTO user) {
        return given()
                .header("Content-type", "application/json")
                .spec(SetUpAPI.requestSpec)
                .body(user)
                .when()
                .post(Endpoints.CREATE_USER);
    }
}

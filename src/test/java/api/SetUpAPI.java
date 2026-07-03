package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class SetUpAPI {
    public static RequestSpecification requestSpec;
    public static final String BASE_URL = "https://stellarburgers.education-services.ru";

    @BeforeClass
    public static void setUp() {


        RestAssured.baseURI = BASE_URL;

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}

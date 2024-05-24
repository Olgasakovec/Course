import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserTest {

    @BeforeAll
    static void prepareLogs() {
        RestAssured.filters(new ResponseLoggingFilter(), new ResponseLoggingFilter());
    }


    @Test
    void testCreateUser() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        UserResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n"
                        + "  \"id\": 0,\n"
                        + "  \"username\": \"test148\",\n"
                        + "  \"firstName\": \"test1428\",\n"
                        + "  \"lastName\": \"test128\",\n"
                        + "  \"email\": \"test128\",\n"
                        + "  \"password\": \"test128\",\n"
                        + "  \"phone\": \"test128\",\n"
                        + "  \"userStatus\": 0\n"
                        + "}")
                .post("/user")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract()
                .as(UserResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("application/json", response.getContentType());
        UserResponse userResponse = response.as(UserResponse.class);
        Assertions.assertEquals(200, userResponse.getCode());
    }

    @Test
    void reqresTest() {
        RestAssured.baseURI = "https://reqres.in/api/users/22";
        Response response = RestAssured.get("/users/22");

        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
        Assertions.assertEquals("application/json; charset=utf-8", response.getContentType());
    }


    public static Stream<String> registerTest() {
        return Stream.of(
                "{\"password\": \"second123\"}",
                "{\"email\": \"second@mail.ru\"}"
        );
    }

    @ParameterizedTest
    @MethodSource("registerTest")
    void testMissingFields(String requestBody) {
        RestAssured.baseURI = "https://reqres.in/api";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/register");

        if (!requestBody.contains("email")) {
            assertEquals("Missing email or username", response.jsonPath().getString("error"));
        } else if (!requestBody.contains("password")) {
            assertEquals("Missing password", response.jsonPath().getString("error"));
        }
    }
}


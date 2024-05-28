import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.User;
import model.UserResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserTest {

    @BeforeAll
    static void prepareLogs() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    void testCreateUser() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        User user = new User();
        user.setId(0);
        user.setUsername("test149");
        user.setFirstName("test1429");
        user.setLastName("test128");
        user.setEmail("test128");
        user.setPassword("test128");
        user.setPhone("test128");
        user.setUserStatus(0);
        UserResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/user")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract()
                .as(UserResponse.class);
        Assertions.assertEquals(200, response.getCode());
    }

    @Test
    void reqresTest() {
        RestAssured.baseURI = "https://reqres.in/api/";
        Response response = RestAssured.get("/users/22");

        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
        Assertions.assertEquals("application/json; charset=utf-8", response.getContentType());
    }

    public static Stream<Arguments> registerTest() {
        return Stream.of(
                Arguments.of("{\"password\": \"second123\"}", "Missing email or username"),
                Arguments.of("{\"email\": \"second@mail.ru\"}", "Missing password")
        );
    }

    @ParameterizedTest
    @MethodSource("registerTest")
    void testMissingFields(String requestBody, String errorMessage) {
        RestAssured.baseURI = "https://reqres.in/api";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/register");

        assertEquals(errorMessage, response.jsonPath().getString("error"));
    }
}


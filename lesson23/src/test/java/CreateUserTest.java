import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    @BeforeAll
    static void prepareLogs() {
        RestAssured.filters(new ResponseLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    void createUserTest() {
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\n"
                        + "  \"id\": 0,\n"
                        + "  \"username\": \"may2024\",\n"
                        + "  \"firstName\": \"may2024\",\n"
                        + "  \"lastName\": \"may2024\",\n"
                        + "  \"email\": \"may2024\",\n"
                        + "  \"password\": \"may2024\",\n"
                        + "  \"phone\": \"may2024\",\n"
                        + "  \"userStatus\": 0\n"
                        + "}")
                .when()
                .post("https://petstore.swagger.io/v2/user/createUser")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON);
    }
}

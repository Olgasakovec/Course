import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RestApiTest {
    @BeforeAll
    static void prepareLogger() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
    }


    @Test
    void getStatus() {
        given()
                .accept(ContentType.JSON)
                .queryParam("status", "pending")
                .when()
                .get("pet/findByStatus")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract();

        assertThat(200, equalTo(HttpStatus.SC_OK));
    }
}


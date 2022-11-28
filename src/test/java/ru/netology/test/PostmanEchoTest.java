package ru.netology.test;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {
    @Test
    public void test() {
        String user = "{\"name\" : 123, \"job\" : \"QA\"}";
        // Given - When - Then
// Предусловия
        given()
                .contentType(ContentType.JSON)
                .baseUri("https://postman-echo.com")
                .body(user) // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
        .when()
                .post("/post")
// Проверки
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all()
                .body("json.name", equalTo(123))
                .body("json.job", equalTo("QA"))
        ;
    }
}

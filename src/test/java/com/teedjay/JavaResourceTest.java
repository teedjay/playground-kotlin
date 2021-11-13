package com.teedjay;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class JavaResourceTest {

    @Test
    public void testJavaEndpoint() {
        given()
          .when().get("/java")
          .then()
             .statusCode(200)
             .body(is("Hello Java RESTEasy"))
        ;
    }

}
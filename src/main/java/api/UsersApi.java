package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class UsersApi {

    public static void registerUser(String username, String email, String password) {
        RestAssured.baseURI = "https://candidatex:qa-is-cool@qa-task.backbasecloud.com";
        //TODO use json object instead of hardcoded string
        String body = format(" {\"user\":{\"username\":\"%s\",\"email\":\"%s\",\"password\":\"%s\"}} ", username, email, password);
        Response response = given().contentType(ContentType.JSON).body(body)
                .post("/api/users")
                .then().statusCode(200)
                .extract().response();
        assertThat(response.asString().contains(username));
    }

}

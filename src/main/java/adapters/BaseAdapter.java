package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    public static final String TOKEN = "";
    public static final String BASE_URL = "https://api.qase.io/v1";
    Gson converter = new Gson();

    public String get(String url) {
        return
        given()
                .header("Token", TOKEN)
                .header("Content-Type", "application/json")
        .when()
                .get(BASE_URL + url)
        .then()
                .log().all()
                .extract().body().asString();
    }

    public Response post(String url, String body) {
        return
        given()
                .header("Token", TOKEN)
                .header("Content-Type", "application/json")
                .body(body)
        .when()
                .post(BASE_URL + url)
        .then()
                .log().all()
                .extract().response();
    }

    public Response delete(String url) {
        return
        given()
                .header("Token", TOKEN)
                .header("Content-Type", "application/json")
        .when()
                .delete(BASE_URL + url)
        .then()
                .log().all()
                .extract().response();
    }
}

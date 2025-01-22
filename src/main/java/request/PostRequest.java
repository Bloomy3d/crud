package request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Todo;
import request.interfaces.CrudInterface;

import static io.restassured.RestAssured.given;

public class PostRequest extends Request implements CrudInterface<Todo, Integer> {
    private static final String POST_ENDPOINT = "posts/";

    public PostRequest(RequestSpecification requestSpecification) {
        super(requestSpecification);
    }

    @Override
    public Response save(Todo entity) {
        return given()
                .spec(requestSpecification)
                .body(entity)
                .when()
                .post(new Endpoint(POST_ENDPOINT).getUrl());
    }

    @Override
    public Response findById(Integer id) {
        return given()
                .spec(requestSpecification)
                .when()
                .get(new Endpoint(POST_ENDPOINT).getUrl() + id);
    }

    @Override
    public Response findAll() {
        return given()
                .spec(requestSpecification)
                .when()
                .get(new Endpoint(POST_ENDPOINT).getUrl());
    }

    @Override
    public Response update(long id, Todo entity) {
        return given()
                .spec(requestSpecification)
                .body(entity)
                .put(new Endpoint(POST_ENDPOINT).getUrl() + id);
    }

    @Override
    public Response deleteById(long id) {
        return given()
                .spec(requestSpecification)
                .delete(new Endpoint(POST_ENDPOINT).getUrl() + id);
    }

    @Override
    public Response deleteAll() {
        return given()
                .spec(requestSpecification)
                .delete(new Endpoint(POST_ENDPOINT).getUrl());
    }
}

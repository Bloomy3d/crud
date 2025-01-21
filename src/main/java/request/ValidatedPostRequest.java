package request;

import io.restassured.specification.RequestSpecification;
import models.Post;
import org.apache.http.HttpStatus;
import request.interfaces.CrudInterface;
import storages.TestDataStorage;

import java.util.List;

public class ValidatedPostRequest extends Request implements CrudInterface<Post, Integer> {

    private PostRequest postRequest;

    public ValidatedPostRequest(RequestSpecification requestSpecification) {
        super(requestSpecification);
        postRequest = new PostRequest(requestSpecification);
    }

    @Override
    public String save(Post entity) {
        String response =  postRequest.save(entity)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().asString();
        TestDataStorage.getInstance().addData(entity);
        return response;
    }

    @Override
    public Post findById(Integer integer) {
       return postRequest.findById(integer)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Post.class);
    }

    @Override
    public List<Post> findAll() {
        Post[] posts = postRequest.findAll()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Post[].class);
        return List.of(posts);
    }

    @Override
    public Object update(long integer, Post entity) {
        return postRequest.update(integer, entity)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Post.class);
    }

    @Override
    public Object deleteById(long id) {
        return postRequest.deleteById(id)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .extract()
                .body()
                .asString();
    }

    @Override
    public Object deleteAll() {
        return postRequest.deleteAll()
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .extract()
                .body()
                .asString();
    }
}

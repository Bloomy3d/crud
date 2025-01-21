package request;

import io.restassured.specification.RequestSpecification;

public class PostRequester {
    private PostRequest postRequest;
    private ValidatedPostRequest validatedRequest;

    public PostRequester(RequestSpecification requestSpecification) {
        this.postRequest = new PostRequest(requestSpecification);
        this.validatedRequest = new ValidatedPostRequest(requestSpecification);
    }

    public PostRequest getPostRequest() {return postRequest;}

    public ValidatedPostRequest getValidatedRequest() {return validatedRequest;}
}

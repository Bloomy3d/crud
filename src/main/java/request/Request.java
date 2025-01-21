package request;

import io.restassured.specification.RequestSpecification;

public class Request {

    protected RequestSpecification requestSpecification;

    public Request(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }
}

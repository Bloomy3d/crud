package specs.response;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class IncorrectDataResponse {
    private IncorrectDataResponse(){}

    public static ResponseSpecification nonExistingId() {
        ResponseSpecBuilder responseSpecBuilder =  new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(HttpStatus.SC_BAD_REQUEST);
        return responseSpecBuilder.build();
    }

    public static ResponseSpecification notFound() {
        ResponseSpecBuilder responseSpecBuilder =  new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(HttpStatus.SC_NOT_FOUND);
        return responseSpecBuilder.build();
    }

    public static ResponseSpecification internalServerError() {
        ResponseSpecBuilder responseSpecBuilder =  new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        return responseSpecBuilder.build();
    }
}

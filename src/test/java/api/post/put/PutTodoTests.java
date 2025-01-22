package api.post.put;

import api.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.response.IncorrectDataResponse;

class PutTodoTests extends BaseTest {

    @Test
    @DisplayName("Success: Save a valid put")
    void testPutPost() {
        Response actual = postRequester.getPostRequest().update(1, request);
        assertions.assertThat(actual).isEqualTo(request);
    }

    @Test
    @DisplayName("Invalid data: Validate title 1 char")
    void testIncorrectTitle() {
        request.setTitle("1");
        postRequester.getPostRequest().update(request.getUserId(), request)
                .then().spec(IncorrectDataResponse.nonExistingId());
    }

    @Test
    @DisplayName("Invalid data: Validate body bull")
    void testIncorrectBody() {
        request.setBody(null);
        postRequester.getPostRequest().update(request.getId(), request)
                .then().spec(IncorrectDataResponse.internalServerError());
    }
}

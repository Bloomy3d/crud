package api.post.post;

import api.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import specs.response.IncorrectDataResponse;

class PostPostTests extends BaseTest {

    @Test
    @DisplayName("Success: Save a valid post")
    void testSuccess() {
        Response actualResponse = postRequester.getPostRequest().save(request);
        assertions.assertThat(actualResponse).isNotNull();
    }

    @ParameterizedTest
    @CsvSource( {
            "null, 'Valid body'",
            "'ab', 'Valid body'",
            "'a'.repeat(51), 'Valid body'",
            "'Valid title', null",
            "'Valid title', ''",
            "'Valid title', 'b'.repeat(251)",
            "'Valid body with special chars: !?:,.;', 'Valid body with special chars: !?:,.;'",
            "'Пишем по русски боди', 'Пишем по русски титле'"
    })
    @DisplayName("Invalid data: Validate title and body constraints")
    void testInvalidTitleAndBody(String title, String body) {
        request.setTitle(title);
        request.setBody(body);
        Response actualResponse = postRequester.getPostRequest().save(request);
        assertions.assertThat(actualResponse).isNotNull();
    }

}

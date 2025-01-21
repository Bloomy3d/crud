package api.post.delete;

import annotations.PreparePost;
import api.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeletePostTests extends BaseTest {

    @Test
    @PreparePost(1)
    @DisplayName("Success: Delete data")
    void testDeletePost() {
        postRequester.getPostRequest().deleteAll();
    }

    @Test
    @PreparePost(1)
    @DisplayName("Success: Delete id data")
    void testDeleteId() {
        postRequester.getPostRequest().deleteById(request.getId());
    }
}

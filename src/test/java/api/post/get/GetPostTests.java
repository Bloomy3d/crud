package api.post.get;

import api.BaseTest;
import models.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class GetPostTests extends BaseTest {

    @Test
    @DisplayName("Success: Get a valid data")
    void getAll() {
        List<Post> createdPosts = postRequester.getValidatedRequest().findAll();
        assertions.assertThat(createdPosts).hasSize(100);
    }

    @Test
    @DisplayName("Success: GetId a valid data")
    void getOne() {
        Post createdPosts = postRequester.getValidatedRequest().findById(1);
        assertions.assertThat(createdPosts);
    }
}

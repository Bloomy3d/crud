package api.post.get;

import api.BaseTest;
import models.Todo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class GetTodoTests extends BaseTest {

    @Test
    @DisplayName("Success: Get a valid data")
    void getAll() {
        List<Todo> createdTodos = postRequester.getValidatedRequest().findAll();
        assertions.assertThat(createdTodos).hasSize(100);
    }

    @Test
    @DisplayName("Success: GetId a valid data")
    void getOne() {
        Todo createdPosts = postRequester.getValidatedRequest().findById(1);
        assertions.assertThat(createdPosts);
    }
}

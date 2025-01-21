package api;

import annotations.BeforeEachExtension;
import generators.RandomDataGenerator;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import models.Post;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import request.PostRequest;
import request.PostRequester;
import specs.request.RequestSpec;
import storages.TestDataStorage;

@ExtendWith(BeforeEachExtension.class)
public class BaseTest {
    protected PostRequester postRequester;
    protected SoftAssertions assertions;
    protected static Post request;

    @BeforeAll
    public static void setup() {
        RestAssured.defaultParser = Parser.JSON;
        request = RandomDataGenerator.generateRandomData(Post.class);
    }

    @BeforeEach
    public void setupTest() {
        postRequester = new PostRequester(RequestSpec.unAuthenticated());
        assertions = new SoftAssertions();
    }

    @AfterEach
    public void clean() {
        TestDataStorage.getInstance().getStorage()
                .forEach((key, value) -> new PostRequest(RequestSpec.unAuthenticated())
                        .deleteById(key));

        TestDataStorage.getInstance().clean();
    }

    @AfterEach
    public void assertAll(){assertions.assertAll();}
}

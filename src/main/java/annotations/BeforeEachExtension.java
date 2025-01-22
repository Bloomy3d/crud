package annotations;

import generators.RandomDataGenerator;
import models.Todo;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import request.PostRequest;
import specs.request.RequestSpec;

import java.lang.reflect.Method;

public class BeforeEachExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        Method testMethod = extensionContext.getRequiredTestMethod();

        preparePostExtension(testMethod);
    }

    private void preparePostExtension(Method testMethod) {
        PreparePost preparePost = testMethod.getAnnotation(PreparePost.class);

        if (preparePost != null) {
            for (int i = 0; i < preparePost.value(); i++) {
                new PostRequest(RequestSpec.unAuthenticated())
                        .save(RandomDataGenerator.generateRandomData(Todo.class));
            }
        }
    }
}

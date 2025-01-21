package storages;

import models.Post;

import java.util.HashMap;

public class TestDataStorage {

    private static TestDataStorage instance;
    private HashMap<Long, Post> storage;

    private TestDataStorage() {storage = new HashMap<>();}

    public static TestDataStorage getInstance() {
        if (instance == null) {
            instance = new TestDataStorage();
        }
        return instance;
    }
    public void addData(Post post) {storage.put(post.getId(), post);}

    public HashMap<Long, Post> getStorage() {return storage;}

    public void clean() {storage = new HashMap<>();}
}

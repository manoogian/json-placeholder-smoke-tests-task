package com.JsonPlaceholder;

import com.JsonPlaceholder.api.ApiManager;
import com.JsonPlaceholder.api.Validator;
import com.JsonPlaceholder.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class SmokeTest {

    private ApiManager apiManager;
    private int randomUserId;

    @BeforeClass
    void setup() {
        apiManager = new ApiManager();
        List<Integer> existingUserIds = apiManager.getExistingUserIds();
        randomUserId = existingUserIds.get(new Random().nextInt(0, existingUserIds.size()));
    }

    @Test
    public void emailTest() {
        User user = apiManager.getUser(randomUserId);
        System.out.println(user.getEmail());
        Assert.assertNotNull(user.getEmail());
    }

    @Test
    public void userPostsTest() throws Exception {
        apiManager = new ApiManager();
        String userAssociatedPosts = apiManager.getUserAssociatedPosts(randomUserId);

        Validator validator = new Validator("postSchema.json");
        validator.validate(userAssociatedPosts);
    }

    @Test
    public void createPostTest() throws Exception {
        String response = apiManager.createPostForUser(66);
        Validator validator = new Validator("postSchema.json");
        validator.validate(response);
    }
}

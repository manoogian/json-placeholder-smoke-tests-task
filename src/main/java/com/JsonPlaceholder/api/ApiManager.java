package com.JsonPlaceholder.api;

import com.JsonPlaceholder.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class ApiManager {
    Helper helper;
    private final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final String POST_ENDPOINT = "/posts";
    private final String USERS_URL = BASE_URL + "/users/";
    private final String CREATE_AND_GET_POST_URL = BASE_URL + POST_ENDPOINT;
    //    private final String userPostsUrl;
    Requests requests = new Requests();


    public ApiManager() {
        this.helper = new Helper();
    }

    public int getUsersCount() {
        return new JsonPath(getUsers().getBody().asString()).getList("$").size();
    }

    public String getUserEmail(int userId) {
        JsonPath jsonPath = new JsonPath(getUsers().getBody().asString());
        return jsonPath.get("[" + userId + "].email").toString();
    }

    private Response getUsers() {
        return requests.get(USERS_URL);
    }

    private Response getAllPosts() {
        return requests.get(CREATE_AND_GET_POST_URL);
    }

    public String getUserAssociatedPosts(int userId) {
        Response response = requests.get(USERS_URL + userId + POST_ENDPOINT);
        return response.getBody().asString();
    }

    public List<Integer> getExistingUserIds() {
        return new JsonPath(getUsers().getBody().asString()).getList("id");
    }


    public String createPostForUser(int userId) throws URISyntaxException {
        URL resource = getClass().getResource("/postJson.json");
        String postDataLocation = Paths.get(resource.toURI()).toAbsolutePath().toString();

        return requests.post(CREATE_AND_GET_POST_URL, helper.jsonReader(postDataLocation, userId).toString());
    }

    public User getUser(int targetUserId) {
        return new User(targetUserId, getUserEmail(targetUserId));
    }
}

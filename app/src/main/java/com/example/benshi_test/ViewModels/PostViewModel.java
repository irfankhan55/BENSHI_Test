package com.example.benshi_test.ViewModels;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class PostViewModel {

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int userId ;
    public int id;
    public String title;
    public String body;



    public PostViewModel() {

    }

    public void print(){
        Log.d("PostViewModel ==== ", "userID = "+userId+" "+"id = "+id+" "+"title = "+title+" "+"body = "+body);
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userId", userId);
            jsonObject.put("id", id);
            jsonObject.put("title", title);
            jsonObject.put("body", body);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public static PostViewModel fromJson(JSONObject jsonObject) {
        PostViewModel post = new PostViewModel();
        try {
            post.userId = jsonObject.getInt("userId");
            post.id = jsonObject.getInt("id");
            post.title = jsonObject.getString("title");
            post.body = jsonObject.getString("body");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return post;
    }

}

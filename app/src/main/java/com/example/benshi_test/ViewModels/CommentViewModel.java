package com.example.benshi_test.ViewModels;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentViewModel {

    public int postId ;
    public int id;
    public String name;
    public String email;
    public String body;

    public CommentViewModel(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public void print(){
        Log.d("CommentViewModel ==== ", "postId = "+postId+" "+"id = "+id+" "+"name = "+name+" "+"email = "+email+" "+"body = "+body);
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("postId", postId);
            jsonObject.put("id", id);
            jsonObject.put("name", name);
            jsonObject.put("email", email);
            jsonObject.put("body", body);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

}

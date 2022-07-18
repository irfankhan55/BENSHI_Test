package com.example.benshi_test.APIs;

import com.example.benshi_test.ViewModels.AuthorViewModel;
import com.example.benshi_test.ViewModels.CommentViewModel;
import com.example.benshi_test.ViewModels.PostViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIManager {
    @GET("posts?")
    Call<List<PostViewModel>> GET_ALL_POSTS (
            @Query("_page") int page,
            @Query("_limit") int limit
    );

    @GET("users/{user_id}")
    Call<AuthorViewModel> GET_AUTHOR_DETAILS (
            @Path("user_id") int userId
    );

    @GET("users/{post_id}/comments")
    Call<List<CommentViewModel>> GET_ALL_COMMENTS_FOR_POST (
            @Path("post_id") int postId
    );
}

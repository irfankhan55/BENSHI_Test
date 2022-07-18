package com.example.benshi_test.APIs;

import com.example.benshi_test.ViewModels.PostViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIManager {
    @GET("posts?")
    Call<List<PostViewModel>> GET_ALL_POSTS (
            @Query("_page") int page,
            @Query("_limit") int limit
    );

    @GET("posts?")
    Call<List<PostViewModel>> GET_AUTHOR_DETAILS (
            @Query("_page") int page,
            @Query("_limit") int limit
    );
}

package com.example.benshi_test.ui.home;

import com.example.benshi_test.viewModels.PostViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainInterface {
    @GET("posts?")
    Call<List<PostViewModel>> LIST_CALL (
            @Query("_page") int page,
            @Query("_limit") int limit
    );
}

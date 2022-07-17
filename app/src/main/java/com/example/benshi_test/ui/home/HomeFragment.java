package com.example.benshi_test.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benshi_test.databinding.FragmentHomeBinding;
import com.example.benshi_test.viewModels.PostViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    NestedScrollView nestedScrollView;
    RecyclerView postListView;
    ProgressBar progressBar;
    ArrayList<PostViewModel> allPosts = new ArrayList<>();
    PostsAdapter postsAdapter;
    int page = 1, limit = 7;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        nestedScrollView = binding.getRoot();
        postListView = binding.postsList;
        progressBar = binding.progressBar;
        postsAdapter = new PostsAdapter(allPosts);
        postListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        postListView.setAdapter(postsAdapter);
        getAllPosts(page, limit);

        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if(scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()){
                page ++;
                progressBar.setVisibility(View.VISIBLE);
                getAllPosts(page,limit);
            }
        });


        return nestedScrollView;

    }

    private void getAllPosts(int page, int limit) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MainInterface mainInterface = retrofit.create(MainInterface.class);
        Call<List<PostViewModel>> call = mainInterface.LIST_CALL(page, limit);
        call.enqueue(new Callback<List<PostViewModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<PostViewModel>> call, @NonNull Response<List<PostViewModel>> response) {
                if(response.isSuccessful() && response.body() != null){
                    progressBar.setVisibility(View.GONE);
                    parseAllPosts(response.body());
                }else{
                    Log.d("TAG", "getAllPosts: Response else ");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<PostViewModel>> call, @NonNull Throwable t) {
                Log.d("TAG", "getAllPosts: Failed " + t);
            }
        });

    }

    private void parseAllPosts(List<PostViewModel> postsArray) {
        for (int i=0; i<postsArray.size(); i++){
                allPosts.add(postsArray.get(i));
                postsAdapter = new PostsAdapter(allPosts);
                postListView.setAdapter(postsAdapter);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
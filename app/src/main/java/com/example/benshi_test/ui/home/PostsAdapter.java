package com.example.benshi_test.ui.home;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benshi_test.databinding.PostItemBinding;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.viewHolder> {
    List<String> posts;
    private PostItemBinding binding;

    public PostsAdapter(List<String> list) {
        this.posts = list;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         binding = PostItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
         View root = binding.getRoot();
         return new viewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TextView title = binding.title;
//        ImageView postImage = binding.listImage;
        title.setText(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView postText;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            postText = binding.title;
            imageView = binding.listImage;
        }
    }
}

//      binding = PostItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
//              View root = binding.getRoot();
//              TextView title = binding.title;
//              TextView textView = binding.title;
//              textView.setText(posts.get(i));
//              return root;
package com.example.benshi_test.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.benshi_test.Utils.Utils;
import com.example.benshi_test.databinding.PostItemBinding;
import com.example.benshi_test.viewModels.PostViewModel;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.viewHolder> {
    ArrayList<PostViewModel> posts;
    private PostItemBinding binding;

    public PostsAdapter(ArrayList<PostViewModel> postList) {
        this.posts = postList;
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
      ImageView postImage = binding.listImage;
        Glide.with(postImage.getContext())
                .load(Utils.getSha256Hash(posts.get(position).title))
                .override(200, 200)
                .fitCenter() // scale to fit entire image within ImageView
                .into(postImage);
        title.setText(posts.get(position).title);
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

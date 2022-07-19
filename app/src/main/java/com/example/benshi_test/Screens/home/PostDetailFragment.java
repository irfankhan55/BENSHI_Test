package com.example.benshi_test.Screens.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.benshi_test.Screens.settings.SettingsViewModel;
import com.example.benshi_test.databinding.FragmentPostDetailBinding;


public class PostDetailFragment extends Fragment {
    private FragmentPostDetailBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentPostDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        if (getArguments() != null) {
            textView.setText("Post ID =" + getArguments().getString("postId"));
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

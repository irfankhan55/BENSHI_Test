package com.example.benshi_test.Screens.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SettingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("TODO: Add email textfield for setting receivers email! ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
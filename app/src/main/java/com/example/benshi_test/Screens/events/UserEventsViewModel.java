package com.example.benshi_test.Screens.events;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserEventsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UserEventsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("TODO: User events list from RealmDB!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.fishapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("You're Welcome!");
    }

    public void setUsername(String username) {
        mText.setValue("Hello " + username);
    }

    public LiveData<String> getText() {
        return mText;
    }
}

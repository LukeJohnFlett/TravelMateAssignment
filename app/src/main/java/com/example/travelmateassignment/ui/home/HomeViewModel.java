package com.example.travelmateassignment.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> mText1;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("If you are adventures and want someone to share the travel experince with TravelMate is the place you want to be. Here at TravelMate everyone is welcome to make a post regarding where they are going and people can see if they wanna join.");
        mText1 = new MutableLiveData<>();
        mText1.setValue("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getText1() {
        return mText1;
    }
}
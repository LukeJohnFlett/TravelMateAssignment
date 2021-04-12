package com.example.travelmateassignment.ui.createPost;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.travelmateassignment.R;

public class CreatePostViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    public CreatePostViewModel() {

    }

    public LiveData<String> getText() {
        return mText;
    }
}
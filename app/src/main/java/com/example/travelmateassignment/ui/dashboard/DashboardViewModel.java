package com.example.travelmateassignment.ui.dashboard;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class DashboardViewModel extends AndroidViewModel {

    private final PostRepository repository;

    public DashboardViewModel(Application app) {
        super(app);
        this.repository = PostRepository.getInstance(app);
    }

    public LiveData<List<Post>> getAllPosts() {
        return repository.getAllPosts();
    }

    public void insert(final Post post) {
        repository.insert(post);
    }

    public void deleteAllPosts() {
        repository.deleteAllPosts();
    }

}
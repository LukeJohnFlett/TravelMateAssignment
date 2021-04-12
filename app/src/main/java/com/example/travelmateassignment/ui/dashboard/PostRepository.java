package com.example.travelmateassignment.ui.dashboard;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PostRepository {
    private static PostRepository instance;
    private final PostDao postDao;
    private final LiveData<List<Post>> allPosts;
    private final ExecutorService executorService;


    private PostRepository(Application application) {
        PostDatabase database = PostDatabase.getInstance(application);
        postDao = database.noteDao();
        allPosts = postDao.getAllPosts();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized PostRepository getInstance(Application application) {
        if (instance == null)
            instance = new PostRepository(application);

        return instance;
    }

    public LiveData<List<Post>> getAllPosts() {
        return allPosts;
    }

    public void insert(Post post) {
        executorService.execute(() -> postDao.insert(post));
    }

    public void deleteAllPosts() {

        executorService.execute(postDao::deleteAllPosts);
    }

}
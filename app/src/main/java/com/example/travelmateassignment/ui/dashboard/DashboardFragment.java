package com.example.travelmateassignment.ui.dashboard;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelmateassignment.R;
import com.example.travelmateassignment.ui.createPost.CreatePostFragment;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private CreatePostFragment postFragment;
    private TextView textName;
    private TextView textCountry;
    private TextView textDecription;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView = root.findViewById(R.id.rv);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        textName = root.findViewById(R.id.name);
        textCountry = root.findViewById(R.id.country);
        textDecription = root.findViewById(R.id.decription);






        ArrayList<Post> postss = new ArrayList<>();
        postAdapter = new PostAdapter(postss, this);
        recyclerView.setAdapter(postAdapter);


        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        dashboardViewModel.getAllPosts().observe(getViewLifecycleOwner(),posts -> {
           postAdapter.updatePost(posts);

        });

        return root;
    }
    public boolean onCreateOptionsMenu(Menu menu){

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                postAdapter.getFilter().filter(newText);

                return false;
            }
        });
        return true;
    }
}
package com.example.travelmateassignment.ui.dashboard;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelmateassignment.Data.Post;
import com.example.travelmateassignment.Data.PostAdapter;
import com.example.travelmateassignment.R;
import com.example.travelmateassignment.ui.createPost.CreatePostFragment;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView recyclerView;
    public PostAdapter postAdapter;
    private CreatePostFragment postFragment;
    private TextView textName;
    private TextView textCountry;
    private TextView textDecription;
    private EditText editText;
    ArrayList<Post> posts;





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
        editText = root.findViewById(R.id.searchEdit);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });



        posts = new ArrayList<>();
        postAdapter = new PostAdapter(posts, this);
        recyclerView.setAdapter(postAdapter);



        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        dashboardViewModel.getAllPosts().observe(getViewLifecycleOwner(), posts -> {
            postAdapter.updatePost(posts);

        });

        return root;
    }
    private void filter(String text){
        ArrayList<Post> filteredList = new ArrayList<>();
        for(Post post: posts){
            if(post.getCountry().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(post);
            }
        }
        postAdapter.filterList(filteredList);
    }
}
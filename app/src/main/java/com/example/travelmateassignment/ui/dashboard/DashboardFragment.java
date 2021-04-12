package com.example.travelmateassignment.ui.dashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    @SuppressLint("SetTextI18n")
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

        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        dashboardViewModel.getAllPosts().observe(getViewLifecycleOwner(),posts -> {
            if(!posts.isEmpty()){
                textName.setText("");
                for(Post p : posts){
                    textName.append(p.getName());
                    textCountry.append(p.getCountry());
                    textDecription.append(p.getDecription());
                    postss.add(new Post(textCountry.toString(),textName.toString(),textDecription.toString(),1));
                }
            }
            else{

                postss.add(new Post("Empty","Empty","Empty",1));



            }

        });
        postAdapter = new PostAdapter(postss, this);
        recyclerView.setAdapter(postAdapter);



        return root;
    }
}
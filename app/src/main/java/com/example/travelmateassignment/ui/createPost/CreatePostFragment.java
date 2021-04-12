package com.example.travelmateassignment.ui.createPost;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.travelmateassignment.R;
import com.example.travelmateassignment.ui.dashboard.DashboardViewModel;
import com.example.travelmateassignment.ui.dashboard.Post;

import java.util.ArrayList;

public class CreatePostFragment extends Fragment {

    private CreatePostViewModel createPostViewModel;
    private DashboardViewModel dashBoardViewModel;
    private EditText editName;
    private EditText editCountry;
    private EditText editDecription;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        createPostViewModel =
                new ViewModelProvider(this).get(CreatePostViewModel.class);
        View root = inflater.inflate(R.layout.fragment_create_post, container, false);
        final TextView textView = root.findViewById(R.id.textView);

        editName = root.findViewById(R.id.nameEdit);
        editCountry = root.findViewById(R.id.editCountry);
        editDecription = root.findViewById(R.id.editDecription);

        root.findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dashBoardViewModel.insert(new Post(editName.getText().toString(),editCountry.getText().toString(),editCountry.getText().toString(),1));
            }
        });
            return root;
    }
    //public void savePost(View v) {
      //  dashBoardViewModel.insert(new Post(editName.getText().toString(),editCountry.getText().toString(),editCountry.getText().toString(),1));
    //}


}
package com.example.travelmateassignment.ui.createPost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.travelmateassignment.R;
import com.example.travelmateassignment.ui.dashboard.DashboardViewModel;
import com.example.travelmateassignment.ui.dashboard.Post;

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
        

        editName = root.findViewById(R.id.nameEdit);
        editCountry = root.findViewById(R.id.editCountry);
        editDecription = root.findViewById(R.id.editDecription);

        dashBoardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        root.findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dashBoardViewModel.insert(new Post(editName.getText().toString(),editCountry.getText().toString(),editDecription.getText().toString(),1));
                editCountry.setText("");
                editName.setText("");
                editDecription.setText("");


            }
        });

        root.findViewById(R.id.deleteFields).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editCountry.setText("");
                editName.setText("");
                editDecription.setText("");
            }
        });
            return root;
    }


}
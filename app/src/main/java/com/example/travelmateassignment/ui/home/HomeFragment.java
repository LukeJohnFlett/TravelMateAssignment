package com.example.travelmateassignment.ui.home;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.travelmateassignment.MainActivity;
import com.example.travelmateassignment.R;
import com.example.travelmateassignment.ui.createPost.CreatePostFragment;
import com.example.travelmateassignment.ui.dashboard.DashboardFragment;

import static com.example.travelmateassignment.R.id.navigation_home;

public class HomeFragment extends Fragment {

    ViewFlipper flipper;


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        int images[] = {R.drawable.download,R.drawable.shutterstock_1187027923,R.drawable.images};

        flipper = root.findViewById(R.id.flipperHome);

        for (int i = 0; i<images.length; i++){
            flipperImages(images[i]);
        }
//****************************************
        Button buttonFind = (Button) root.findViewById(R.id.buttonFind);

        buttonFind.setOnClickListener(v -> {
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.fl, new CreatePostFragment());
                fr.addToBackStack(null);
                fr.commit();
                


            });
//****************************************

        return root;

    }
    public void flipperImages (int image){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        flipper.addView(imageView);
        flipper.setFlipInterval(4000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        flipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }
}
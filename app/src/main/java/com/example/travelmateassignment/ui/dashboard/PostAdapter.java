package com.example.travelmateassignment.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelmateassignment.R;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> implements Filterable {

    List<Post> posts;
    private List<Post> postsFull;


    public PostAdapter(List<Post> posts, DashboardFragment dashboardFragment){
        this.posts=posts;
        postsFull = new ArrayList<>(posts);
    }



    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_posts, parent, false);
        return new ViewHolder(view);
        
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.country.setText(posts.get(position).getCountry());
        holder.name.setText(posts.get(position).getName());
        holder.decription.setText(posts.get(position).getDecription());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void updatePost(List<Post> posts) {
        this.posts=posts;
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView country;
        TextView name;
        TextView decription;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            country =itemView.findViewById(R.id.country);
            name = itemView.findViewById(R.id.name);
            decription = itemView.findViewById(R.id.decription);
        }

    }
    @Override
    public Filter getFilter() {
        return postFilter;
    }

    private Filter postFilter = new Filter(){
        @Override
        protected FilterResults performFiltering(CharSequence constraint){
            List<Post> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(postsFull);
            }
            else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Post post : postsFull){
                    if(post.getCountry().toLowerCase().contains(filterPattern)){
                        filteredList.add(post);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            posts.clear();
            posts.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };
}

package com.ncit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.ncit.projectb.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CollectionActivity extends AppCompatActivity {

    List<User> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        String[] images = {
                "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "https://images.unsplash.com/photo-1494976388531-d1058494cdd8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80",
                "https://images.unsplash.com/photo-1643397652696-e633822828fd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=985&q=80",
                "https://images.unsplash.com/photo-1643379120803-a478f56aa5e8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw4fHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=900&q=60",
                "https://images.unsplash.com/photo-1643400812627-288aa24ccd29?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxOHx8fGVufDB8fHx8&auto=format&fit=crop&w=900&q=60",
                "https://images.unsplash.com/photo-1643386777909-04835ade3530?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyOHx8fGVufDB8fHx8&auto=format&fit=crop&w=900&q=60",
                "https://images.unsplash.com/photo-1643166406764-569565811559?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0M3x8fGVufDB8fHx8&auto=format&fit=crop&w=900&q=60",
                "https://images.unsplash.com/photo-1643293383951-0755fda59471?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0N3x8fGVufDB8fHx8&auto=format&fit=crop&w=900&q=60",
                "https://images.unsplash.com/photo-1643306633346-30cf2efcab78?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1Mnx8fGVufDB8fHx8&auto=format&fit=crop&w=900&q=60",
                "https://images.unsplash.com/photo-1643336157369-bfd90e14d7e8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1NHx8fGVufDB8fHx8&auto=format&fit=crop&w=900&q=60"
        };


        for (int i = 0; i < 10; i++) {
            User user = new User("Title" + i, "Desc " + i, images[i]);
            arrayList.add(user);
        }

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        MyAdapter adapter = new MyAdapter(arrayList);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);
    }

}


class MyAdapter extends RecyclerView.Adapter<MyAdapter.RowViewHolder> {

    private List<User> arrazyList;

    public MyAdapter(List<User> arrazyList) {
        this.arrazyList = arrazyList;
    }


    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new RowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int i) {
        User user = arrazyList.get(i);
        holder.getTvTitle().setText(user.getTitle());
        holder.getTvDesc().setText(user.getDesc());
        Picasso.get().load(user.getImages()).into(holder.getImg());
    }

    @Override
    public int getItemCount() {
        return arrazyList.size();
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTitle;
        TextView tvDesc;

        public RowViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
        }

        public ImageView getImg() {
            return img;
        }

        public TextView getTvDesc() {
            return tvDesc;
        }

        public TextView getTvTitle() {
            return tvTitle;
        }
    }
}



/*class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<User> arrayList;

    public MyAdapter(List<User> arrayList) {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = arrayList.get(position);
        holder.getTvTitle().setText(user.getTitle());
        holder.getTvDesc().setText(user.getDesc());
        Picasso.get().load(user.getImages()).into(holder.getImg());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDesc;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvTitle = itemView.findViewById(R.id.tv_title);
            img = itemView.findViewById(R.id.img);

        }

        public ImageView getImg() {
            return img;
        }

        public TextView getTvDesc() {
            return tvDesc;
        }

        public TextView getTvTitle() {
            return tvTitle;
        }
    }
}*/

class User {
    String title;
    String desc;
    String images;

    public User(String title, String desc, String images) {
        this.title = title;
        this.desc = desc;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
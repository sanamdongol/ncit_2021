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



        for (int i = 0; i < 20; i++) {
            User user = new User("Title" + i, "Desc " + i, R.drawable.canada);
            arrayList.add(user);
        }

        MyAdapter adapter = new MyAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

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
}

class User {
    String title;
    String desc;
    int images;

    public User(String title, String desc, int images) {
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

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
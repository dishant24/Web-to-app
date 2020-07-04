package com.idiots.webapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class WebAddapter  extends RecyclerView.Adapter<WebAddapter.WebViewHolder> {
    private Context context;
    private User[] data;
    public WebAddapter(Context context,User[] data){
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public WebViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user,parent,false);
        return new WebViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull WebViewHolder holder, int position) {
        User user = data[position];
        holder.txt.setText(user.getId().toString());
        holder.txt1.setText(user.getLogin());
        Glide.with(holder.img).load(user.getAvatarUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class WebViewHolder extends RecyclerView.ViewHolder {
        TextView txt,txt1;
        ImageView img;
        public WebViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.user_txt);
            img = itemView.findViewById(R.id.user_img);
            txt1 = itemView.findViewById(R.id.user_txt2);
        }
    }
}

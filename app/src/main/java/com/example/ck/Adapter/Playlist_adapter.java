package com.example.ck.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ck.Models.Song;
import com.example.ck.R;

import java.util.ArrayList;

public class Playlist_adapter extends RecyclerView.Adapter<Playlist_adapter.ViewHolder> {
    Context context;
    ArrayList<Song> mangSong;

    public Playlist_adapter(Context context, ArrayList<Song> mangSong) {
        this.context = context;
        this.mangSong = mangSong;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = mangSong.get(position);
        holder.txt_tenbaihat.setText(song.getTenBaiHat());
        holder.txt_tacgia.setText(song.getTenNgheSi());
        //holder.imageViewSong.setImageResource(R.drawable.img_1);
        if (song.getHinhBaiHat() != null && !song.getHinhBaiHat().isEmpty()) {
            Glide.with(context)
                    .load(song.getHinhBaiHat()) // URL ảnh từ API
                    .placeholder(R.drawable.ic_launcher_background) // Ảnh mặc định khi đang tải
                    .error(R.drawable.ic_launcher_background) // Ảnh hiển thị nếu URL không hợp lệ
                    .into(holder.imageViewSong);
        } else {
            // Nếu URL null hoặc rỗng, sử dụng ảnh mặc định
            holder.imageViewSong.setImageResource(R.drawable.ic_launcher_background);
        }
//        Glide.with(context).load(song.getHinhBaiHat()).into(holder.imageViewSong);
    }

    @Override
    public int getItemCount() {
        return mangSong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewSong;
        TextView txt_tenbaihat,txt_tacgia;
        public ViewHolder(View itemview){
            super(itemview);
            imageViewSong = itemview.findViewById(R.id.img_hinh);
            txt_tenbaihat = itemview.findViewById(R.id.tv_tenbai);
            txt_tacgia = itemview.findViewById(R.id.tv_tentacgia);
        }
    }
}

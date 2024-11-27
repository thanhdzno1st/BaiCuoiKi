package com.example.ck.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck.Adapter.Playlist_adapter;
import com.example.ck.Models.Song;
import com.example.ck.R;
import com.example.ck.service.APIservice;
import com.example.ck.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistFragment extends Fragment {
    View view;
    RecyclerView recyclerViewSongRecommend;
    Playlist_adapter playlistAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        anhXa();
        GetData();
        return view;
    }

    private void anhXa() {
        recyclerViewSongRecommend = view.findViewById(R.id.recycler_dsbaihat);
    }

    private void GetData() {
        Dataservice dataservice = APIservice.getService();
        Call<List<Song>> callback = dataservice.GetSong_hottiktok();
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                ArrayList<Song> SongArraylist = (ArrayList<Song>) response.body();
                playlistAdapter = new Playlist_adapter(getActivity(),SongArraylist);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewSongRecommend.setLayoutManager(linearLayoutManager);
                recyclerViewSongRecommend.setAdapter(playlistAdapter);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.d("hihi", "Lỗi khi tải dữ liệu bài hát: " + t.getMessage());
            }
        });
    }
}
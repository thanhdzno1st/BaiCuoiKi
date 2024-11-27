package com.example.ck.service;

import com.example.ck.Models.Song;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
//    @GET("songbanner.php")
//    Call<List<Banner>> GetDataBanner();

    @GET("Home_recommend.php")
    Call<List<Song>> GetSong_recommend();

    @GET("Hottiktok_song.php")
    Call<List<Song>> GetSong_hottiktok();

    @GET("home_bolero.php")
    Call<List<Song>> GetSong_bolero();

//    @GET("User.php")
//    Call<List<User>> GetUser();
}

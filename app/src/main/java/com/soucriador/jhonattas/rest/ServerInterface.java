package com.soucriador.jhonattas.rest;

import com.soucriador.jhonattas.model.jekyll.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerInterface {

    @GET("feed.json")
    Call<Feed> getFeed();

}

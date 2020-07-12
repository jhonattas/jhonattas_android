package com.soucriador.jhonattas.rest

import com.soucriador.jhonattas.model.jekyll.Feed
import retrofit2.Call
import retrofit2.http.GET

interface ServerInterface {
    @get:GET("feed.json")
    val feed: Call<Feed?>?
}
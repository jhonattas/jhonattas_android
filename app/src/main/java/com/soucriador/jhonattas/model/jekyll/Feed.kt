package com.soucriador.jhonattas.model.jekyll

import com.google.gson.annotations.SerializedName

data class Feed (
    @SerializedName("version")
    var version: String?,

    @SerializedName("title")
    var title: String?,

    @SerializedName("home_page_url")
    var homePageUrl: String?,

    @SerializedName("feed_url")
    var feedUrl: String?,

    @SerializedName("description")
    var description: String?,

    @SerializedName("author")
    var author: Author?,

    @SerializedName("items")
    var items: List<Post?>? = null

)
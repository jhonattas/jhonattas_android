package com.soucriador.jhonattas.model.jekyll

import java.util.*

data class Post (
            var id: String?,
            var img: String?,
            var url: String?,
            var title: String?,
            var contentHtml: String?,
            var datePublished: Date?
)
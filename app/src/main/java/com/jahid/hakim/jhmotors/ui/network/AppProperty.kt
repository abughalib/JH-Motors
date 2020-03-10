package com.jahid.hakim.jhmotors.ui.network

import com.squareup.moshi.Json

data class AppProperty(
    val id: Int,
    val title: String,
    val model: String,
    @Json(name = "img_src") val imgSrcUrl: String)
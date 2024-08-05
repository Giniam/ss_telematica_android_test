package com.example.sstelematicaandroidtest.data.remote.response

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("html_url")
    val url: String,
)
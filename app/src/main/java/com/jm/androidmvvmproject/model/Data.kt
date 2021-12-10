package com.jm.androidmvvmproject.model

import com.google.gson.annotations.SerializedName

data class Quotes(

    @SerializedName("quote")
    val quoteStr: String?,
    @SerializedName("author")
    val authorStr: String?,
    @SerializedName("bio")
    val bioStr: String?,
    @SerializedName("img")
    val imgUri: String?
)


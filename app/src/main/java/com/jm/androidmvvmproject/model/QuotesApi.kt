package com.jm.androidmvvmproject.model

import io.reactivex.Single
import retrofit2.http.GET

interface QuotesApi {

    @GET("d3032ce98e63b176cc839f2f046e2ca2/raw/b138a660b5bc92286e19c83175ab2fbb633f4e80/favoritequotes.json")
    fun getQuotes(): Single<List<Quotes>>




}
package com.jm.androidmvvmproject.model

import com.jm.androidmvvmproject.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class QuotesService {


    @Inject
    lateinit var api: QuotesApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getQuotes(): Single<List<Quotes>>{
        return  api.getQuotes()
    }

}
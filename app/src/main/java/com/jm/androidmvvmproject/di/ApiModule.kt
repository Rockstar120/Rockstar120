package com.jm.androidmvvmproject.di

import com.jm.androidmvvmproject.model.QuotesApi
import com.jm.androidmvvmproject.model.QuotesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val Base_URL = "https://gist.github.com/JonathanMoreno14/"



    @Provides
    fun provideQuotesApi(): QuotesApi {


        return  Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(QuotesApi::class.java)
    }


    @Provides
    fun provideCountriesService(): QuotesService {
        return QuotesService()
    }




}
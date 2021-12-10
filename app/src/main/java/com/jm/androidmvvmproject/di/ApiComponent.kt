package com.jm.androidmvvmproject.di

import com.jm.androidmvvmproject.model.QuotesService
import com.jm.androidmvvmproject.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: QuotesService)

    fun inject(viewModel: ListViewModel)

}
package com.jm.androidmvvmproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jm.androidmvvmproject.di.DaggerApiComponent
import com.jm.androidmvvmproject.model.Quotes
import com.jm.androidmvvmproject.model.QuotesService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel: ViewModel(){

    @Inject
    lateinit var quotesService: QuotesService

    init {
        DaggerApiComponent.create().inject(this)
    }

    private val disposable = CompositeDisposable()

    val quotes = MutableLiveData<List<Quotes>>()
    val quotesLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()


    fun refresh() {
        fetchQuotes()
    }

    private  fun fetchQuotes(){

        loading.value = true
        disposable.add(
            quotesService.getQuotes()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Quotes>>(){
                    override fun onSuccess(value: List<Quotes>) {
                        quotes.value = value
                        quotesLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        quotesLoadError.value = true
                        loading.value = false

                    }
                })
        )

    }



    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }


}
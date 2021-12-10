package com.jm.androidmvvmproject

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jm.androidmvvmproject.model.Quotes
import com.jm.androidmvvmproject.model.QuotesService
import com.jm.androidmvvmproject.viewmodel.ListViewModel
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class ListViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var quotesService: QuotesService

    @InjectMocks
    var listViewModel = ListViewModel()

    private var testSingle: Single<List<Quotes>>? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun getQuotesSuccess() {
        val quotes = Quotes("quote", "author", "bio", "img")
        val countriesList = arrayListOf(quotes)

        testSingle = Single.just(countriesList)

        Mockito.`when`(quotesService.getQuotes()).thenReturn(testSingle)

        listViewModel.refresh()

        Assert.assertEquals(1, listViewModel.quotes.value?.size)
        Assert.assertEquals(false, listViewModel.quotesLoadError.value)
        Assert.assertEquals(false, listViewModel.loading.value)
    }


    @Test
    fun getQuotesFail() {
        testSingle = Single.error(Throwable())

        Mockito.`when`(quotesService.getQuotes()).thenReturn(testSingle)

        listViewModel.refresh()

        Assert.assertEquals(true, listViewModel.quotesLoadError.value)
        Assert.assertEquals(false, listViewModel.loading.value)
    }


    @Before
    fun setUpRxSchedulers() {
        val immediate = object : Scheduler() {
            override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
                return super.scheduleDirect(run, 0, unit)
            }

            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
            }
        }

        RxJavaPlugins.setInitIoSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitComputationSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitSingleSchedulerHandler { scheduler -> immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> immediate }
    }


}
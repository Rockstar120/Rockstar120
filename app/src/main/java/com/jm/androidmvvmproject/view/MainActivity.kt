package com.jm.androidmvvmproject.view

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.button.MaterialButton
import com.jm.androidmvvmproject.R

import com.jm.androidmvvmproject.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_quote.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val quotesAdapter = QuotesListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()


        quotesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = quotesAdapter

        }

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }


        observeViewModel()

    }



    fun observeViewModel(){
        viewModel.quotes.observe(this, Observer { quotes ->
            quotes?.let {
                quotesList.visibility = View.VISIBLE
                quotesAdapter.updateQuotes(it) }

        })


        viewModel.quotesLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if (it) View.VISIBLE else View.GONE }

        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let { loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it){
                    list_error.visibility = View.GONE
                    quotesList.visibility = View.GONE
                }

            }
        })


    }




}





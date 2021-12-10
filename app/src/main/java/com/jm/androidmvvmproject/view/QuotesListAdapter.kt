package com.jm.androidmvvmproject.view

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jm.androidmvvmproject.R
import com.jm.androidmvvmproject.model.Quotes
import com.jm.androidmvvmproject.util.getProgressDrawable
import com.jm.androidmvvmproject.util.loadImage
import kotlinx.android.synthetic.main.item_bio.view.*
import kotlinx.android.synthetic.main.item_quote.view.*
import kotlinx.android.synthetic.main.item_quote.view.author

class QuotesListAdapter(var quotes: ArrayList<Quotes>) : RecyclerView.Adapter<QuotesListAdapter.QuotesViewHolder>() {



fun updateQuotes(newQuotes: List<Quotes>){
    quotes.clear()
    quotes.addAll(newQuotes)
    notifyDataSetChanged()
}

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = QuotesViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_quote,parent, false)
    )


    override fun getItemCount() = quotes.size

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.bind(quotes[position])
    }

    class QuotesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private  val imageView = view.imageView
        //private  val authorImage = view.author_image
        private  val authorText = view.author
        private  val authorBio = view.bioInfo
        private  val authorQuote = view.authorQuote
        private  val progressDrawable = getProgressDrawable(view.context)

        fun bind(quotes: Quotes){

            authorText.text = quotes.authorStr
            authorBio.text = quotes.bioStr
            authorQuote.text = quotes.quoteStr
            imageView.loadImage(quotes.imgUri, progressDrawable)
         //   authorImage.loadImage(quotes.imgUri, progressDrawable)
        }





    }



}
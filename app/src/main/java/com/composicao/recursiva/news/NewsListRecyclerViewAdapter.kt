package com.composicao.recursiva.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.composicao.recursiva.R
import com.composicao.recursiva.news.modelos.News

typealias OnClickListener = (News) -> Unit

class NewsListRecyclerViewAdapter(private val listener: OnClickListener) :
    RecyclerView.Adapter<ViewHolder>() {

    private val news = mutableListOf<News>()

    fun updateNews(news: List<News>) {
        this.news.clear()
        this.news.addAll(news)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_list_news_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news[position], listener)
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textTitle = itemView.findViewById<TextView>(R.id.text_view_news_title)
    private val textContent = itemView.findViewById<TextView>(R.id.text_view_news_content)

    fun bind(news: News, listener: OnClickListener) {
        textTitle.text = news.title
        textContent.text = news.content
        itemView.setOnClickListener { listener(news) }
    }
}
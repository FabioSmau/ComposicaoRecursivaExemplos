package com.composicao.recursiva.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.composicao.recursiva.R
import com.composicao.recursiva.create.CreateUserActivity
import com.composicao.recursiva.news.modelos.News

class NewsListActivity : AppCompatActivity() {

    private val viewModel: NewsListViewModel by viewModels()
    private val adapter: NewsListRecyclerViewAdapter by lazy {
        NewsListRecyclerViewAdapter {
            newsClickListenerAction(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_news)
        setupViewModelObserver()
        setupButtonRegister()
        setupRecyclerView()
        setupNewsListObserver()
    }

    private fun setupViewModelObserver() {
        lifecycle.addObserver(viewModel)
    }

    private fun setupButtonRegister() {
        val button = findViewById<Button>(R.id.button_register)
        button.setOnClickListener {
            val intent = CreateUserActivity.createIntent(this)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_content)
        recyclerView.adapter = this.adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupNewsListObserver() {
        viewModel.newsLiveData().observe(this, Observer {
            adapter.updateNews(it)
        })
    }

    private fun newsClickListenerAction(selected: News) {
        Log.i("MainActivity", "Clicou na noticia: $selected")
    }
}
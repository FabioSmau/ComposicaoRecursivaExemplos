package com.composicao.recursiva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.composicao.recursiva.modelos.News

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
            Log.i("MainActivity", "Iniciar nova tela")
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
        Log.i("MainActivity", "Recebeu informações: $selected")
    }
}
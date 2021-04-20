package com.composicao.recursiva

import androidx.lifecycle.*
import com.composicao.recursiva.modelos.News
import com.composicao.recursiva.repositorios.NewsListRepository

class NewsListViewModel(
    private val repository: NewsListRepository = NewsListRepository()
) : ViewModel(), LifecycleObserver {

    private val news = MutableLiveData<List<News>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startViewModel() {
        fetchNewsFromRepository()
    }

    private fun fetchNewsFromRepository() {
        repository.getNews {
            news.value = it
        }
    }

    fun newsLiveData(): LiveData<List<News>> {
        return news
    }

}
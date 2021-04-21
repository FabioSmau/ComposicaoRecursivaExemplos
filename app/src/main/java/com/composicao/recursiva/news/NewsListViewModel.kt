package com.composicao.recursiva.news

import androidx.lifecycle.*
import com.composicao.recursiva.news.modelos.News
import com.composicao.recursiva.news.repositorios.NewsListRepository
import com.composicao.recursiva.news.repositorios.NewsListRepositoryFactory

class NewsListViewModel(
    private val remoteRepository: NewsListRepository = NewsListRepositoryFactory.create()
) : ViewModel(), LifecycleObserver {

    private val news = MutableLiveData<List<News>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startViewModel() {
        fetchNewsFromRepository()
    }

    private fun fetchNewsFromRepository() {
        remoteRepository.getNews {
            news.value = it
        }
    }

    fun newsLiveData(): LiveData<List<News>> {
        return news
    }

}
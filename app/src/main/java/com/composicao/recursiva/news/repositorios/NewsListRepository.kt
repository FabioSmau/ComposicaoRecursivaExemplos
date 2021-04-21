package com.composicao.recursiva.news.repositorios

import com.composicao.recursiva.news.modelos.News

typealias NewsListCallback = (List<News>) -> Unit

interface NewsListRepository {
    fun getNews(callback: NewsListCallback)
}
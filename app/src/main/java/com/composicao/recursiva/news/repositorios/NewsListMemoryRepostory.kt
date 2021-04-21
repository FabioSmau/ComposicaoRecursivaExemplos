package com.composicao.recursiva.news.repositorios

import com.composicao.recursiva.news.modelos.News

class NewsListMemoryRepostory : NewsListRepository {

    override fun getNews(callback: NewsListCallback) {
        val news = listOf(
            News(
                "Noticia 1",
                "Noticia 1 - Informações obtidas da memoria"
            ),
            News(
                "Noticia 2",
                "Noticia 2 - Informações obtidas da memoria"
            ),
            News(
                "Noticia 3",
                "Noticia 3 - Informações obtidas da memoria"
            ),
            News(
                "Noticia 4",
                "Noticia 4 - Informações obtidas da memoria"
            )
        )
        callback(news)
    }

}
package com.composicao.recursiva.news.repositorios

import com.composicao.recursiva.news.modelos.News


class NewsListRemoteRepository : NewsListRepository {

    override fun getNews(callback: NewsListCallback) {
        val news = listOf(
            News(
                "Noticia 1",
                "Noticia 1 - Informações recebidas em tempo real"
            ),
            News(
                "Noticia 2",
                "Noticia 2 - Informações recebidas em tempo real"
            ),
            News(
                "Noticia 3",
                "Noticia 3 - Informações recebidas em tempo real"
            ),
            News(
                "Noticia 4",
                "Noticia 4 - Informações recebidas em tempo real"
            ),
            News(
                "Noticia 5",
                "Noticia 5 - Informações recebidas em tempo real"
            ),
            News(
                "Noticia 6",
                "Noticia 6 - Informações recebidas em tempo real"
            )
        )
        callback(news)
    }

}
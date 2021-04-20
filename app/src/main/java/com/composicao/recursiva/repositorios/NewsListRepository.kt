package com.composicao.recursiva.repositorios

import com.composicao.recursiva.modelos.News

typealias NewsListCallback = (List<News>) -> Unit

class NewsListRepository {

    fun getNews(callback: NewsListCallback) {
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
            )
        )
        callback(news)
    }

}
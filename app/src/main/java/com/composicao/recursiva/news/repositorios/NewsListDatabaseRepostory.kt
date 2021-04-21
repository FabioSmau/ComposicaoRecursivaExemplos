package com.composicao.recursiva.news.repositorios

import com.composicao.recursiva.news.modelos.News

class NewsListDatabaseRepostory : NewsListRepository {

    override fun getNews(callback: NewsListCallback) {
        val news = listOf(
            News(
                "Noticia 1",
                "Noticia 1 - Informações obtidas do banco de dados"
            ),
            News(
                "Noticia 2",
                "Noticia 2 - Informações obtidas do banco de dados"
            ),
            News(
                "Noticia 3",
                "Noticia 3 - Informações obtidas do banco de dados"
            ),
            News(
                "Noticia 4",
                "Noticia 4 - Informações obtidas do banco de dados"
            ),
            News(
                "Noticia 5",
                "Noticia 5 - Informações obtidas do banco de dados"
            )
        )
        callback(news)
    }

}
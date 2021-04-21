package com.composicao.recursiva.news.repositorios

import java.util.*
import java.util.concurrent.TimeUnit

class NewsListCachedRepository(
    private val cachedRepository: NewsListRepository,
    private val updatedRepository: NewsListRepository,
    private val secondsToExpireCache: Int
) : NewsListRepository {

    private var lastCache: Date? = null

    override fun getNews(callback: NewsListCallback) {
        if (cacheIsValid()) {
            cachedRepository.getNews(callback)
        } else {
            callUpdatedRepository(callback)
        }
    }

    private fun callUpdatedRepository(callback: NewsListCallback) {
        updatedRepository.getNews {
            updateLastCache()
            callback(it)
        }
    }

    private fun updateLastCache() {
        this.lastCache = Date()
    }

    private fun cacheIsValid(): Boolean {
        lastCache?.let {
            val miliSeconds =  Calendar.getInstance().timeInMillis - it.time
            val seconds = TimeUnit.MILLISECONDS.toSeconds(miliSeconds)
            if (seconds < secondsToExpireCache) {
                return true
            }
        }
        return false
    }

}
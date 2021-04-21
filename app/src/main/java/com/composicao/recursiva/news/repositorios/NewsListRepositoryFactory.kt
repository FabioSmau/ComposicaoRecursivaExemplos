package com.composicao.recursiva.news.repositorios

object NewsListRepositoryFactory {

    fun create(): NewsListRepository {
        val databaseRepostory = NewsListDatabaseRepostory()
        val remoteRepostory = NewsListRemoteRepository()
        val memoryCachedRepository = NewsListMemoryRepostory()

        val cachedRepository = NewsListCachedRepository(databaseRepostory, remoteRepostory, 30)

        val memoryWithCachedRepository: NewsListRepository = NewsListCachedRepository(memoryCachedRepository, cachedRepository, 15)


        return memoryWithCachedRepository
    }

}
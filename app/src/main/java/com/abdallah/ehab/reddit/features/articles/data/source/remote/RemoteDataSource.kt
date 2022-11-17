package com.abdallah.ehab.reddit.features.articles.data.source.remote

import com.abdallah.ehab.reddit.features.articles.data.source.remote.services.ArticlesService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val articlesService: ArticlesService) {

    suspend fun getArticles() =
        flow {
            emit(articlesService.getArticles())
        }

}
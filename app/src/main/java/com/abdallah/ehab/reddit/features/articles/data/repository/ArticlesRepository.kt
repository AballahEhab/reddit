package com.abdallah.ehab.reddit.features.articles.data.repository

import com.abdallah.ehab.reddit.utils.Result.*
import com.abdallah.ehab.reddit.features.articles.data.source.remote.RemoteDataSource
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class ArticlesRepository @Inject constructor(private val remoteSource: RemoteDataSource) {

    suspend fun getArticles() =
        remoteSource.getArticles().map { response ->
            if (response.isSuccessful)
                Success(response.body()?.data?.children)
            else
                Error(response.message())
        }
}
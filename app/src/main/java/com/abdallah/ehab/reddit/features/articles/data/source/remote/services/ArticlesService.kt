package com.abdallah.ehab.reddit.features.articles.data.source.remote.services
import com.abdallah.ehab.reddit.features.articles.data.models.AppResponse
import retrofit2.Response
import retrofit2.http.*

interface ArticlesService {

    @GET("r/kotlin/.json")
    suspend fun getArticles(): Response<AppResponse>

}
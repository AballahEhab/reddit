package com.abdallah.ehab.reddit.di

import com.abdallah.ehab.reddit.features.articles.data.source.remote.services.ArticlesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitObj(): Retrofit = Retrofit.Builder()
        .baseUrl("https://www.reddit.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideArticlesService(retrofitObj:Retrofit): ArticlesService = retrofitObj.create(ArticlesService::class.java)



}
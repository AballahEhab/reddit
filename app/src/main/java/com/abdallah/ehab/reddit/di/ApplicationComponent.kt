package com.abdallah.ehab.reddit.di

import com.abdallah.ehab.reddit.features.articles.data.repository.ArticlesRepository
import com.abdallah.ehab.reddit.features.articles.ui.view.ArticleDetailsFragment
import com.abdallah.ehab.reddit.features.articles.ui.view.ArticlesHomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun repository(): ArticlesRepository

    fun injectArticleDetailsFragmentFields(Fragment: ArticlesHomeFragment)

    fun injectArticleDetailsFragmentFields(Fragment: ArticleDetailsFragment)


}
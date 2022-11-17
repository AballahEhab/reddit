package com.abdallah.ehab.reddit.features.articles.ui.viewModel

import androidx.lifecycle.ViewModel
import com.abdallah.ehab.reddit.features.articles.data.models.ArticleData
import javax.inject.Inject

class DetailedArticleViewModel @Inject constructor() : ViewModel() {

    lateinit var articleDetails: ArticleData
}
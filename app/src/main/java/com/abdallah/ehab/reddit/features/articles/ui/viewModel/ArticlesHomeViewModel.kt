package com.abdallah.ehab.reddit.features.articles.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.abdallah.ehab.reddit.features.articles.data.models.Article
import com.abdallah.ehab.reddit.features.articles.data.repository.ArticlesRepository
import com.abdallah.ehab.reddit.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticlesHomeViewModel @Inject constructor(private val repository: ArticlesRepository) : ViewModel() {
    private lateinit var _articlesResult: LiveData<Result<List<Article>?>>

    val moviesReviewsResult: LiveData<Result<List<Article>?>> get() = _articlesResult


    init {
        getCriticMovieReviews()
    }

    private fun getCriticMovieReviews() {
        viewModelScope.launch {
            _articlesResult = repository.getArticles().asLiveData()
        }
    }
}
package com.abdallah.ehab.reddit.features.articles.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.abdallah.ehab.reddit.databinding.ItemArticlesHomeOverviewBinding
import com.abdallah.ehab.reddit.features.articles.data.models.Article
import com.abdallah.ehab.reddit.features.articles.ui.view.ArticlesHomeFragmentDirections

class ArticlesHomeAdapter : RecyclerView.Adapter<ArticlesHomeAdapter.ArticleCardViewHolder>() {

    var dataList: List<Article> = listOf()

    class ArticleCardViewHolder constructor(val binding: ItemArticlesHomeOverviewBinding) :
        ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleCardViewHolder =
        ArticleCardViewHolder(
            ItemArticlesHomeOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ArticleCardViewHolder, position: Int) {
        val article = dataList[position]

        holder.binding.article = article.data

        holder.binding.root.setOnClickListener {
            it.findNavController().navigate(
                ArticlesHomeFragmentDirections.actionArticlesHomeFragmentToArticlesDetailsFragment(
                    articleData = article.data!!
                )
            )
        }
    }

    override fun getItemCount(): Int = dataList.size

}
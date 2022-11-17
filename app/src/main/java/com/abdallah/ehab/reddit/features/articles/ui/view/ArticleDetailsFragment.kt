package com.abdallah.ehab.reddit.features.articles.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.abdallah.ehab.reddit.databinding.FragmentArticleDetailsBinding
import com.abdallah.ehab.reddit.RedditApplication
import com.abdallah.ehab.reddit.features.articles.ui.viewModel.DetailedArticleViewModel
import javax.inject.Inject


class ArticleDetailsFragment : Fragment() {

    @Inject
    lateinit var viewModel: DetailedArticleViewModel

    lateinit var binding: FragmentArticleDetailsBinding

    val args: ArticleDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArticleDetailsBinding.inflate(inflater,container,false)

        (context?.applicationContext as RedditApplication).appComponent.injectArticleDetailsFragmentFields(this)


        viewModel.articleDetails = args.articleData!!

        binding.articleData = viewModel.articleDetails


        return binding.root
    }
}
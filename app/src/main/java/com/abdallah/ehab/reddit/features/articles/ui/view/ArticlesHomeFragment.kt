package com.abdallah.ehab.reddit.features.articles.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.abdallah.ehab.reddit.databinding.FragmentArticlesHomeBinding
import com.abdallah.ehab.reddit.RedditApplication
import com.abdallah.ehab.reddit.features.articles.ui.adapters.ArticlesHomeAdapter
import com.abdallah.ehab.reddit.features.articles.ui.viewModel.ArticlesHomeViewModel
import com.abdallah.ehab.reddit.utils.isVisible
import javax.inject.Inject


class ArticlesHomeFragment : Fragment() {

    @Inject
    lateinit var articlesHomeViewModel: ArticlesHomeViewModel

    private lateinit var binding: FragmentArticlesHomeBinding

    private lateinit var adapter: ArticlesHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArticlesHomeBinding.inflate(inflater, container, false)

        (context?.applicationContext as RedditApplication).appComponent.injectArticleDetailsFragmentFields(
            this
        )

        initRecyclerView()

        articlesHomeViewModel.moviesReviewsResult.observe(viewLifecycleOwner) {
            it.handleRepoResponse(
                onLoading = {
                    showProgressBar()
                },
                onError = {
                    hideProgressBar()
                },
                onSuccess = {
                    hideProgressBar()
                    adapter.dataList = it.data!!
                    binding.moviesRecyclerV.adapter = adapter
                },
            )
        }
        return binding.root

    }

    private fun initRecyclerView() {
        adapter = ArticlesHomeAdapter()


        binding.moviesRecyclerV.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.moviesRecyclerV.adapter = adapter
    }

    private fun showProgressBar() = binding.progressBar.isVisible(true)

    private fun hideProgressBar() = binding.progressBar.isVisible(false)


}
package com.boozt.tvshowcase.main.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.domain.NetworkResponse
import com.boozt.tvshowcase.main.databinding.FragmentOverviewBinding
import com.boozt.tvshowcase.presentation.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OverviewFragment : Fragment() {

    private var binding: FragmentOverviewBinding? = null
    private val overviewViewModel: OverviewViewModel by viewModels()

    private val seasonsAdapter = SeasonsAdapter(::onItemClick)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.seasonsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = seasonsAdapter
        }

        binding!!.swipeRefreshLayout.apply {
            isRefreshing = true
            setOnRefreshListener(::onRefresh)
        }

        overviewViewModel.uiModel.observe(this.viewLifecycleOwner, ::onUiModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun onUiModel(uiModel: OverviewUiModel) {
        seasonsAdapter.submitList(uiModel.seasons)
        uiModel.refreshEvent?.getContentIfNotHandled()?.let {
            binding!!.swipeRefreshLayout.isRefreshing = false
            if (it !is NetworkResponse.Success) {
                binding!!.root.showSnackbar("Error! Try again")
            }
        }
    }

    private fun onItemClick(season: Model.Season) {
        val directions = OverviewFragmentDirections.navigateToSeason(season.title)
        findNavController().navigate(directions)
    }

    private fun onRefresh() {
        overviewViewModel.refresh()
    }
}
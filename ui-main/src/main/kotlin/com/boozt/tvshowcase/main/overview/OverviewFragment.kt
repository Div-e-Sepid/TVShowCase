package com.boozt.tvshowcase.main.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.boozt.tvshowcase.main.databinding.FragmentOverviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OverviewFragment : Fragment() {

    private var binding: FragmentOverviewBinding? = null
    private val overviewViewModel: OverviewViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        overviewViewModel.uiModel.observe(this.viewLifecycleOwner, ::onUiModel)
    }

    private fun onUiModel(uiModel: OverviewUiModel) {
        uiModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
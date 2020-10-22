package com.boozt.tvshowcase.main.season

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.boozt.tvshowcase.main.databinding.FragmentSeasonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeasonFragment : Fragment() {

    private var binding: FragmentSeasonBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSeasonBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
package com.boozt.tvshowcase.main.overview

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boozt.tvshowcase.domain.usecase.ObserveSeasonsUseCase
import com.boozt.tvshowcase.domain.usecase.RefreshSeasonsUseCase
import com.boozt.tvshowcase.presentation.Event
import com.boozt.tvshowcase.presentation.update
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class OverviewViewModel @ViewModelInject constructor(
    private val refreshSeasonsUseCase: RefreshSeasonsUseCase,
    private val observeSeasonsUseCase: ObserveSeasonsUseCase
) : ViewModel() {

    private val mutableUiModel = MutableLiveData(OverviewUiModel())
    val uiModel: LiveData<OverviewUiModel> = mutableUiModel

    init {
        refresh()
        viewModelScope.launch {
            observeSeasonsUseCase(Unit).collect { seasons ->
                mutableUiModel.update { it.copy(seasons = seasons) }
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            val networkResponse = refreshSeasonsUseCase(Unit)
            mutableUiModel.update { it.copy(refreshEvent = Event(networkResponse)) }
        }
    }
}
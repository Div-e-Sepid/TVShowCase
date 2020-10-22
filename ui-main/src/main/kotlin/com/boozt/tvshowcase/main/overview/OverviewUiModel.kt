package com.boozt.tvshowcase.main.overview

import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.domain.NetworkResponse
import com.boozt.tvshowcase.presentation.Event
import com.boozt.tvshowcase.presentation.UiModel

data class OverviewUiModel(
    val refreshEvent: Event<NetworkResponse<*>>? = null,
    val seasons: List<Model.Season>? = null
) : UiModel
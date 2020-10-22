package com.boozt.tvshowcase.data.datasource

import com.boozt.tvshowcase.domain.Model
import kotlinx.coroutines.flow.Flow

interface SeasonLocalDataSource : LocalDataSource<Model.Season> {

    fun fetch(): Flow<List<Model.Season>>

    suspend fun persist(seasons: List<Model.Season>)
}
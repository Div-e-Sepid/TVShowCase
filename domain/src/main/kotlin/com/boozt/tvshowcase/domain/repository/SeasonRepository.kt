package com.boozt.tvshowcase.domain.repository

import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.domain.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface SeasonRepository : Repository<Model.Season> {

    suspend fun refresh(): NetworkResponse<List<Model.Season>>

    fun get(): Flow<List<Model.Season>>
}
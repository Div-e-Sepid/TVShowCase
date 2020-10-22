package com.boozt.tvshowcase.network.datasource

import com.boozt.tvshowcase.data.datasource.SeasonRemoteDataSource
import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.domain.NetworkResponse
import com.boozt.tvshowcase.domain.map
import com.boozt.tvshowcase.network.api.Dto
import com.boozt.tvshowcase.network.api.ShowApi

class SeasonRemoteDataSourceImpl(
    private val showApi: ShowApi
) : SeasonRemoteDataSource {

    override suspend fun get(): NetworkResponse<List<Model.Season>> =
        execute {
            showApi.getShows()
        }.map(List<Dto.Show>::mapToModel)
}
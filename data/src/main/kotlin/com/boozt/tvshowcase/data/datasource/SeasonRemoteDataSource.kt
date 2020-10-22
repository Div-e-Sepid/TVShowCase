package com.boozt.tvshowcase.data.datasource

import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.domain.NetworkResponse

interface SeasonRemoteDataSource : RemoteDataSource<Model.Season> {

    suspend fun get(): NetworkResponse<List<Model.Season>>
}
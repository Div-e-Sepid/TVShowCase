package com.boozt.tvshowcase.data.repository

import com.boozt.tvshowcase.data.datasource.SeasonLocalDataSource
import com.boozt.tvshowcase.data.datasource.SeasonRemoteDataSource
import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.domain.NetworkResponse
import com.boozt.tvshowcase.domain.onSuccess
import com.boozt.tvshowcase.domain.repository.SeasonRepository
import kotlinx.coroutines.flow.Flow

class SeasonRepositoryImpl(
    private val remoteDataSource: SeasonRemoteDataSource,
    private val localDataSource: SeasonLocalDataSource
) : SeasonRepository {

    override suspend fun refresh(): NetworkResponse<List<Model.Season>> {
        return remoteDataSource.get().onSuccess {
            localDataSource.persist(it)
        }
    }

    override fun get(): Flow<List<Model.Season>> =
        localDataSource.fetch()
}
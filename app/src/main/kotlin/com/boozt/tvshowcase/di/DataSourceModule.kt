package com.boozt.tvshowcase.di

import com.boozt.tvshowcase.data.datasource.SeasonLocalDataSource
import com.boozt.tvshowcase.data.datasource.SeasonRemoteDataSource
import com.boozt.tvshowcase.network.api.ShowApi
import com.boozt.tvshowcase.network.datasource.SeasonRemoteDataSourceImpl
import com.boozt.tvshowcase.persistence.database.SeasonDao
import com.boozt.tvshowcase.persistence.datasource.SeasonLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun seasonRemoteDataSource(showApi: ShowApi): SeasonRemoteDataSource =
        SeasonRemoteDataSourceImpl(showApi)

    @Singleton
    @Provides
    fun seasonLocalDataSource(seasonDao: SeasonDao): SeasonLocalDataSource =
        SeasonLocalDataSourceImpl(seasonDao)
}
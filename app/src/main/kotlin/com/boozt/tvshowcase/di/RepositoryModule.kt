package com.boozt.tvshowcase.di

import com.boozt.tvshowcase.data.datasource.SeasonLocalDataSource
import com.boozt.tvshowcase.data.datasource.SeasonRemoteDataSource
import com.boozt.tvshowcase.data.repository.SeasonRepositoryImpl
import com.boozt.tvshowcase.domain.repository.SeasonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun seasonRepository(
        remoteDataSource: SeasonRemoteDataSource,
        localDataSource: SeasonLocalDataSource
    ): SeasonRepository =
        SeasonRepositoryImpl(remoteDataSource, localDataSource)
}
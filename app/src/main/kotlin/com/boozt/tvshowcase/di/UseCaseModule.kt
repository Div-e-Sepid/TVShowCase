package com.boozt.tvshowcase.di

import com.boozt.tvshowcase.domain.repository.SeasonRepository
import com.boozt.tvshowcase.domain.usecase.ObserveSeasonsUseCase
import com.boozt.tvshowcase.domain.usecase.RefreshSeasonsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun coroutineDispatcher(): CoroutineDispatcher =
        Dispatchers.IO

    @Singleton
    @Provides
    fun refreshSeasonsUseCase(
        seasonRepository: SeasonRepository,
        coroutineDispatcher: CoroutineDispatcher
    ): RefreshSeasonsUseCase =
        RefreshSeasonsUseCase(seasonRepository, coroutineDispatcher)

    @Singleton
    @Provides
    fun observeSeasonsUseCase(
        seasonRepository: SeasonRepository,
        coroutineDispatcher: CoroutineDispatcher
    ): ObserveSeasonsUseCase =
        ObserveSeasonsUseCase(seasonRepository, coroutineDispatcher)
}
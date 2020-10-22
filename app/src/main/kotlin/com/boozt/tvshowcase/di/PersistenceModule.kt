package com.boozt.tvshowcase.di

import android.content.Context
import androidx.room.Room
import com.boozt.tvshowcase.persistence.database.SeasonDao
import com.boozt.tvshowcase.persistence.database.TvShowCaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class PersistenceModule {

    @Singleton
    @Provides
    fun tvShowCaseDatabase(context: Context): TvShowCaseDatabase =
        Room.databaseBuilder(
            context,
            TvShowCaseDatabase::class.java, "database.db"
        ).build()

    @Singleton
    @Provides
    fun seasonDao(tvShowCaseDatabase: TvShowCaseDatabase): SeasonDao =
        tvShowCaseDatabase.seasonDao()
}
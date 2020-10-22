package com.boozt.tvshowcase.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Table.Season::class,
        Table.Episode::class
    ],
    version = 1
)
abstract class TvShowCaseDatabase() : RoomDatabase() {

    abstract fun seasonDao(): SeasonDao
}
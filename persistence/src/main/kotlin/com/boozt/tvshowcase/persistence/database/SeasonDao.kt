package com.boozt.tvshowcase.persistence.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import kotlinx.coroutines.flow.Flow

@Dao
interface SeasonDao {

    @Query("SELECT * FROM seasons")
    fun select(): Flow<List<SeasonEpisodes>>

    @Insert(onConflict = REPLACE)
    suspend fun insertShows(shows: List<Table.Season>)

    @Insert(onConflict = REPLACE)
    suspend fun insertEpisodes(episodes: List<Table.Episode>)

    @Transaction
    suspend fun insert(shows: List<Table.Season>, episodes: List<Table.Episode>) {
        insertShows(shows)
        insertEpisodes(episodes)
    }
}

data class SeasonEpisodes(
    @Embedded val season: Table.Season,
    @Relation(
        parentColumn = "title",
        entityColumn = "season_title"
    )
    val episodes: List<Table.Episode>
)
package com.boozt.tvshowcase.persistence.datasource

import com.boozt.tvshowcase.data.datasource.SeasonLocalDataSource
import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.persistence.database.SeasonDao
import com.boozt.tvshowcase.persistence.database.SeasonEpisodes
import com.boozt.tvshowcase.persistence.database.Table
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SeasonLocalDataSourceImpl(
    private val seasonDao: SeasonDao
) : SeasonLocalDataSource {

    override fun fetch(): Flow<List<Model.Season>> {
        return seasonDao.select().map { it.map(SeasonEpisodes::mapToModel) }
    }

    override suspend fun persist(seasons: List<Model.Season>) {
        val mutableEpisodes = mutableListOf<Table.Episode>()
        seasons.forEach { season ->
            mutableEpisodes.addAll(season.episodes.map { it.mapToTable(season.title) })
        }

        seasonDao.insert(seasons.map(Model.Season::mapToTable), mutableEpisodes)
    }
}
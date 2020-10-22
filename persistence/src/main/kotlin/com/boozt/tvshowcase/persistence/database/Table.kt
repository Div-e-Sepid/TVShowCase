package com.boozt.tvshowcase.persistence.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class Table {

    @Entity(tableName = "seasons")
    data class Season(
        @ColumnInfo(name = "title") @PrimaryKey val title: String,
    ) : Table()

    @Entity(tableName = "episode")
    data class Episode(
        @ColumnInfo(name = "title") @PrimaryKey val title: String,
        @ColumnInfo(name = "season_title") val seasonTitle: String,
        @ColumnInfo(name = "plot") val plot: String,
        @ColumnInfo(name = "rated") val rated: String,
        @ColumnInfo(name = "writer") val writer: String,
        @ColumnInfo(name = "actors") val actors: String,
        @ColumnInfo(name = "type") val type: String,
        @ColumnInfo(name = "imdb_votes") val imdbVotes: String,
        @ColumnInfo(name = "series_id") val seriesID: String,
        @ColumnInfo(name = "season") val season: String,
        @ColumnInfo(name = "director") val director: String,
        @ColumnInfo(name = "released") val released: String,
        @ColumnInfo(name = "awards") val awards: String,
        @ColumnInfo(name = "genre") val genre: String,
        @ColumnInfo(name = "imdb_rating") val imdbRating: String,
        @ColumnInfo(name = "poster") val poster: String,
        @ColumnInfo(name = "episode") val episode: String,
        @ColumnInfo(name = "language") val language: String,
        @ColumnInfo(name = "country") val country: String,
        @ColumnInfo(name = "runtime") val runtime: String,
        @ColumnInfo(name = "imdb_id") val imdbID: String,
        @ColumnInfo(name = "meta_score") val metaScore: String,
        @ColumnInfo(name = "response") val response: String,
        @ColumnInfo(name = "year") val year: String,
        @Embedded(prefix = "ratings") val ratings: Ratings
    ) : Table()

    data class Ratings(
        @ColumnInfo(name = "source") val source: String,
        @ColumnInfo(name = "value") val value: String
    ) : Table()
}
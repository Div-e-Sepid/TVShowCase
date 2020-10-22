package com.boozt.tvshowcase.network.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

sealed class Dto {

    @JsonClass(generateAdapter = true)
    data class Show(
        val title: String,
        val seasons: List<Seasons>
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Seasons(
        val episodes: List<Episode>
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Episode(
        @Json(name = "Plot") val plot: String,
        @Json(name = "Rated") val rated: String,
        @Json(name = "Title") val title: String,
        @Json(name = "Writer") val writer: String,
        @Json(name = "Actors") val actors: String,
        @Json(name = "Type") val type: String,
        @Json(name = "imdbVotes") val imdbVotes: String,
        @Json(name = "seriesID") val seriesID: String,
        @Json(name = "Season") val season: String,
        @Json(name = "Director") val director: String,
        @Json(name = "Released") val released: String,
        @Json(name = "Awards") val awards: String,
        @Json(name = "Genre") val genre: String,
        @Json(name = "imdbRating") val imdbRating: String,
        @Json(name = "Poster") val poster: String,
        @Json(name = "Episode") val episode: String,
        @Json(name = "Language") val language: String,
        @Json(name = "Country") val country: String,
        @Json(name = "Runtime") val runtime: String,
        @Json(name = "imdbID") val imdbID: String,
        @Json(name = "Metascore") val metaScore: String,
        @Json(name = "Response") val response: String,
        @Json(name = "Year") val year: String,
        @Json(name = "Ratings") val ratings: Ratings
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Ratings(
        @Json(name = "Source") val source: String,
        @Json(name = "Value") val value: String
    ) : Dto()
}
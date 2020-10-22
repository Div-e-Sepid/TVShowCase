package com.boozt.tvshowcase.domain

sealed class Model {

    data class Season(
        val title: String,
        val episodes: List<Episode>
    ) : Model()

    data class Episode(
        val plot: String,
        val rated: String,
        val title: String,
        val writer: String,
        val actors: String,
        val type: String,
        val imdbVotes: String,
        val seriesID: String,
        val season: String,
        val director: String,
        val released: String,
        val awards: String,
        val genre: String,
        val imdbRating: String,
        val poster: String,
        val episode: String,
        val language: String,
        val country: String,
        val runtime: String,
        val imdbID: String,
        val metaScore: String,
        val response: String,
        val year: String,
        val ratings: Ratings
    ) : Model()

    data class Ratings(
        val source: String,
        val value: String
    ) : Model()
}
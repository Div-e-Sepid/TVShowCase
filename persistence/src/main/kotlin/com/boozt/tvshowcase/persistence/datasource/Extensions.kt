package com.boozt.tvshowcase.persistence.datasource

import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.persistence.database.SeasonEpisodes
import com.boozt.tvshowcase.persistence.database.Table

fun Model.Season.mapToTable() = Table.Season(
        title = title
)

fun Model.Episode.mapToTable(seasonTitle: String) = Table.Episode(
        title = title,
        seasonTitle = seasonTitle,
        plot = plot,
        rated = rated,
        writer = writer,
        actors = actors,
        type = type,
        imdbVotes = imdbVotes,
        seriesID = seriesID,
        season = season,
        director = director,
        released = released,
        awards = awards,
        genre = genre,
        imdbRating = imdbRating,
        poster = poster,
        episode = episode,
        language = language,
        country = country,
        runtime = runtime,
        imdbID = imdbID,
        metaScore = metaScore,
        response = response,
        year = year,
        ratings = ratings.mapToTable()
)

fun Model.Ratings.mapToTable() = Table.Ratings(
        source = source,
        value = value
)

fun SeasonEpisodes.mapToModel() = Model.Season(
        title = season.title,
        episodes = episodes.map { it.mapToModel() }
)

fun Table.Episode.mapToModel() = Model.Episode(
        plot = plot,
        rated = rated,
        title = title,
        writer = writer,
        actors = actors,
        type = type,
        imdbVotes = imdbVotes,
        seriesID = seriesID,
        season = season,
        director = director,
        released = released,
        awards = awards,
        genre = genre,
        imdbRating = imdbRating,
        poster = poster,
        episode = episode,
        language = language,
        country = country,
        runtime = runtime,
        imdbID = imdbID,
        metaScore = metaScore,
        response = response,
        year = year,
        ratings = ratings.mapToModel()
)

fun Table.Ratings.mapToModel() = Model.Ratings(
        source = source,
        value = value
)
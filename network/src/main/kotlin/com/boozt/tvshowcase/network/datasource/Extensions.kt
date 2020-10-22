package com.boozt.tvshowcase.network.datasource

import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.domain.NetworkResponse
import com.boozt.tvshowcase.network.api.Dto
import retrofit2.Response

inline fun <T> execute(request: () -> Response<T>): NetworkResponse<T> =
    try {
        val response = request()
        if (response.isSuccessful) {
            NetworkResponse.Success(response.body()!!)
        } else {
            NetworkResponse.Failure(response.code())
        }
    } catch (ex: Exception) {
        NetworkResponse.Error(ex)
    }

fun List<Dto.Show>.mapToModel(): List<Model.Season> {
    val mutableSeasons = mutableListOf<Model.Season>()
    this[0].seasons.forEachIndexed { index, season ->
        mutableSeasons.add(
            Model.Season(
                title = index.toString(),
                episodes = season.episodes.map(Dto.Episode::mapToModel)
            )
        )
    }

    return mutableSeasons
}

fun Dto.Episode.mapToModel() = Model.Episode(
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

fun Dto.Ratings.mapToModel() = Model.Ratings(
    source = source,
    value = value
)
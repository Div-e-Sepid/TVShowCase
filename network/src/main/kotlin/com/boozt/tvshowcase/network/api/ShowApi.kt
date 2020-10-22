package com.boozt.tvshowcase.network.api

import retrofit2.Response
import retrofit2.http.GET

interface ShowApi {

    @GET("BlackGoblin/9c8b9a459f36473757b65cba7af8d292/raw/63ed5b6cd4f6b40790efcba81c7f23c33c89f7e5/gistfile1.txt")
    suspend fun getShows(): Response<List<Dto.Show>>
}
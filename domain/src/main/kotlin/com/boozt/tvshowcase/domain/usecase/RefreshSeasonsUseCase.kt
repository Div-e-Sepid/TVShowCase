package com.boozt.tvshowcase.domain.usecase

import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.domain.NetworkResponse
import com.boozt.tvshowcase.domain.repository.SeasonRepository
import kotlinx.coroutines.CoroutineDispatcher

class RefreshSeasonsUseCase(
    private val seasonRepository: SeasonRepository,
    coroutineDispatcher: CoroutineDispatcher
) : UseCase<Unit, NetworkResponse<List<Model.Season>>>(coroutineDispatcher) {

    override suspend fun execute(parameters: Unit): NetworkResponse<List<Model.Season>> =
        seasonRepository.refresh()
}
package com.boozt.tvshowcase.domain.usecase

import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.domain.repository.SeasonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class ObserveSeasonsUseCase(
    private val seasonRepository: SeasonRepository,
    coroutineDispatcher: CoroutineDispatcher
) : UseCase<Unit, Flow<List<Model.Season>>>(
    coroutineDispatcher
) {

    override suspend fun execute(parameters: Unit): Flow<List<Model.Season>> =
        seasonRepository.get()
}
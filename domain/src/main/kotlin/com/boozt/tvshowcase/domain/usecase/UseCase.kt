package com.boozt.tvshowcase.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<Input, Output>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(input: Input): Output =
        withContext(coroutineDispatcher) {
            execute(input)
        }

    protected abstract suspend fun execute(parameters: Input): Output
}
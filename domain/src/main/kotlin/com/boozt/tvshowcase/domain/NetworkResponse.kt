package com.boozt.tvshowcase.domain

sealed class NetworkResponse<out T> {

    data class Success<T>(
        val data: T
    ) : NetworkResponse<T>()

    data class Failure(
        val code: Int
    ) : NetworkResponse<Nothing>()

    data class Error(
        val throwable: Throwable
    ) : NetworkResponse<Nothing>()
}

inline fun <T> NetworkResponse<T>.onSuccess(block: (T) -> Unit): NetworkResponse<T> {
    if (this is NetworkResponse.Success) {
        block(this.data)
    }
    return this
}

inline fun <T, H> NetworkResponse<T>.map(block: (T) -> H): NetworkResponse<H> =
    when (this) {
        is NetworkResponse.Success -> NetworkResponse.Success(block(data))
        is NetworkResponse.Failure -> NetworkResponse.Failure(code)
        is NetworkResponse.Error -> NetworkResponse.Error(throwable)
    }
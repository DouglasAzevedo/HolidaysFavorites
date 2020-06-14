package br.edu.unisep.favoriteholidays.domain.base

sealed class ApiResult<out T> {
    data class Success<out T>(val result: T) : ApiResult<T>()

    data class Error(val message: String? = null) : ApiResult<Nothing>()
}

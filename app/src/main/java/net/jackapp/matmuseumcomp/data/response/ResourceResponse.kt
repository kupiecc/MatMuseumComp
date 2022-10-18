package net.jackapp.matmuseumcomp.data.response

sealed class ResourceResponse<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): ResourceResponse<T>(data)
    class Error<T>(message: String, data: T? = null): ResourceResponse<T>(data, message)
}
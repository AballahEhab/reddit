package com.abdallah.ehab.reddit.utils

sealed class Result<T>(
    val data: T? = null,
    val error: String? = null
) {

     class Success<T>(data: T) : Result<T>(data = data)
     class Error<T>(error: String, data: T? = null) : Result<T>(data = data, error =  error)

    fun handleRepoResponse(
        onLoading:  () -> Unit = { },
        onError:  () -> Unit,
        onSuccess:  () -> Unit){

        onLoading()
        when(this) {
            is Error -> onError()
            is Success -> onSuccess()
        }
    }
}

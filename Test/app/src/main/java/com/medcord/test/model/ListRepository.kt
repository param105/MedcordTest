package com.medcord.test.model;

import com.medcord.test.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ListRepository {

    fun getList(jsonObj:Map<String,String>, onResult: (isSuccess: Boolean, response: ApiResponse?) -> Unit) {

        try {

            ApiClient.instance.getList(jsonObj).enqueue(object : Callback<ApiResponse> {

                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response != null && response.isSuccessful)
                        onResult(true, response.body())
                    else
                        onResult(false, null)
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    onResult(false, null)
                }
            })

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {
        private var INSTANCE: ListRepository? = null
        fun getInstance() = INSTANCE
            ?: ListRepository().also {
                INSTANCE = it
            }
    }
}
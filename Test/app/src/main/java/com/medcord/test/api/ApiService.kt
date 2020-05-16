package com.medcord.test.api
import com.medcord.test.model.ApiResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

      @Headers("Content-Type: application/json")
    @POST("mhc/test_handle_click")
    fun getList(
        @Body jsonBody: Map<String,String> ): Call<ApiResponse>

}
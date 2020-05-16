package com.medcord.test.api
import com.medcord.test.model.ApiResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    /*
        url: https://qa-doctor.medcords.com/mhc/test_handle_click
        method: post
        content-type: "application/json"
        input: {bname: "<name of the clicked button>"}
        output: {data: {rstr: "<some random string>"}}

   */

    @Headers("Content-Type: application/json")
    @POST("mhc/test_handle_click")
    fun getList(
        @Body jsonBody: Map<String,String> ): Call<ApiResponse>

}
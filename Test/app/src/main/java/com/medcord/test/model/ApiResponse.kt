package com.medcord.test.model;

class ApiResponse(
    val status: String,
    val msg: String,
    val data:Data,
    val errCode: String
)

data class Data (
    val rstr : String
)
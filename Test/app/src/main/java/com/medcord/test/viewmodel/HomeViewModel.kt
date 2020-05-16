package com.medcord.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.medcord.test.model.ApiResponse
import com.medcord.test.model.ListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    var realdata = MutableLiveData<ApiResponse>()

    fun getData(jsonObj:HashMap<String,String>) {
        try {

            ListRepository.getInstance().getList(jsonObj) { isSuccess:Boolean, response:ApiResponse? ->
                if (isSuccess) {
                    CoroutineScope(Dispatchers.IO).launch {
                        realdata.postValue(response)
                    }
                }
            };
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }




}
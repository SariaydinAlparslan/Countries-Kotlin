package com.sariaydinalparslan.countries.viewmodel

import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sariaydinalparslan.countries.data.CountryModel
import com.sariaydinalparslan.countries.retrofit.RetroServiceInterface
import com.sariaydinalparslan.countries.retrofit.RetrofitInstance
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel :ViewModel(){

    var liveDataList : MutableLiveData<List<CountryModel>>

    init {
        liveDataList = MutableLiveData()
    }
    fun getLiveDataObserver():MutableLiveData<List<CountryModel>>{
        return  liveDataList
    }
    fun makeAPICall(){
       val retroInstance =  RetrofitInstance.getRetroInstance()
       val retroService = retroInstance.create(RetroServiceInterface::class.java)
      val call = retroService.getCountries()
        call.enqueue(object : Callback<List<CountryModel>>{
            override fun onResponse(
                call: retrofit2.Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
               liveDataList.postValue(response.body())
                println("$response")
            }

            override fun onFailure(call: retrofit2.Call<List<CountryModel>>, t: Throwable) {

            }

        })
    }
}
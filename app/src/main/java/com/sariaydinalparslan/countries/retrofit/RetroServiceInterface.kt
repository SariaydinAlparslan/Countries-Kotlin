package com.sariaydinalparslan.countries.retrofit

import com.sariaydinalparslan.countries.data.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {
    @GET("v2")
    fun getCountries(): Call<List<CountryModel>>

}
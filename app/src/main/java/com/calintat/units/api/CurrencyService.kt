package com.calintat.units.api

import retrofit2.Call
import retrofit2.http.GET

interface CurrencyService {

    @GET("latest?base=GBP")
    fun loadData(): Call<CurrencyData>
}
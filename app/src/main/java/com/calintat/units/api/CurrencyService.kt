package com.calintat.units.api

import retrofit2.Call
import retrofit2.http.GET

interface CurrencyService {

    @GET("latest") fun loadData(): Call<CurrencyData>
}
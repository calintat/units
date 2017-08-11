package com.calintat.units.utils

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyHelper : AnkoLogger {

    private val retrofit = Retrofit.Builder().baseUrl(FIXER_URL).addConverterFactory(GSON).build()

    private val currencyService = retrofit.create(CurrencyService::class.java)

    companion object {

        private val FIXER_URL = "http://api.fixer.io/"

        private val GSON = GsonConverterFactory.create()
    }

    fun loadData(onSuccess: (data: CurrencyData) -> Unit) {

        currencyService.loadData().enqueue(object : Callback<CurrencyData> {

            override fun onResponse(call: Call<CurrencyData>, response: Response<CurrencyData>) {

                debug("Received response from Fixer: $response")

                if (response.isSuccessful) response.body()?.let(onSuccess)
            }

            override fun onFailure(call: Call<CurrencyData>, t: Throwable) {

                debug("Failure. Exception occurred with message: ${t.message}")
            }
        })
    }
}
package com.chhaichivon.mvp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiService {

    private var retrofit: Retrofit? = null


    /**
     * This method creates a new instance of the API interface.
     *
     * @return The API interface
     */
    fun getAPI(): ApiService? {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(ApiService::class.java)
    }
}
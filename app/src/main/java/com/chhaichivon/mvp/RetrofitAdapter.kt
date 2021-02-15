package com.chhaichivon.mvp

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitAdapter {
    private var retrofit: Retrofit? = null
    private var gson: Gson? = null
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    @get:Synchronized
    val instance: Retrofit?
        get() {
            if (retrofit == null) {
                if (gson == null) {
                    gson = GsonBuilder().setLenient().create()
                }
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build()
            }
            return retrofit
        }
}
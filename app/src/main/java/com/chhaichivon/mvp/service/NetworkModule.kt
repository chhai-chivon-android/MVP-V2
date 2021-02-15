package com.chhaichivon.mvp.service

import com.chhaichivon.mvp.BuildConfig
import dagger.Provides
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.io.IOException
import java.lang.String
import javax.inject.Singleton


class NetworkModule {

    var cacheFile: File? = null

    fun NetworkModule(cacheFile: File?) {
        this.cacheFile = cacheFile
    }

    @Provides
    @Singleton
    fun provideCall(): Retrofit? {
        var cache: Cache? = null
        try {
            cache = Cache(cacheFile, 10 * 1024 * 1024)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(object : Interceptor() {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response? {
                    val original: Request = chain.request()
                    // Customize the request
                    val request: Request = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .header(
                            "Cache-Control",
                            String.format("max-age=%d", BuildConfig.CACHETIME)
                        )
                        .build()
                    val response: Response = chain.proceed(request)
                    response.cacheResponse()
                    // Customize or return the response
                    return response
                }
            })
            .cache(cache)
            .build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesNetworkService(
        retrofit: Retrofit
    ): PostService? {
        return retrofit.create(PostService::class.java)
    }

    @Provides
    @Singleton
    fun providesService(
        postNetworkService: PostNetworkService?
    ): PostNetworkService? {
        return PostNetworkService(postNetworkService)
    }
}
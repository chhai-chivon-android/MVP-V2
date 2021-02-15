package com.chhaichivon.mvp.service

import com.chhaichivon.mvp.model.Post
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface PostNetworkService {

    @GET("posts")
    fun findAll(@Query("_page") page: Int, @Query("_size") size: Int): Observable<List<Post>>

    @GET("posts/{postId}")
    fun findPostById(@Path("postId") postId: Int?) : Observable<Post>

//    @GET("posts")
//    fun findAll(@Query("_page") page: Int, @Query("_size") size: Int): Observable<List<Post>>
//
//    @GET("posts/{postId}")
//    fun findPostById(@Path("postId") postId: Int?) : Observable<Post>

}
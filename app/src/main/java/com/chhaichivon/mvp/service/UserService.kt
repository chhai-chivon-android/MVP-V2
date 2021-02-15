package com.chhaichivon.mvp.service

import com.chhaichivon.mvp.model.User
import retrofit2.http.GET
import rx.Observable


interface UserService {
    @GET("/posts/")
    fun users() : Observable<List<User>>?
}
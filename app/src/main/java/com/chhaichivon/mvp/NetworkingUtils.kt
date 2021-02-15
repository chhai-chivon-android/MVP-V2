package com.chhaichivon.mvp

import com.chhaichivon.mvp.RetrofitAdapter.instance
import com.chhaichivon.mvp.service.UserService


object NetworkingUtils {
    private var userService: UserService? = null
    val userApiInstance: UserService?
        get() {
            if (userService == null) userService = instance!!.create(UserService::class.java)
            return userService
        }
}
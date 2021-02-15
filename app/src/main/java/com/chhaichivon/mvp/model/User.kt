package com.chhaichivon.mvp.model

import com.google.gson.annotations.SerializedName


class User {
    @SerializedName("id")
    var id = 0

    @SerializedName("title")
    var title: String? = null

    @SerializedName("body")
    var body: String? = null

    @SerializedName("userId")
    var userId = 0

    override fun toString(): String {
        return "User{" +
                "id = '" + id + '\'' +
                ",title = '" + title + '\'' +
                ",body = '" + body + '\'' +
                ",userId = '" + userId + '\'' +
                "}"
    }
}
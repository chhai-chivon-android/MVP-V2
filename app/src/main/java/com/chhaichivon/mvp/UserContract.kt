package com.chhaichivon.mvp

import com.chhaichivon.mvp.model.User


interface UserContract {
    interface View {
        fun init()

        fun showError(message: String?)

        fun loadDataInList(users: List<User?>?)
    }

    interface Presenter {
        fun start()

        fun loadUsers()
    }

}
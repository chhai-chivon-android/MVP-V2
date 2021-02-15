package com.chhaichivon.mvp

import com.chhaichivon.mvp.NetworkingUtils.userApiInstance
import com.chhaichivon.mvp.model.User
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


object UserTask {

    fun getUsers(callback: Callback<List<User>>) {
        userApiInstance
                ?.users()
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.subscribe(object : Observer<List<User>> {

                    override fun onNext(users: List<User>) {
                        callback.returnResult(users)
                    }

                    override fun onError(e: Throwable) {
                        callback.returnError(e.message)
                    }

                    override fun onCompleted() {

                    }
                })
    }
}
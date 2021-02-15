package com.chhaichivon.mvp.service

import com.chhaichivon.mvp.model.Post
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class PostService(networkService: PostNetworkService) {

    private val networkService: PostNetworkService = networkService

    fun findAllPosts(callback: GetAllPostCallback): Subscription {
        return networkService.findAll(1,10)
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(object : Subscriber<List<Post?>>() {
               override fun onCompleted() {

               }

               override fun onError(e: Throwable?) {
                     callback.onError(NetworkError(e))
               }

               override fun onNext(t: List<Post?>?) {
                     callback.onSuccess(t as List<Post>?)
               }
           })
    }

    interface GetAllPostCallback {
        fun onSuccess(posts: List<Post>?)
        fun onError(networkError: NetworkError?)
    }


    fun findPostById(callback: GetPostByIdCallback) : Subscription {
        return networkService.findPostById(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Post?>(){
                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable?) {
                        callback.onError(NetworkError(e))
                    }

                    override fun onNext(t: Post?) {
                        callback.onSuccess(t)
                    }
                })
    }

    interface GetPostByIdCallback {
        fun onSuccess(posts: Post?)
        fun onError(networkError: NetworkError?)
    }
}
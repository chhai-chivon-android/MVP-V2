package com.chhaichivon.mvp

interface Callback<T> {
     fun returnResult(t: T)
     fun returnError(message: String?)
}
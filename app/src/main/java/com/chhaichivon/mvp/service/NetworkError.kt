package com.chhaichivon.mvp.service

class NetworkError(val error: Throwable?) : Throwable(error) {

    override val message: String
        get() = (error!!.message)!!

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that: NetworkError = o as NetworkError
        return if (error != null) (error == that.error) else that.error == null
    }

    override fun hashCode(): Int {
        return if (error != null) error.hashCode() else 0
    }

    companion object {
        val DEFAULT_ERROR_MESSAGE: String = "Something went wrong! Please try again."
        val NETWORK_ERROR_MESSAGE: String = "No Internet Connection!"
        private val ERROR_MESSAGE_HEADER: String = "Error-Message"
    }
}
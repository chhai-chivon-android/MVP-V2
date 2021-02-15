package com.chhaichivon.mvp

class UserPresenter( val mView: UserContract.View) : UserContract.Presenter {
    
    override fun start() {
        mView.init()
    }

    override fun loadUsers() {


    }

}
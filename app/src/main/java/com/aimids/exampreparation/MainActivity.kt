package com.aimids.exampreparation

import android.os.Bundle
import android.util.Log
import com.aimids.exampreparation.base.BaseActivity
import com.aimids.networkCore.BaseOperationListener
import com.aimids.networkLibrary.models.User
import com.aimids.networkLibrary.network.NetworkOperation

class MainActivity : BaseActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        NetworkOperation<User>().getUsers(User::class.java, GetOperationListener())
    }

    internal class GetOperationListener : BaseOperationListener<User>() {
        override fun onSuccess(tSuccessResult: Any) {
            super.onSuccess(tSuccessResult)
            if (tSuccessResult is User) {
                tSuccessResult.Id.let {
                    if (it != null) {
                        Log.d(TAG, it)
                    }
                }
            }
        }
    }
}

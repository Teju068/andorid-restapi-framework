package com.aimids.networkLibrary.network

import com.aimids.networkCore.BaseOperationListener
import com.aimids.networkCore.IOperationListener
import com.aimids.networkLibrary.models.User

interface INetworkOperation<TResult> {
    fun getUsers(tResult: Class<User>, operationResult: BaseOperationListener<User>)
}

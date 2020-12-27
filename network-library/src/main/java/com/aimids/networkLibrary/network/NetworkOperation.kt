package com.aimids.networkLibrary.network

import com.aimids.networkCore.BaseOperationListener
import com.aimids.networkCore.IOperationListener
import com.aimids.networkCore.ServiceOpRequestBuilder
import com.aimids.networkCore.enums.HttpRequestMethod
import com.aimids.networkLibrary.models.User

class NetworkOperation<TResult> :
    INetworkOperation<TResult> {

    override fun getUsers(tResult: Class<User>, operationResult: IOperationListener<User>) {
        val serviceOpRequestBuilder = ServiceOpRequestBuilder("", HttpRequestMethod.GET, tResult)
        serviceOpRequestBuilder.build().execute(operationResult as BaseOperationListener<User>)
    }
}

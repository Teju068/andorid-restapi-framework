package com.aimids.networkCore

import com.aimids.networkCore.models.FailureMessage

/**
 * a non abstract listener class to handle api result
 * @author tvishwakarma
 */
open class BaseOperationListener<TResult> : IOperationListener<TResult>() {
    override fun onSuccess(tSuccessResult: Any) {}
    override fun onFailure(failureMessage: FailureMessage) {}
}

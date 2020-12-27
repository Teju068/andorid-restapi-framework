package com.aimids.networkCore

import com.aimids.networkCore.models.FailureMessage

/**
 * an abstract class with abstract success and failure message
 * @author tvishwakarma
 */
abstract class IOperationListener<TResult> {
    abstract fun onSuccess(tSuccessResult: Any)
    abstract fun onFailure(failureMessage: FailureMessage)
}

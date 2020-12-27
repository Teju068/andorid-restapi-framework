package com.aimids.networkCore.models

import com.aimids.networkCore.enums.HttpRequestMethod
import okhttp3.Headers

data class DataRequest<TResult>(
    val requestMethod: HttpRequestMethod?,
    val pathSegment: String?,
    val queryParams: Map<String, String>?,
    val body: Any?,
    val headers: Headers,
    val tResult: Class<TResult>
)

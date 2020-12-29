package com.aimids.networkCore

import androidx.annotation.NonNull
import com.aimids.core.FoundationDeviceInfo
import com.aimids.networkCore.enums.HttpRequestMethod
import com.aimids.networkCore.models.DataRequest
import okhttp3.Headers
import java.util.UUID
import kotlin.collections.HashMap

/**
 * builder class
 */
class ServiceOpRequestBuilder<TResult>(
    private var pathSegment: String,
    private var requestMethod: HttpRequestMethod,
    private var resultClass: Class<TResult>
) {
    private var queryParams: Map<String, String>? = null
    private var body: String? = null
    private var headerMap = HashMap<String, String>()

    init {
        getGenericHeaders()
    }

    fun header(@NonNull header: MutableMap<String, String>): ServiceOpRequestBuilder<TResult> {
        this.headerMap.putAll(header)
        return this
    }

    fun queryParams(@NonNull queryParams: Map<String, String>): ServiceOpRequestBuilder<TResult> {
        this.queryParams = queryParams
        return this
    }

    fun body(@NonNull body: String): ServiceOpRequestBuilder<TResult> {
        this.body = body
        return this
    }

    fun build(): ServiceOperation<TResult> {
        val headers = getHeaders()
        val request =
            DataRequest(requestMethod, pathSegment, queryParams, body, headers, resultClass)
        return ServiceOperation(request)
    }

    private fun getGenericHeaders() {
        val headers = HashMap<String, String>()
        headers["Accept"] = "application/json"
        headers["request-id"] = generateUniqueRequestId()
        headers.putAll(getAppContextHeaders())
    }

    private fun getAppContextHeaders(): HashMap<String, String> {
        val appContextHeader = HashMap<String, String>()
        appContextHeader["deviceId"] = FoundationDeviceInfo.ANDROID
        return appContextHeader
    }

    private fun generateUniqueRequestId(): String {
        return UUID.randomUUID().toString()
    }

    private fun getHeaders(): Headers {
        val headerBuilder = Headers.Builder()
        for (key in headerMap.keys) {
            headerMap[key]?.let { headerBuilder.add(key, it) }
        }
        return headerBuilder.build()
    }
}

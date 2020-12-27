package com.aimids.networkCore

import androidx.annotation.NonNull
import com.aimids.networkCore.enums.HttpScheme
import com.aimids.networkCore.models.DataRequest
import com.aimids.networkCore.models.FailureMessage
import okhttp3.Request
import okhttp3.Callback
import okhttp3.Call
import okhttp3.Response
import okhttp3.HttpUrl
import java.io.IOException

class ServiceOperation<T>(private val dataRequest: DataRequest<T>) {

    private val client = NetworkHandles.getOkHttpClient()
    fun execute(operationListener: BaseOperationListener<T>) {
        val request = Request.Builder()
            .url(constructUrl(dataRequest))
            .headers(dataRequest.headers)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                operationListener.onFailure(FailureMessage())
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val data = response.body?.string()
                    data?.let {
                        operationListener.onSuccess(JsonParser.parse(data, dataRequest.tResult))
                    }
                }
            }

        })
    }

    private fun constructUrl(@NonNull dataRequest: DataRequest<T>): String {
        val uriBuilder = HttpUrl.Builder()
        uriBuilder.scheme(HttpScheme.HTTP.toString())
        uriBuilder.port(8080)
        uriBuilder.host(EndPointManager.LIVE_BASE_URL)

        if (dataRequest.pathSegment != null) {
            uriBuilder.addPathSegment(dataRequest.pathSegment)
        }
        if (dataRequest.queryParams != null && dataRequest.queryParams.isNotEmpty()) {
            for ((k, v) in dataRequest.queryParams) {
                uriBuilder.addQueryParameter(k, v)
            }
        }
        return uriBuilder.build().toString()
    }
}


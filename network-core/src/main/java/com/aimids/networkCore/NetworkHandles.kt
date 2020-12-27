package com.aimids.networkCore

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object NetworkHandles {
    private var client: OkHttpClient? = null
    private const val TIME_OUT = 120L
    fun getOkHttpClient(): OkHttpClient {
        if (client == null) {
            val builder = OkHttpClient.Builder()
            builder.callTimeout(TIME_OUT, TimeUnit.SECONDS)
            builder.readTimeout(TIME_OUT, TimeUnit.SECONDS)
            builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            builder.writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            client = builder.build()
        }
        return client as OkHttpClient
    }
}

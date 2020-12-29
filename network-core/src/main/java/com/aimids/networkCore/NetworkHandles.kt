package com.aimids.networkCore

import com.datatheorem.android.trustkit.pinning.OkHttp3Helper
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object NetworkHandles {
    private var client: OkHttpClient? = null
    private const val TIME_OUT = 120L
    fun getOkHttpClient(): OkHttpClient {
        if (client == null) {
            val builder = OkHttpClient.Builder()
                .callTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .sslSocketFactory(
                    OkHttp3Helper.getSSLSocketFactory(),
                    OkHttp3Helper.getTrustManager()
                )
                .addInterceptor(OkHttp3Helper.getPinningInterceptor())
                .followRedirects(false)
                .followSslRedirects(false)
            client = builder.build()
        }
        return client as OkHttpClient
    }
}

/*
* Copyright (c) 2020
*
* All rights reserved.
*
* THIS CODE AND INFORMATION ARE PROVIDED 'AS IS' WITHOUT WARRANTY OF ANY
* KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
* IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
* PARTICULAR PURPOSE.
*/

package com.aimids.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings.Global.getString
import android.provider.Settings.Secure.ANDROID_ID
import android.telephony.TelephonyManager
import androidx.annotation.NonNull

/**
 *  Foundation device info class to hold the device related info
 *  @author tvishwakarma
 */
class FoundationDeviceInfo(@NonNull context: Context) {

    private var foundationDeviceInfo: FoundationDeviceInfo? = null

    fun getInstance(): FoundationDeviceInfo? {
        if (foundationDeviceInfo == null) {
            foundationDeviceInfo = context?.let { FoundationDeviceInfo(it) }
        }
        return foundationDeviceInfo
    }

    private var context: Context? = null
    private var id: String = "null"
    private var os: String = "null"
    private var osType: String = "null"
    private var osName: String = "null"
    private var osVersion: String = "null"
    private var networkCarrier: String = "null"
    private var networkType: String = "null"
    private var phoneType: String = "null"
    private var countryCode: String = "null"

    private val wifiManager =
        context.applicationContext?.getSystemService(Context.WIFI_SERVICE) as WifiManager
    private var telephonyManager =
        context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    private val connectionInfo: WifiInfo = wifiManager.connectionInfo

    init {
        this.context = context
        this.id = getString(context.contentResolver, ANDROID_ID)
        this.os = ANDROID
        this.osType = ANDROID_TYPE
        this.osVersion = Build.VERSION.SDK_INT.toString()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.osName = Build.VERSION.BASE_OS
        }
        this.networkCarrier = connectionInfo.networkId.toString()
        this.phoneType = Build.MANUFACTURER
        this.networkType = getConnectionType(context)
        this.countryCode = telephonyManager.networkCountryIso
    }

    fun getId(): String {
        return id
    }

    companion object {
        const val ANDROID = "Android"
        const val ANDROID_TYPE = "Android"
    }

    private fun getConnectionType(context: Context): String {
        var result = "" // Returns connection type. 0: none; 1: mobile data; 2: wifi
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                            result = "Wifi"
                        }
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                            result = "Cellular"
                        }
                        hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> {
                            result = "vpn"
                        }
                    }
                }
            }
        }
        return result
    }
}

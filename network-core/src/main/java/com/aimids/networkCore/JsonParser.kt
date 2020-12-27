package com.aimids.networkCore

import com.google.gson.Gson

object JsonParser {
    fun parse(jsonResponse: String, tResult: Class<*>): Any {
        val gson = Gson()
        return gson.fromJson(jsonResponse, tResult)
    }
}

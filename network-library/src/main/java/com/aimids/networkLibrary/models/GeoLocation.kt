package com.aimids.networkLibrary.models

import com.google.gson.annotations.SerializedName

/**
 *  Model class to handle geo location
 *  @author tvishwakarma
 */
data class GeoLocation(
    @SerializedName("lat")
    var latitude: Double? = null,

    @SerializedName("lng")
    var longitude: Double? = null
)

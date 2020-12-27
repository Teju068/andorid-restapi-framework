package com.aimids.networkLibrary.models

import com.google.gson.annotations.SerializedName

/**
 * Address model class
 *  @author tvishwakarma
 */
data class Address(
    @SerializedName("street")
    var street: String? = null,

    @SerializedName("suite")
    var suite: String? = null,

    @SerializedName("city")
    var city: String? = null,

    @SerializedName("zipCode")
    var zipCode: String? = null,

    @SerializedName("geo")
    var geoLocation: GeoLocation? = null
)

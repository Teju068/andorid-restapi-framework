package com.aimids.networkLibrary.models

import com.google.gson.annotations.SerializedName

/**
 * model class for company details
 * @author tvishwakarma
 */
class Company(
    @SerializedName("name")
    var name: String? = null,

    @SerializedName("catchPhrase")
    var cachePhrase: String? = null,

    @SerializedName("bs")
    var bs: String? = null
)

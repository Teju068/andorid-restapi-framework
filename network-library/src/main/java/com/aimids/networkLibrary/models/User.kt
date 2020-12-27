package com.aimids.networkLibrary.models

import com.google.gson.annotations.SerializedName

/**
 *  User model class
 *  @author tvishwakarma
 */
data class User(
    @SerializedName("id")
    var Id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("address")
    var address: Address? = null,

    @SerializedName("company")
    var company: Company? = null
)

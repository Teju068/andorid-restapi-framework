package com.aimids.networkLibrary.models

data class Product(
    val Id: String,
    val description: String,
    val subDescription: String,
    val otherDescriptions: List<String>,
    val type: ProductType,
    val imageUrl: List<String>,
    val actualPrice: Int,
    val currencyCode: String,
    val isInOffer: Boolean,
    val offerPrice: Int
)

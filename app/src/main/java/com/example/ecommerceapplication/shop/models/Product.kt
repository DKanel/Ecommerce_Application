package com.example.ecommerceapplication.shop.models

import com.google.gson.annotations.SerializedName

data class Product(
    val productId : Int,
    @SerializedName("name") val productName: String,
    @SerializedName("desc") val productDescription: String,
    @SerializedName("imageUrl") val productImage: String
)

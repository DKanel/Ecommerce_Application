package com.example.ecommerceapplication.models

import android.media.Image
import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class Product(
    val productId : Int,
    @SerializedName("name") val productName: String,
    @SerializedName("desc") val productDescription: String,
    @SerializedName("imageUrl") val productImage: String
)

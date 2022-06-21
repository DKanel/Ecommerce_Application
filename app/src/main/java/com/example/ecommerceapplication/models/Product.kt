package com.example.ecommerceapplication.models

import android.media.Image

data class Product(
    val productId : Int,
    val productName: String,
    val productDescription: String,
//    val productImage: Image this is going to be a URL
)

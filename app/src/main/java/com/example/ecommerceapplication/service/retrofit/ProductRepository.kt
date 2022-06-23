package com.example.ecommerceapplication.service.retrofit

class ProductRepository constructor(private val retrofitInterface: RetrofitInterface) {

    fun getAllProducts() = retrofitInterface.getAllProducts()
}
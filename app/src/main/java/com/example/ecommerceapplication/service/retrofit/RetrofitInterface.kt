package com.example.ecommerceapplication.service.retrofit

import com.example.ecommerceapplication.models.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("movielist.json")
    fun getAllProducts(): Call<List<Product>>

    companion object{

        var retrofitService: RetrofitInterface? = null
        val url = "https://howtodoandroid.com/"

        fun getInstance(): RetrofitInterface{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitInterface::class.java)
            }
            return retrofitService!!
        }
    }
}
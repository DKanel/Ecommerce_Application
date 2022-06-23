package com.example.ecommerceapplication.views.viewmodels

import android.content.ContentValues
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapplication.models.Product
import com.example.ecommerceapplication.service.retrofit.ProductRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecyclerViewViewModel constructor(private val repository: ProductRepository): ViewModel() {

    val productsList = MutableLiveData<List<Product>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllProducts(){
        val  response = repository.getAllProducts()
        response.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>){
                productsList.postValue(response.body())
                Log.d(ContentValues.TAG, "response: ${productsList.value}")
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable){
                errorMessage.postValue(t.message)
            }
        })
    }
}
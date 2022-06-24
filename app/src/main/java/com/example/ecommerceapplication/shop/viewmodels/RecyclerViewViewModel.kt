package com.example.ecommerceapplication.shop.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapplication.shop.models.Product
import com.example.ecommerceapplication.service.retrofit.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*


class RecyclerViewViewModel constructor(private val repository: ProductRepository): ViewModel() {

    val productsList = MutableLiveData<List<Product>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllProducts(){
        GlobalScope.launch(Dispatchers.IO) {
            val response = repository.getAllProducts().awaitResponse()
            if (response.isSuccessful) {
                productsList.postValue(response.body()!!)
            }
        }
    }
}
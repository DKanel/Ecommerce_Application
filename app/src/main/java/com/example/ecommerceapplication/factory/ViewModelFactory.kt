package com.example.ecommerceapplication.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceapplication.service.retrofit.ProductRepository
import com.example.ecommerceapplication.views.viewmodels.RecyclerViewViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory constructor(private val repository: ProductRepository): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        return if (modelClass.isAssignableFrom(RecyclerViewViewModel::class.java)){
            RecyclerViewViewModel(this.repository) as T
        } else{
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}
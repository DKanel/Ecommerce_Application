package com.example.ecommerceapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceapplication.views.viewmodels.RecyclerViewViewModel

class ViewModelFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RecyclerViewViewModel::class.java)){
            return RecyclerViewViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}
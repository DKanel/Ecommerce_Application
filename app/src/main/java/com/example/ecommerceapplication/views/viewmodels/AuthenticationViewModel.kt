package com.example.ecommerceapplication.views.viewmodels

import androidx.lifecycle.ViewModel
import com.example.ecommerceapplication.R
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText


class AuthenticationViewModel: ViewModel() {

    fun checkEmail(email: String): String{
        if (email == "temp@gmail.com"){
            return "Success"
        }else
        {
            return "Error"
        }
    }

    fun checkPassword(password: String): String {
        if (password == "1234"){
            return "Success"
        }else{
            return "Error"
        }
    }
}
package com.example.ecommerceapplication.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.shop.views.fragments.ShopRecyclerViewFragment
import com.example.ecommerceapplication.views.fragments.LoginFragment
import com.example.ecommerceapplication.views.fragments.RegisterFragment
import com.example.ecommerceapplication.views.viewmodels.AuthenticationViewModel
import com.google.android.material.textfield.TextInputEditText

class AuthenticationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)


            val fragment: Fragment? =

            supportFragmentManager.findFragmentByTag(LoginFragment::class.java.simpleName)

            if (fragment !is LoginFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container_authentication, LoginFragment(), LoginFragment::class.java.simpleName)
                    .commit()
        }
    }
}
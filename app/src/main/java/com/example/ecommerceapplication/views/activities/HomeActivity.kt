package com.example.ecommerceapplication.views.activities

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.adapters.RecyclerViewAdapter
import com.example.ecommerceapplication.factory.ViewModelFactory
import com.example.ecommerceapplication.models.Product
import com.example.ecommerceapplication.service.retrofit.ProductRepository
import com.example.ecommerceapplication.service.retrofit.RetrofitInterface
import com.example.ecommerceapplication.views.fragments.RecyclerViewFragment
import com.example.ecommerceapplication.views.viewmodels.RecyclerViewViewModel

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val checkBox = intent.getIntExtra("checkBox",0)


        if (checkBox == 1){

            val recyclerViewFragment = RecyclerViewFragment()
            val fragment: Fragment? =

            supportFragmentManager.findFragmentByTag(RecyclerViewFragment::class.java.simpleName)

            if (fragment !is RecyclerViewFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, recyclerViewFragment, RecyclerViewFragment::class.java.simpleName)
                    .commit()
            }
        }

    }
}
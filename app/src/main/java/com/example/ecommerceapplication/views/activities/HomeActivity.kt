package com.example.ecommerceapplication.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.models.Product
import com.example.ecommerceapplication.recyclerView.RecyclerViewAdapter
import com.example.ecommerceapplication.views.viewmodels.RecyclerViewViewModel

class HomeActivity : AppCompatActivity() {

    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: RecyclerViewViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setTestList()

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView_Main)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = adapter
    }

    private fun setTestList(){
        val testProduct1 = Product(1,"test product","this is a test product")
        val testList: ArrayList<Product> = ArrayList()
        for (i in 1..10){
            testList.add(testProduct1)
        }
        adapter = RecyclerViewAdapter(testList)
    }
}
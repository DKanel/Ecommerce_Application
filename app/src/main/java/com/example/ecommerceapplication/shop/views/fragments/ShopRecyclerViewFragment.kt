package com.example.ecommerceapplication.shop.views.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.shop.adapters.ShopRecyclerViewAdapter
import com.example.ecommerceapplication.factory.ViewModelFactory
import com.example.ecommerceapplication.shop.models.Product
import com.example.ecommerceapplication.service.retrofit.ProductRepository
import com.example.ecommerceapplication.service.retrofit.RetrofitInterface
import com.example.ecommerceapplication.shop.viewmodels.RecyclerViewViewModel


class ShopRecyclerViewFragment : Fragment() {

    private lateinit var viewModel: RecyclerViewViewModel
    private lateinit var recyclerView: RecyclerView
    private var retrofitService = RetrofitInterface.getInstance()
    var productList: List<Product> = listOf()
    val adapter = ShopRecyclerViewAdapter(productList)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linearLayoutManager = LinearLayoutManager(view.context)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_Main)

        val viewModel = ViewModelProvider(this, ViewModelFactory(ProductRepository(retrofitService))).get(
            RecyclerViewViewModel::class.java)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
        viewModel.productsList.observe( viewLifecycleOwner, Observer {
            Log.d(ContentValues.TAG, "onCreate: $it")
            productList = it
            recyclerView.adapter = adapter
            adapter.setProductsList(it)
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {  })

        viewModel.getAllProducts()

    }

}
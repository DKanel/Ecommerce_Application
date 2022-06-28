package com.example.ecommerceapplication.blog.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.blog.adapter.BlogRecyclerViewAdapter
import com.example.ecommerceapplication.blog.model.BlogItem

class HomeBlogFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    var blogItem = BlogItem("kanel","the Great", "10/10/2010","supposed image")
    var blogItemList: List<BlogItem> = listOf(blogItem,blogItem,blogItem,blogItem,blogItem)
    private val adapter = BlogRecyclerViewAdapter(blogItemList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linearLayoutManager = LinearLayoutManager(view.context)
        recyclerView = view.findViewById<RecyclerView>(R.id.recycleView_blog)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }
}
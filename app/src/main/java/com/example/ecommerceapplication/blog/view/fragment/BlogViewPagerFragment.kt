package com.example.ecommerceapplication.blog.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.blog.adapter.TabLayoutAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


private const val NUM_PAGES = 3

class BlogViewPagerFragment : Fragment() {

    private lateinit var viewpager: ViewPager2
    private lateinit var tablayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blog_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tablayout = view.findViewById<TabLayout>(R.id.tablayout_viewpager)
        viewpager = view.findViewById<ViewPager2>(R.id.viewpager_blog)

        val adapter = TabLayoutAdapter(this)
        viewpager!!.adapter = adapter

        TabLayoutMediator(tablayout, viewpager) {tab,position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()


    }

}


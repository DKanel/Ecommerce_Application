package com.example.ecommerceapplication.blog.adapter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStateManagerControl
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecommerceapplication.blog.view.fragment.DetailsBlogFragment
import com.example.ecommerceapplication.blog.view.fragment.EmptyFragment
import com.example.ecommerceapplication.blog.view.fragment.HomeBlogFragment

class TabLayoutAdapter(fragment: Fragment ):FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        when (position){
            0->{
                return HomeBlogFragment()
            }
            1->{
                return DetailsBlogFragment()
            }
            else -> EmptyFragment()
        }
        return EmptyFragment()
    }


}
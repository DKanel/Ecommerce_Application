package com.example.ecommerceapplication.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.blog.view.fragment.BlogViewPagerFragment
import com.example.ecommerceapplication.shop.views.fragments.ShopRecyclerViewFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val checkBox = intent.getIntExtra("checkBox",0)

        //Open shop fragment
        if (checkBox == 1){

            val recyclerViewFragment = ShopRecyclerViewFragment()
            val fragment: Fragment? =

            supportFragmentManager.findFragmentByTag(ShopRecyclerViewFragment::class.java.simpleName)

            if (fragment !is ShopRecyclerViewFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, recyclerViewFragment, ShopRecyclerViewFragment::class.java.simpleName)
                    .commit()
            }
        }

        //Open blog fragment
        if (checkBox == 2){

            val blogFragment = BlogViewPagerFragment()
            val fragment: Fragment? =

                supportFragmentManager.findFragmentByTag(BlogViewPagerFragment::class.java.simpleName)

            if (fragment !is BlogViewPagerFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, blogFragment, BlogViewPagerFragment::class.java.simpleName)
                    .commit()
            }
        }

    }
}
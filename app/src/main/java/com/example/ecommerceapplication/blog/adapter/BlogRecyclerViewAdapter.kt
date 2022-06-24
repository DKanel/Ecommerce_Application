package com.example.ecommerceapplication.blog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.blog.model.BlogItem
import com.example.ecommerceapplication.shop.adapters.ShopRecyclerViewAdapter

class BlogRecyclerViewAdapter(private var blogItemList:List<BlogItem>): RecyclerView.Adapter<BlogRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_blog,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val blogItems = blogItemList[position]
        holder.author.setText(blogItems.author)
        holder.title.setText(blogItems.title)
        holder.date.setText(blogItems.date)
    }

    override fun getItemCount(): Int {
        return 5
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val author: TextView = itemView.findViewById<TextView>(R.id.textview_blog_name_of_author)
        val title: TextView = itemView.findViewById<TextView>(R.id.textview_blog_title)
        val date: TextView = itemView.findViewById<TextView>(R.id.textview_blog_date)
        val image: ImageView = itemView.findViewById<ImageView>(R.id.imageview_blog)
    }
}
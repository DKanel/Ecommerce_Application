package com.example.ecommerceapplication.recyclerView

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.models.Product

class RecyclerViewAdapter(private val productList: List<Product>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productItem = productList[position]
        holder.productTitle.setText(productItem.productName)
        holder.productDescription.setText(productItem.productDescription)
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val productTitle: TextView = itemView.findViewById<TextView>(R.id.textView_Product_Title)
        val productDescription: TextView = itemView.findViewById<TextView>(R.id.textView_Product_Description)
    }
}
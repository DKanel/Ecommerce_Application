package com.example.ecommerceapplication.shop.adapters

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.shop.models.Product
import com.squareup.picasso.Picasso

class ShopRecyclerViewAdapter(private var productList:List<Product>): RecyclerView.Adapter<ShopRecyclerViewAdapter.ViewHolder>() {

    val picasso = Picasso.get()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_shop,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productItem = productList[position]
        holder.productTitle.setText(productItem.productName)
        holder.productDescription.setText(productItem.productDescription)
        picasso.load(productList[position].productImage).into(holder.productImage)
    }

     fun setProductsList(product: List<Product>){
        this.productList = product
         Log.d(TAG,"ADAPTER $productList")
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val productTitle: TextView = itemView.findViewById<TextView>(R.id.textView_Product_Title)
        val productDescription: TextView = itemView.findViewById<TextView>(R.id.textView_Product_Description)
        val productImage: ImageView = itemView.findViewById<ImageView>(R.id.imageView_product)
    }
}
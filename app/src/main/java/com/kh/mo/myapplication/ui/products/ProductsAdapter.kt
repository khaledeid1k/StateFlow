package com.kh.mo.myapplication.ui.products

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kh.mo.myapplication.R
import com.kh.mo.myapplication.databinding.ItemProductBinding
import com.kh.mo.myapplication.model.Product

class ProductsAdapter(
    val onClick:(Int)->Unit, private val context: Context
) : ListAdapter<Product,ProductsAdapter.ProductsViewHolder>(ProductsDiffUtil()) {
lateinit var binding:ItemProductBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {


        return ProductsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_product,
                parent, false)
      )
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.nameProductI.text=item.title


        Glide.with(context).load(item.thumbnail).error(
            R.drawable.ic_launcher_background
        ).into(holder.binding.imageProductI)

        holder.binding.root .setOnClickListener {
            onClick(position)
        }

    }


    class ProductsDiffUtil :DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem===newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem==newItem
        }

    }
    class ProductsViewHolder (val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root)
}



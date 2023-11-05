package com.kh.mo.myapplication.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kh.mo.myapplication.model.Product
import com.kh.mo.myapplication.ui.products.ProductsAdapter


@BindingAdapter(value = ["app:setAdapter"])
fun  RecyclerView.setRecyclerItems(productsAdapter: ProductsAdapter) {
    this.adapter=productsAdapter
}

package com.kh.mo.myapplication.ui.products_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.kh.mo.myapplication.R
import com.kh.mo.myapplication.databinding.FragmentProductDetailsBinding
import com.kh.mo.myapplication.model.Product
import com.kh.mo.myapplication.ui.products.ProductsAdapter
import com.kh.mo.myapplication.ui.products.SendProduct
import com.kh.mo.myapplication.utils.Constants


class ProductDetailsFragment : Fragment(),SendProduct ,SendDataFromMain2toPD{
    lateinit var binding: FragmentProductDetailsBinding
    private var product: Product? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=  DataBindingUtil.inflate(
            inflater, R.layout.fragment_product_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
                product = savedInstanceState.getSerializable(Constants.product) as Product?
            Log.d("TAGdddddddd", "onrrrrInstanceState: $product")

        }


    }



    override fun sendReceivedData(product: Product) {
        Glide.with(requireActivity()).load(product.thumbnail).error(
            R.drawable.ic_launcher_background
        ).into(binding.imageViewProduct)
        binding.product=product

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAGdddddddd", "onDestroy: ")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(Constants.product, product)
        Log.d("TAGdddddddd", "onSaveInstanceState: $product")
    }

    override fun sendData(product: Product) {
        Glide.with(requireActivity()).load(product.thumbnail).error(
            R.drawable.ic_launcher_background
        ).into(binding.imageViewProduct)
        binding.product=product
    }


}
package com.kh.mo.myapplication.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kh.mo.myapplication.ApiState
import com.kh.mo.myapplication.R
import com.kh.mo.myapplication.databinding.FragmentProductsBinding
import com.kh.mo.myapplication.model.Product
import com.kh.mo.myapplication.repo.Repository
import kotlinx.coroutines.launch


class ProductsFragment : Fragment() {
    lateinit var binding : FragmentProductsBinding
    lateinit var productViewModel : ProductViewModel
    private  var productsList: List<Product?>?=null
    private lateinit var moveData: MoveData
    private lateinit var productsAdapterr:ProductsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       binding=  DataBindingUtil.inflate(
           inflater, R.layout.fragment_products, container, false)

        productsAdapterr = ProductsAdapter(::navToDetails, requireActivity())

        binding.apply {
            productsAdapter=productsAdapterr
            lifecycleOwner=this@ProductsFragment
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intiViewModel()
        inti()


    }
    private fun intiViewModel() {
        val showProductsViewModelFactory =
            ProductViewModelFactory(
                Repository()
            )
        productViewModel = ViewModelProvider(
            this,
            showProductsViewModelFactory
        )[ProductViewModel::class.java]
    }


    private fun inti() {
        moveData = activity as MoveData
        lifecycleScope.launch {
            productViewModel.products.collect{
                when(it){
                    is ApiState.Failure ->

                        Toast.makeText(requireContext(), "${it.msg.message}", Toast.LENGTH_SHORT).show()
                    is ApiState.Loading ->Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    is ApiState.Success ->
                    {
                        Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                        productsAdapterr.submitList(it.data.products)
                    }
                }

            }

        }


    }


    private fun navToDetails(position: Int) {
        productsList?.get(position)?.let { moveData.moveProduct(it) }

    }

}
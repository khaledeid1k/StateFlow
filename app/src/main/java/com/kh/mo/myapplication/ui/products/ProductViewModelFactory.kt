package com.kh.mo.myapplication.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kh.mo.myapplication.repo.Repository

class ProductViewModelFactory (private val repo:Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(ProductViewModel::class.java)){
            ProductViewModel(repo) as T
        }else{
            throw java.lang.IllegalArgumentException("")
        }

    }

}
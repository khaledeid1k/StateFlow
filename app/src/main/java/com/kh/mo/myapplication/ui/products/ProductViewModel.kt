package com.kh.mo.myapplication.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kh.mo.myapplication.ApiState
import com.kh.mo.myapplication.repo.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProductViewModel(private val repo: Repository) : ViewModel() {
    private val _products = MutableStateFlow<ApiState>(ApiState.Loading)
    val products: StateFlow<ApiState> = _products

    private fun getProducts(){
        viewModelScope.launch {
            repo.getProducts()
                .catch { m ->
                    _products.value = ApiState.Failure(m)
                }.collect { data -> _products.value = ApiState.Success(data)

                }


        }
    }
    init {
       getProducts()
    }



}
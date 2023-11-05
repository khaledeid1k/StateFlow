package com.kh.mo.myapplication.repo

import com.kh.mo.myapplication.model.ParenProduct
import com.kh.mo.myapplication.network.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository {

    private val api=API.retrofitService



      fun  getProducts():Flow<ParenProduct> =
          flow{
          api.getProducts()?.let { emit(it) }
      }



}
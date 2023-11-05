package com.kh.mo.myapplication.network

import com.kh.mo.myapplication.model.ParenProduct
import com.kh.mo.myapplication.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Network {
    @GET("products")
   suspend fun getProducts(): ParenProduct?

    @GET("products/{id}")
    suspend fun getItemProducts(@Path("id") id: Int): Response<Product?>
}
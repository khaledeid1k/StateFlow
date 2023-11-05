package com.kh.mo.myapplication.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkImp {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


}
object API {
    val retrofitService : Network by lazy {
        NetworkImp.retrofit.create(Network::class.java)
    }
}
package com.kh.mo.myapplication.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kh.mo.myapplication.model.Product

class Converters {
    private val gson = Gson()
    @TypeConverter
    fun fromProductList(products: List<Product?>): String {
        return gson.toJson(products)
    }

    @TypeConverter
    fun toProductList(productsString: String): List<Product?> {
        val listType = object : TypeToken<List<Product?>>() {}.type
        return gson.fromJson(productsString, listType)
    }
}

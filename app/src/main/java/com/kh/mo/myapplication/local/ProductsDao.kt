package com.kh.mo.myapplication.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kh.mo.myapplication.model.ParenProduct
import com.kh.mo.myapplication.model.Product


@Dao
interface ProductsDao {
    @Query("SELECT * FROM Products_table")
    suspend fun getAllProducts(): ParenProduct

    @Query("SELECT * FROM Product_table WHERE id = :productId LIMIT 1")
    suspend fun getProductById(productId: Int): Product?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllProducts(parenProduct: ParenProduct)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProduct(product: Product)
}



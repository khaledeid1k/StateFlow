package com.kh.mo.myapplication.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kh.mo.myapplication.model.ParenProduct
import com.kh.mo.myapplication.model.Product

@Database(entities = [Product::class, ParenProduct::class], version = 1)
@TypeConverters(Converters::class)

abstract class ProductsDataBase : RoomDatabase() {
    abstract fun productDao(): ProductsDao

    companion object {
        @Volatile
        private var productsDataBase: ProductsDataBase? = null
        fun getInstance(context: Context): ProductsDataBase {
            return productsDataBase ?: synchronized(this) {
                val instance = databaseBuilder(
                    context.applicationContext,
                    ProductsDataBase::class.java, "Product_DataBase"
                ).build()
                productsDataBase = instance
                instance
            }
        }
    }
}



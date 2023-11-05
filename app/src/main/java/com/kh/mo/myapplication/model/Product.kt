package com.kh.mo.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Product_table")
data class Product(
    @PrimaryKey
    @NotNull
     var id: Int ,
    val title: String? ,
    val description: String? ,
    val price: Double ,
    val discountPercentage: Double ,
    val rating: Double,
    val stock: Int ,
    val brand: String?,
    val thumbnail: String?

):java.io.Serializable


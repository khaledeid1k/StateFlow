package com.kh.mo.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products_table")
data class ParenProduct (@PrimaryKey val  id:Int =1,val products: List<Product?>)
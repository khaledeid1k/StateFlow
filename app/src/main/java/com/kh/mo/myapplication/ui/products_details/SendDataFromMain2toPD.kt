package com.kh.mo.myapplication.ui.products_details

import com.kh.mo.myapplication.model.Product

interface SendDataFromMain2toPD {
    fun sendReceivedData(product: Product)
}
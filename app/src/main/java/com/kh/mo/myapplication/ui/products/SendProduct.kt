package com.kh.mo.myapplication.ui.products

import com.kh.mo.myapplication.model.Product

interface SendProduct {
    fun sendData(product: Product)
}
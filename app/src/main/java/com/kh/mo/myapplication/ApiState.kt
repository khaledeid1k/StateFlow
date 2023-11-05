package com.kh.mo.myapplication

import com.kh.mo.myapplication.model.ParenProduct
import com.kh.mo.myapplication.model.Product

sealed class ApiState {
    class Success(val data:ParenProduct):ApiState()
    class Failure(val msg:Throwable):ApiState()
    object Loading:ApiState()
}
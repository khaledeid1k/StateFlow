package com.kh.mo.myapplication.ui.products_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.kh.mo.myapplication.R
import com.kh.mo.myapplication.databinding.ActivityMain2Binding
import com.kh.mo.myapplication.databinding.ActivityMainBinding
import com.kh.mo.myapplication.model.Product
import com.kh.mo.myapplication.ui.products.MainActivity
import com.kh.mo.myapplication.utils.Constants

class MainActivity2 : AppCompatActivity() {
    private lateinit var product: Product
    private lateinit var binding: ActivityMain2Binding

    private lateinit var sendDataFromMain2toPD: SendDataFromMain2toPD
    private lateinit var productDetailsFragment: ProductDetailsFragment
    private lateinit var fragmentTransaction: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(
            this,R.layout.activity_main2
        )
        binding.lifecycleOwner=this

        inti()
        addProductDetailsFragment()

    }

    private fun inti(){
        val fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
    }

    private fun addProductDetailsFragment() {
        productDetailsFragment = ProductDetailsFragment()
        fragmentTransaction.add(
            R.id.container2,
            productDetailsFragment,
            Constants.productDetailsFragment
        )
        fragmentTransaction.commit()
        sendDataFromMain2toPD=productDetailsFragment

    }
    private fun receiveData() {
        val receivedIntent = intent
        product = receivedIntent?.getSerializableExtra(Constants.dataBundle)as Product
        sendDataFromMain2toPD.sendReceivedData(product)
    }
    override fun onResume() {
        super.onResume()
        receiveData()

        backToMain()
    }
    private fun backToMain(){
        Constants.Flag = resources.configuration.orientation
        if (Constants.Flag == 2) {
            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(Constants.myData, product)
            intent.putExtra(Constants.dataBundle, bundle)
            startActivity(intent)
        }
    }

}